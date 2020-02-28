package com.riluca.healthyair.ui.home;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.riluca.healthyair.R;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private static final int MY_REQUEST_INT = 177;
    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;

    private HomeViewModel homeViewModel;
    private Object LatLng;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {//Carlos: Añado este metodo q veo en el video aunque no veo cambio
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        /*mMapView = mView.findViewById(R.id.maps);
        if (mMapView != null) {
            mMapView.onCreate(null); Lo traslado al metodo onViewCreated
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }*/
        return mView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Carlos: Traslado aqui la inicializacion del mMap
        mMapView = mView.findViewById(R.id.maps);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        /*LatLng bar1 = new LatLng(32.533890,-117.037507);
        mGoogleMap.addMarker(new MarkerOptions().position(bar1).title("Mamut (Calle 3ra)").snippet("Aquí se sirve la cerveza"));
        CameraPosition cameraP = CameraPosition.builder().target(bar1).zoom(16).bearing(0).tilt(45).build();
        //mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uem, 16));//Al añadir el entero acercas la vision
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraP));*/


        // Verificar permisos de localización.

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO:

            //Código para permiso no concedido.

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION}, MY_REQUEST_INT);
            }

            return;

        } else {
            //Código para permiso concedido.
            mGoogleMap.setMyLocationEnabled(true);
            getLastLocation();

            // Código para añadir marcador en el mapa
            LatLng = new LatLng(32.533890,-117.037507);
            LatLng bar2 = new LatLng(32.514054,-117.031813);
            mGoogleMap.addMarker(new MarkerOptions().position(bar2).title("Mamut (Calle 3ra)").snippet("Aquí se sirve la cerveza #1"));
            mGoogleMap.addMarker(new MarkerOptions().position(bar2).title("Cervecería Tijuana (Fundadores)").snippet("Aquí se sirve la cerveza #2"));
        }
    }
    private void getLastLocation() {
        FusedLocationProviderClient locationClient = LocationServices.getFusedLocationProviderClient(getActivity());
        try {
            ((FusedLocationProviderClient) locationClient).getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // GPS location can be null if GPS is switched off
                            if (location != null) {
                                if (mGoogleMap != null) {
                                    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                            new LatLng(location.getLatitude(),location.getLongitude()),15));
                                }
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("MapDemoActivity", "Error trying to get last GPS location");
                            e.printStackTrace();
                        }
                    });
        } catch (SecurityException e) { e.printStackTrace(); }
    }
}