package com.riluca.healthyair.ui.datosReales;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.riluca.healthyair.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RealDatosFragment extends Fragment {


    public RealDatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_realdatos, container, false);
    }

}
