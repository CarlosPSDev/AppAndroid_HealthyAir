package com.riluca.healthyair;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.riluca.healthyair.javabean.InterfaceMethods;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFrag3 extends Fragment {
    InterfaceMethods interfaz;


    public TipsFrag3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tips_frag3, container, false);

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
