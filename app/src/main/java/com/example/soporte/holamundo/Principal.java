package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private EditText cajaApellido;
    String genero, estadoCivil="";
    private Spinner comboGenero;
    private RadioButton r1, r2, r3;
    private ArrayAdapter<String> adapter;
    private String[] opc;
    private Intent i;
    private Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido =(EditText)findViewById(R.id.txtapellido);
        comboGenero = (Spinner)findViewById(R.id.cmbGenero);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);

       opc = this.getResources().getStringArray(R.array.generos);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc);

        comboGenero.setAdapter(adapter);

        i = new Intent(this,Saludo.class);
        b = new Bundle();
        //cajaMensaje = (TextView)findViewById(R.id.lblMensaje);

    }


    public void saludar(View v){

        String nombre, apellido;
        if (validar()){
        nombre = cajaNombre.getText().toString();
        apellido = cajaApellido.getText().toString();

            genero = comboGenero.getSelectedItem().toString();
            if(r1.isChecked()) estadoCivil = getResources().getString(R.string.soltero);
            if(r2.isChecked()) estadoCivil = getResources().getString(R.string.casado);
            if(r3.isChecked()) estadoCivil = getResources().getString(R.string.divorciado);


            b.putString("Nombre", nombre);
            b.putString("Apellido", apellido);
            b.putString("Genero", genero);
            b.putString("estadOCivil", estadoCivil);
            i.putExtras(b);

            startActivity(i);
        }

        //cajaMensaje.setText(getResources().getString(R.string.parte_saludo)+" "+aux);


    }

    public void borrar(View v){
        cajaNombre.setText("");
        cajaNombre.requestFocus();
        cajaApellido.setText("");
        comboGenero.setSelection(0);
        r1.setChecked(true);
    }

    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaNombre.setError(getResources().getString(R.string.error_1));
            return false;
        }

        if (cajaApellido.getText().toString().isEmpty()){
            //Toast.makeText(getApplicationContext(), "Digite por favor el apellido" , Toast.LENGTH_SHORT).show();
            cajaNombre.setError(getResources().getString(R.string.error_2));
            return false;
        }
        return true;
    }
}















