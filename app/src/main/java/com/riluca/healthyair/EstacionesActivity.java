package com.riluca.healthyair;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;
import com.riluca.healthyair.javabean.Estacion;
import com.riluca.healthyair.javabean.EstacionesData;

import java.util.ArrayList;

public class EstacionesActivity extends AppCompatActivity {
   EstacionesData estD;
   ArrayList<Estacion>listaEstaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estaciones);
        estD = new EstacionesData();
        //estD.insertarEstacionesBD(); Ya están insertadas
        estD.consultarEstaciones();
    }

    public void imprimirEstaciones(View v){
        listaEstaciones = estD.getListadoEstaciones();
        Log.d("resul", "result Activity: " + estD.getListadoEstaciones().size() + listaEstaciones.size());
        for (Estacion estacion: listaEstaciones) {
            Log.d("resul", "result Activity: " + estacion.getNombre());
        }
    }




}
