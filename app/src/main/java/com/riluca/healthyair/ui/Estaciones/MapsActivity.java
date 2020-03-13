package com.riluca.healthyair.ui.Estaciones;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
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

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<Estacion> listaEstaciones;
    private LocationManager locManager;
    private Location miLoc;
    private static final int PETICION_PERMISO_LOCALIZACION = 101;
    private Object LatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        listaEstaciones = new ArrayList<>();
        consultarEstaciones();

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    PETICION_PERMISO_LOCALIZACION);
        } else {
            Log.i("LOC", "con permisos");
            locManager = (LocationManager)getSystemService((LOCATION_SERVICE));
            miLoc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap = googleMap;

        LatLng uem = null;
        if (miLoc == null) {
            uem = new LatLng(40.535162, -3.6168482);
        } else {
            uem = new LatLng(miLoc.getLatitude(), miLoc.getLongitude());
        }
        mMap.addMarker(new MarkerOptions().position(uem).title("UEM")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uem, 14));

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Nueva posición")
                        .snippet("Lat: " + latLng.latitude + ", Long: " + latLng.longitude)
                        .icon(BitmapDescriptorFactory.defaultMarker(
                                BitmapDescriptorFactory.HUE_GREEN))
                );
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        });
    }

    public void consultarEstaciones(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Estaciones")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        listaEstaciones = new ArrayList<Estacion>();
                        Estacion estacion = null;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                estacion =  document.toObject(Estacion.class);
                                listaEstaciones.add(estacion);
                                //Log.d("resul", "result Data: " + estacion.getNombre());
                            }
                            recopilarMarcadores(listaEstaciones);
                            /*INVOCA AQUI A TU METODO PASANDOLE EL ARRAYLIST YA RELLENITO*/
                        } else {
                            Log.w("Ha habido un error", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    private void recopilarMarcadores(ArrayList<Estacion> listaEstaciones) {

        MapsInitializer.initialize(this);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        try {
            //for(int i=0 ; i< listaEstaciones.size() ; i++) {
            LatLng = new LatLng(32.533890,-117.037507);
            LatLng loc = new LatLng(32.514054,-117.031813);
            mMap.addMarker(new MarkerOptions().position(loc).title("Tu posición"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 14));
            mMap.getUiSettings().setZoomControlsEnabled(true);
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
