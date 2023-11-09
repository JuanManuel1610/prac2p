package com.example.prac2p;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import java.util.Timer;

public class Servicio extends Service {

    private String cadena;

    private int posicion = 0;

    public static Principal ACTUALIZA_TEXTO;

    private Timer tiempo = new Timer();

    private Handler handler= new Handler();

    public static void ACTUALIZA_ESCUCHA(Principal miactividad){
        ACTUALIZA_TEXTO = miactividad;
    }

    private void desplazar(){
        handler.postDelayed(() ->{
            if (posicion>cadena.length())posicion=0;
            ACTUALIZA_TEXTO.actualizatexto(cadena.substring(0,posicion++));
            desplazar();
        },1000);
    }

    public Servicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        cadena = ACTUALIZA_TEXTO.enviatexto;
        desplazar();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {super.onDestroy();}
}