package com.riluca.healthyair.ui.estaciones;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
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
                                Log.d("resul", "result Data: " + estacion.getNombre());

                                LatLng loc = new LatLng(Double.parseDouble(estacion.getLatitud()),
                                        Double.parseDouble(estacion.getLongitud())); //Aqui guarda directamente el valor de la estacion
                                mGoogleMap = googleMap;//<--Esto hay que volver a hacerlo en cada iteracion? Si ya esta arriba y no hace falta quitamos el Final
                                mGoogleMap.addMarker(new MarkerOptions()
                                        .position(loc)
                                        .title(estacion.getNombre())
                                        .snippet(estacion.getDireccion())
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.loc_estation)));
                                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc,11f ));
                                mGoogleMap.getUiSettings().setZoomControlsEnabled(true);

                            }

                        } else {
                            Log.w("Ha habido un error", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}