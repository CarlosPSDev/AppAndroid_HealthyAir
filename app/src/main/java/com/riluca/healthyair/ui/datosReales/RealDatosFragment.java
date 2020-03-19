package com.riluca.healthyair.ui.datosReales;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.riluca.healthyair.R;
import com.riluca.healthyair.javabean.ApiDatos;
import com.riluca.healthyair.javabean.DatoHorario;
import com.riluca.healthyair.javabean.Datos;
import com.riluca.healthyair.javabean.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class RealDatosFragment extends Fragment {
    RecyclerView rv;
    public RealDatosFragment() {}        // Required empty public constructor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {  // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_realdatos, container, false);
        rv = v.findViewById(R.id.rvRealDatos);
        consumirWs();
        return v;
    }

    private void consumirWs() {
        Retrofit r = RetrofitClient.getClient(ApiDatos.BASE_URL);
        ApiDatos aps = r.create(ApiDatos.class);
        Call<Datos> call = aps.obtenerDatos();
        call.enqueue(new Callback<Datos>() {
            @Override
            public void onResponse(Call<Datos> call, Response<Datos> response) {
                if(!response.isSuccessful()){
                    Log.i("WS", "Error" + response.code());
                } else {
                    Datos datos = response.body();
                    ArrayList<DatoHorario> listaDatos = datos.getListaDatos();
                    Log.d("res", "onResponse: " + listaDatos.size());
                    cargarRV(listaDatos);
                }
            }
            @Override
            public void onFailure(Call<Datos> call, Throwable t) {
                Log.e("ERROR WS", t.toString());
            }
        });
    }

    private void cargarRV(ArrayList<DatoHorario> listaDatos) {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        RealDatosAdapter rda = new RealDatosAdapter(listaDatos, getContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        rv.setAdapter(rda);
    }

}
