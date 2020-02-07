package com.riluca.healthyair;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {
    Button btnAtras;
    Button btnOmitir;
    Button btnAvanzar;


    public TipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tips, container, false);
        // Inflate the layout for this fragment

        //btnAtras = v.findViewById(R.id.btnAtras); No hay fragmento anterior
        btnOmitir= v.findViewById(R.id.btnOmitir);
        btnAvanzar = v.findViewById(R.id.btnAvanzar);

        btnOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hacer un intent al activity q va despues del login
            }
        });

        btnAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lanzar el siguiente fragmento
            }
        });

        return v;

    }

}
