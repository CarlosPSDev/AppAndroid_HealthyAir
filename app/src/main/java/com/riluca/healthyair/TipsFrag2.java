package com.riluca.healthyair;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.riluca.healthyair.javabean.InterfaceMethods;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFrag2 extends Fragment {
    Button btnSig;
    Button btnAtras;
    Button btnOmitir;
    InterfaceMethods interfaz;


    public TipsFrag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tips2, container, false);
        btnAtras = v.findViewById(R.id.btnAtras2);
        btnOmitir = v.findViewById(R.id.btnOmitir2);
        btnSig = v.findViewById(R.id.btnAvanzar2);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.llamarFrag(new TipsFragment()); //Cambiarlo, se llama al fragmento anterior (1)
            }
        });
        btnOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pasarAlMap(); //Para llamar pasar al mainActivity
            }
        });

        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.llamarFrag(new TipsFrag3()); //LLamamos al fragmento 3 (siguiente)
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) { //Aplicamos este método porque sino no funciona la interfaz en el activity!
        super.onAttach(context);
        if (context instanceof InterfaceMethods) {
            interfaz = (InterfaceMethods) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnControlerFragmentListener");
        }
    }

    @Override
    public void onDetach() { //Y este también para q se vioncule la interfaz al activity
        super.onDetach();
        interfaz = null;
    }

}
