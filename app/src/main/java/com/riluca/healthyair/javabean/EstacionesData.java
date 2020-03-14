package com.riluca.healthyair.javabean;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstacionesData {
    private ArrayList<Estacion> listadoEstaciones;
    private FirebaseFirestore db;

    public EstacionesData() {
        listadoEstaciones = new ArrayList<Estacion>();
        db = FirebaseFirestore.getInstance();
    }

    /*public void consultarEstaciones(){
        db.collection("Estaciones")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        Estacion estacion = null;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                estacion =  document.toObject(Estacion.class);
                                listadoEstaciones.add(estacion);
                                Log.d("resul", "result Data: " + estacion.getNombre());
                            }

                            Log.d("resul", "result Data EstacionesLocal: " + listadoEstaciones.size());//Imprime que tiene 26 elementos
                        } else {
                            Log.w("Ha habido un error", "Error getting documents.", task.getException());
                        }
                    }
                });
    }*/

    /*public ArrayList<Estacion> getListadoEstaciones() {
        Log.d("resul", "getListadoEstaciones: " + listadoEstaciones.size());
        return listadoEstaciones;
    }*/

    public void insertarEstacionesBD(){ //Método para la inserción inicial de las estaciones en la BD
        ArrayList<Estacion> listaEstaciones = rellenarArray();
        for (Estacion station: listaEstaciones) {
            db.collection("Estaciones").document(station.getId()).set(station);
        }
    }

    private ArrayList<Estacion> rellenarArray() { //Metodo para generar ArrayList con estaciones
        ArrayList<Estacion> listaEstaciones = new ArrayList<Estacion>();
        listaEstaciones.add(new Estacion("4","Plaza España","Plaza de España","-3.7122567","40.4238823"));
        listaEstaciones.add(new Estacion("8","Escuelas Aguirre","Entre C/ Alcalá y C/ O’Donell","-3.6823158","40.4215533"));
        listaEstaciones.add(new Estacion("16","Arturo Soria","C/ Arturo Soria esq. C/ Vizconde de los Asilos","-3.6392422","40.4400457"));
        listaEstaciones.add(new Estacion("18","Farolillo","Calle Farolillo - C/Ervigio","-3.7318356","40.3947825"));
        listaEstaciones.add(new Estacion("24","Casa de Campo","Casa de Campo (Terminal del Teleférico)","-3.7473445","40.4193577"));
        listaEstaciones.add(new Estacion("35","Plaza del Carmen","Plaza del Carmen esq. Tres Cruces","-3.7031662","40.4192091"));
        listaEstaciones.add(new Estacion("36","Moratalaz","Avd. Moratalaz  esq. Camino de los Vinateros","-3.6453104","40.4079517"));
        listaEstaciones.add(new Estacion("38","Cuatro Caminos","Avd. Pablo Iglesias esq. C/ Marqués de Lema","-3.7071303","40.4455439"));
        listaEstaciones.add(new Estacion("39","Barrio del Pilar","Avd. Betanzos esq. C/ Monforte de Lemos ","-3.7115364","40.4782322"));
        listaEstaciones.add(new Estacion("54","Ensanche de Vallecas","Avda La Gavia / Avda. Las Suertes","-3.6121394","40.3730118"));
        listaEstaciones.add(new Estacion("56","Plaza Elíptica","Pza. Elíptica - Avda. Oporto","-3.7187679","40.3850336"));
        listaEstaciones.add(new Estacion("58","El Pardo","Avda. La Guardia","-3.7746101","40.5180701"));
        listaEstaciones.add(new Estacion("59","Juan Carlos I","Parque Juan Carlos I (frente oficinas mantenimiento)","-3.6163407","40.4607255"));
        listaEstaciones.add(new Estacion("102","J.M.D. Moratalaz", "C/ Fuente Carantona, 8","-3.63563705","40.39979278"));
        listaEstaciones.add(new Estacion("103","J.M.D. Villaverde","C/ Arroyo Bueno, 53","-3.70952476","40.3506278"));
        listaEstaciones.add(new Estacion("104","E.D.A.R. La China","Embajadores","-3.679722","40.3658333"));
        listaEstaciones.add(new Estacion("106","Centro Mpal. De Acústica","Autovía M-30 Km. 21.700","-3.74","40.442222"));
        listaEstaciones.add(new Estacion("107","J.M.D. Hortaleza","Ctra. de Canillas, 2","-3.656667","40.462778"));
        listaEstaciones.add(new Estacion("108","Peñagrande","C.D.M. Peñagrande","-3.717881","40.4766333"));
        listaEstaciones.add(new Estacion("109","J.M.D.Chamberí","Plaza de Chamberí, 4","-3.69695","40.4319111"));
        listaEstaciones.add(new Estacion("110","J.M.D.Centro","C/ Mayor, 72","-3.710792", "40.4156"));
        listaEstaciones.add(new Estacion("111","J.M.D.Chamartin","C/ Principe de Vergara, 142","-3.6803686","40.4226491"));
        listaEstaciones.add(new Estacion("112","J.M.D.Vallecas 1","Avda. Albufera, 42","-3.666456","40.396472"));
        listaEstaciones.add(new Estacion("113","J.M.D.Vallecas 2","Avda. Albufera, 42","-3.666456","40.396472"));
        listaEstaciones.add(new Estacion("114","Matadero 01","Paseo de la Chopera, 10","-3.697631","40.3925444"));
        listaEstaciones.add(new Estacion("115","Matadero 02","Paseo de la Chopera, 10","-3.697631","40.3925444"));
        return listaEstaciones;
    }
    public Map<String, String> mapearEstaciones(){
        Map<String, String>estaciones = new HashMap<String, String>();
        estaciones.put("004", "Pza. de España");
        estaciones.put("008", "Escuelas Aguirre");
        estaciones.put("011", "Av. Ramón y Cajal");
        estaciones.put("016", "Arturo Soria");
        estaciones.put("017", "Villaverde Alto");
        estaciones.put("018", "C/ Farolillo");
        estaciones.put("036", "Moratalaz");
        estaciones.put("024", "Casa de Campo");
        estaciones.put("027", "Barajas");
        estaciones.put("035", "Pza. del Carmen");
        estaciones.put("038", "Cuatro Caminos");
        estaciones.put("039", "Barrio del Pilar");
        estaciones.put("040", "Vallecas");
        estaciones.put("047", "Méndez Álvaro");
        estaciones.put("048", "Pº. Castellana");
        estaciones.put("049", "Retiro");
        estaciones.put("050", "Pza. Castilla");
        estaciones.put("054", "Ensanche Vallecas");
        estaciones.put("055", "Urb. Embajada (Barajas)");
        estaciones.put("056", "Plaza Elíptica");
        estaciones.put("057", "Sanchinarro");
        estaciones.put("058", "El Pardo");
        estaciones.put("059", "Parque Juan Carlos I");
        estaciones.put("060", "Tres Olivos");

        return estaciones;
    }
}
