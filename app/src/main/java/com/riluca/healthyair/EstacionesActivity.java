package com.riluca.healthyair;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;
import com.riluca.healthyair.javabean.Estacion;

import java.util.ArrayList;

public class EstacionesActivity extends AppCompatActivity {
    FirebaseFirestore db; //referencia de fireCloud

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estaciones);

        db = FirebaseFirestore.getInstance(); //Inicializacion
        //ArrayList<Estacion> listaEstaciones = insertarEstaciones();
        //insertarEstacionesBD(listaEstaciones);
        //TODO Ya esta realizada la insercion

    }

    public void insertarEstacionesBD(ArrayList<Estacion> listaEstaciones){ //Las grabamos en la BD
        for (Estacion station: listaEstaciones) {
            db.collection("Estaciones").document(station.getId()).set(station);
        }
    }

    private ArrayList<Estacion> insertarEstaciones() { //Metodo para la insercion inicial en la BD, comentar despues
        ArrayList<Estacion> listaEstaciones = new ArrayList<Estacion>();
        listaEstaciones.add(new Estacion("4","-3.7122567","40.4238823"));
        listaEstaciones.add(new Estacion("8","-3.6823158","40.4215533"));
        listaEstaciones.add(new Estacion("16","-3.6392422","40.4400457"));
        listaEstaciones.add(new Estacion("18","-3.7318356","40.3947825"));
        listaEstaciones.add(new Estacion("24","-3.7473445","40.4193577"));
        listaEstaciones.add(new Estacion("35","-3.7031662","40.4192091"));
        listaEstaciones.add(new Estacion("36","-3.6453104","40.4079517"));
        listaEstaciones.add(new Estacion("38","-3.7071303","40.4455439"));
        listaEstaciones.add(new Estacion("39","-3.7115364","40.4782322"));
        listaEstaciones.add(new Estacion("54","-3.6121394","40.3730118"));
        listaEstaciones.add(new Estacion("56","-3.7187679","40.3850336"));
        listaEstaciones.add(new Estacion("58","-3.7746101","40.5180701"));
        listaEstaciones.add(new Estacion("59","-3.6163407","40.4607255"));
        listaEstaciones.add(new Estacion("102","-3.63563705","40.39979278"));
        listaEstaciones.add(new Estacion("103","-3.70952476","40.3506278"));
        listaEstaciones.add(new Estacion("104","-3.679722","40.3658333"));
        listaEstaciones.add(new Estacion("106","-3.74","40.442222"));
        listaEstaciones.add(new Estacion("107","-3.656667","40.462778"));
        listaEstaciones.add(new Estacion("108","-3.717881","40.4766333"));
        listaEstaciones.add(new Estacion("109","-3.69695","40.4319111"));
        listaEstaciones.add(new Estacion("110","-3.710792", "40.4156"));
        listaEstaciones.add(new Estacion("111","-3.6803686","40.4226491"));
        listaEstaciones.add(new Estacion("112","-3.666456","40.396472"));
        listaEstaciones.add(new Estacion("113","-3.666456","40.396472"));
        listaEstaciones.add(new Estacion("114","-3.697631","40.3925444"));
        //listaEstaciones.add(new Estacion("115","-3.697631","40.3925444")); No la añado x ser identica a la anterior
        return listaEstaciones;
    }
}
