package com.riluca.healthyair.ui.Estaciones;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.riluca.healthyair.R;
import com.riluca.healthyair.javabean.Estacion;

import java.util.ArrayList;

public class EstacionesFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    ArrayList<Estacion> resultadoConsulta = new ArrayList<>();

    private Object LatLng;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //consultarEstaciones();
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_estaciones, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = mView.findViewById(R.id.maps);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    /*@Override   COMENTO TU METODO PARA NO MODIFICAR NADA, Y HAGO EL MIO ABAJO A VER SI TIRA
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        for(int i = 0; i < resultadoConsulta.size(); i ++){

            Log.d("resul", "result Data EstacionesLocal: " + resultadoConsulta.size());
            //LatLng loc = new LatLng(40.534838332582964,-3.618579246103764);

            LatLng loc = new LatLng(Double.parseDouble(resultadoConsulta.get(i).getLatitud()),
                    Double.parseDouble(resultadoConsulta.get(i).getLongitud()));
            mGoogleMap = googleMap;
            mGoogleMap.addMarker(new MarkerOptions().position(loc)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            mGoogleMap.animateCamera(CameraUpdateFactory .newLatLngZoom (loc,14f ));
            mGoogleMap.getUiSettings().setZoomControlsEnabled(true);

        }
    }*/

    @Override
    public void onMapReady(final GoogleMap googleMap) { //Me ha obligado a ponerlo final peor no deberia suponer ningun problema
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        //Meto aqui la consulta
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
                                Log.d("resul", "result Data: " + estacion.getNombre()); //Se imprimen perfectamente
                          //Si quieres no hace falta ni hacer ArrayList, esta estacion se puede usar ya con los getter
                                LatLng loc = new LatLng(Double.parseDouble(estacion.getLatitud()),
                                        Double.parseDouble(estacion.getLongitud())); //Aqui guarda directamente el valor de la estacion
                                mGoogleMap = googleMap;//<--Esto hay que volver a hacerlo en cada iteracion? Si ya esta arriba
                                mGoogleMap.addMarker(new MarkerOptions().position(loc)
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                                mGoogleMap.animateCamera(CameraUpdateFactory .newLatLngZoom (loc,14f ));
                                mGoogleMap.getUiSettings().setZoomControlsEnabled(true);


                                //listaEstaciones.add(estacion);
                                //Log.d("resul", "result Data: " + estacion.getNombre());
                            }
                            //Log.d("resul", "result Data EstacionesLocal: " + listaEstaciones.size());//Imprime que tiene 26 elementos
                            //resultadoConsulta = listaEstaciones;
                            //Log.d("resul", "result Data resulConsulta: " + resultadoConsulta.size());

                        } else {
                            Log.w("Ha habido un error", "Error getting documents.", task.getException());
                        }
                    }
                });



        /*for(int i = 0; i < resultadoConsulta.size(); i ++){

            Log.d("resul", "result Data EstacionesLocal: " + resultadoConsulta.size());
            //LatLng loc = new LatLng(40.534838332582964,-3.618579246103764);

            LatLng loc = new LatLng(Double.parseDouble(resultadoConsulta.get(i).getLatitud()),
                    Double.parseDouble(resultadoConsulta.get(i).getLongitud()));
            mGoogleMap = googleMap;
            mGoogleMap.addMarker(new MarkerOptions().position(loc)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            mGoogleMap.animateCamera(CameraUpdateFactory .newLatLngZoom (loc,14f ));
            mGoogleMap.getUiSettings().setZoomControlsEnabled(true);

        }*/
    }

    /*public void consultarEstaciones(){
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
                            resultadoConsulta = listaEstaciones;
                            Log.d("resul", "result Data resulConsulta: " + resultadoConsulta.size());
                            *//*INVOCA AQUI A TU METODO PASANDOLE EL ARRAYLIST YA RELLENITO*//*
                        } else {
                            Log.w("Ha habido un error", "Error getting documents.", task.getException());
                        }
                    }
        });
    }*/
}