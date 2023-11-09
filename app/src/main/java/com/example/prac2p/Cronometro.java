package com.example.prac2p;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends Service {

    private Context ctx;
    Timer temporizador = new Timer();

    private static final long INTERVALO_ACTUALIZACION = 100;
    private double cronometro = 0;

    TextView textoactualiza,txtatras;
    public Cronometro(Context c) {
        super();
        this.ctx = c;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    private void InicializarCronometro(){
        temporizador.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cronometro+=0.01;
                /*aqui se manda la actualizacion de tipo text view*/
                textoactualiza.setText(String.valueOf(cronometro));

            }
        },0,INTERVALO_ACTUALIZACION);
    }
    public void setView(TextView txv){
        textoactualiza = txv;
        InicializarCronometro();
    }
    @Override
    public void onDestroy() {
        if (temporizador != null)
            temporizador.cancel();
        super.onDestroy();
    }

}