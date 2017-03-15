package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private EditText cajaApellido;
    private Intent i;
    private Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido =(EditText)findViewById(R.id.txtapellido);
        i = new Intent(this,Saludo.class);
        b = new Bundle();
        //cajaMensaje = (TextView)findViewById(R.id.lblMensaje);
    }


    public void saludar(View v){

        String nombre, apellido;
        if (validar()){
        nombre = cajaNombre.getText().toString();
        apellido = cajaApellido.getText().toString();

            b.putString("Nombre", nombre);
            b.putString("Apellido", apellido);
            i.putExtras(b);

            startActivity(i);
        }

        //cajaMensaje.setText(getResources().getString(R.string.parte_saludo)+" "+aux);


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















