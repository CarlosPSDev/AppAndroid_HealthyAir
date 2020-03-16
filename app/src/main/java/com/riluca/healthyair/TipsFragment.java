package com.riluca.healthyair;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.riluca.healthyair.javabean.InterfaceMethods;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {
    Button btnOmitir;
    Button btnAvanzar;
    InterfaceMethods interfaz;


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
                interfaz.pasarAlMap(); //Si omiten los tips pasar al NavigationDrawer
            }
        });

        btnAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.llamarFrag(new TipsFrag2());
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
