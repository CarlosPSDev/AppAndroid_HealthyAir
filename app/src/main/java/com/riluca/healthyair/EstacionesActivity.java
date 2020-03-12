package com.riluca.healthyair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.riluca.healthyair.javabean.Estacion;
import com.riluca.healthyair.javabean.EstacionesData;

import java.util.ArrayList;

public class EstacionesActivity extends AppCompatActivity {
   //EstacionesData estD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estaciones);
        //estD = new EstacionesData();
        //estD.insertarEstacionesBD(); Ya están insertadas

        consultarEstaciones(); //Nada mas cargar invoca a la consulta y cuando esté lista ya invoca ella al siguiente método

    }

    public void consultarEstaciones(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Estaciones")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        ArrayList<Estacion>listaEstaciones = new ArrayList<Estacion>();
                        Estacion estacion = null;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                estacion =  document.toObject(Estacion.class);
                                listaEstaciones.add(estacion);
                                //Log.d("resul", "result Data: " + estacion.getNombre());
                            }
                            //Log.d("resul", "result Data EstacionesLocal: " + listaEstaciones.size());//Imprime que tiene 26 elementos
                            imprimirEstaciones(listaEstaciones); //comentar despues, era una traza
            /*INVOCA AQUI A TU METODO PASANDOLE EL ARRAYLIST YA RELLENITO*/
                        } else {
                            Log.w("Ha habido un error", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void imprimirEstaciones(ArrayList<Estacion>listaEstaciones){  //Método traza, eliminar después
        for (Estacion estacion: listaEstaciones) {
            Log.d("resul", "result Activity: " + estacion.getNombre());
        }
    }

}
