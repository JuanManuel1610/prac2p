package com.example.prac2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    TextView txtcronometro, lblatras;

    Button btni, btnf;


    EditText texto;

    Button boton;

    private TextView etiqueta;

    public static String enviatexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtcronometro = findViewById(R.id.txtcronometro);
        btni = findViewById(R.id.btninicia);
        btnf = findViewById(R.id.btndetiene);

        texto = findViewById(R.id.txtcadena);
        boton = findViewById(R.id.btnservicio);
        etiqueta = findViewById(R.id.resultado);

        Cronometro cronometro = new Cronometro(getApplicationContext());
        btni.setOnClickListener(view -> {
            cronometro.setView(txtcronometro);

        });
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cronometro.onDestroy();
            }
        });

        //Aqui empieza el conteo de letras

        boton.setOnClickListener(view -> {
            enviatexto=texto.getText().toString();
            Intent servicio = new Intent(this, Servicio.class);
            startService(servicio);
        });
        Servicio.ACTUALIZA_ESCUCHA(this);

    }
    public void actualizatexto(String cadena){ etiqueta.setText(cadena);}
}