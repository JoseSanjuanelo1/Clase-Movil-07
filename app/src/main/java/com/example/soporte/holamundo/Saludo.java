package com.example.soporte.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView Saludo;
    private Bundle b;
    private String aux, nombre, apellido;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        Saludo = (TextView)findViewById(R.id.txtSaludo);
        b = getIntent().getExtras();
        nombre = b.getString("Nombre");
        apellido = b.getString("Apellido");
        res=this.getResources();
        aux = res.getString(R.string.parte_saludo)+" "+nombre+" "+apellido+" "+res.getString(R.string.parte_saludo2);
        Saludo.setText(aux);
    }
}
