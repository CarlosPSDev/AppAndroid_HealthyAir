package com.riluca.healthyair;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.riluca.healthyair.javabean.InterfaceMethods;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFrag3 extends Fragment {
    InterfaceMethods interfaz;
    Button btnSiguiente;
    Button btnAtras;
    Button btnOmitir;


    public TipsFrag3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tips_frag3, container, false);
        btnAtras = v.findViewById(R.id.btnAtras3);
        btnOmitir = v.findViewById(R.id.btnOmitir3);
        btnSiguiente = v.findViewById(R.id.btnAvanzar3);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.llamarFrag(new TipsFrag2()); //Cambiarlo, se llama al fragmento anterior (1)
            }
        });
        btnOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pasarAlMap(); //Para pasar al NavigationDrawer
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pasarAlMap(); //Para pasar al NavigationDrawer
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
