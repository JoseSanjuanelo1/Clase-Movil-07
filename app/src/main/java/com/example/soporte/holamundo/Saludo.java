package com.example.soporte.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView Saludo;
    private Bundle b;
    private String aux, nombre, apellido, estadoCivil, genero;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        Saludo = (TextView)findViewById(R.id.txtSaludo);
        b = getIntent().getExtras();
        nombre = b.getString("Nombre");
        apellido = b.getString("Apellido");
        genero = b.getString("Genero");
        estadoCivil = b.getString("estadOCivil");
        res=this.getResources();
        aux = res.getString(R.string.parte_saludo)+" "+nombre+" "+apellido+" "+res.getString(R.string.parte_saludo2);
        aux= aux+ "\n"+res.getString(R.string.datos);
        aux = aux+"\n\n"+res.getString(R.string.nombre)+": "+nombre;
        aux = aux+"\n"+res.getString(R.string.apellido)+": "+apellido;
        aux = aux+"\n"+res.getString(R.string.genero)+": "+genero;
        aux = aux+"\n"+res.getString(R.string.estadoCivil)+": "+estadoCivil;
        Saludo.setText(aux);
    }
}
