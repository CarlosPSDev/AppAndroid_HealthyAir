package com.riluca.healthyair.ui.normative;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riluca.healthyair.R;

import java.util.ArrayList;

public class NormativeFragment extends Fragment {

    RecyclerView rv;
    LinearLayoutManager llm;
    ArrayList<Escenario> listaDatos;
    EscenarioAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_normative, container, false);

        rv = vista.findViewById(R.id.rvNormativa);
        listaDatos = new ArrayList<>();

        llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        rellenarLista();

        adapter = new EscenarioAdapter(listaDatos);
        rv.setAdapter(adapter);

        return vista;
    }

    private void rellenarLista() {
        listaDatos.add(new Escenario("ESCENARIO 1\n","Actuaciones:\n" +
                "· 1 día con superación del nivel de preaviso.\n " +
                "- Medidas de promoción del transporte público.\n" +
                "- Reducción de la velocidad a 70 km/h en la M-30 y accesos. "));
        listaDatos.add(new Escenario("ESCENARIO 2\n","Actuaciones:\n" +
                "· 2 días consecutivos con superación del nivel de preaviso o 1 día con superación del nivel de aviso.\n " +
                "- Medidas de promoción y refuerzo del transporte público.\n" +
                "- Reducción de la velocidad a 70 km/h en la M-30 y accesos.\n" +
                "- Prohibición de la circulación en el interior de la M-30 y por la M-30 a los\n" +
                "vehículos a motor, incluidos ciclomotores, que no tengan la clasificación\n" +
                "ambiental de “CERO EMISIONES”, “ECO”, “C” o “B” en el Registro de Vehículos\n" +
                "de la Dirección General de Tráfico.\n" +
                "- Prohibición del estacionamiento en las plazas y horario del Servicio de\n" +
                "Estacionamiento Regulado (SER) a los vehículos a motor que no tengan la clasificación ambiental de “CERO EMISIONES” o “ECO” en el Registro de\n" +
                "Vehículos de la Dirección General de Tráfico."));
        listaDatos.add(new Escenario("ESCENARIO 3\n" ,"Actuaciones:\n" +
                "· 3 días consecutivos con superación del nivel de preaviso o 2 días consecutivos con superación del nivel de aviso.\n " +
                "- Medidas de promoción y refuerzo del transporte público.\n" +
                "- Reducción de la velocidad a 70 km/h en la M-30 y accesos.\n" +
                "- Prohibición de la circulación en todo el término municipal a los vehículos a\n" +
                "motor, incluidos ciclomotores, que no tengan la clasificación ambiental de\n" +
                "“CERO EMISIONES”, “ECO”, “C” o “B” en el Registro de Vehículos de la\n" +
                "Dirección General de Tráfico.\n" +
                "- Prohibición del estacionamiento en las plazas y horario del Servicio de\n" +
                "Estacionamiento Regulado (SER) a los vehículos a motor que no tengan la\n" +
                "clasificación ambiental de “CERO EMISIONES” o “ECO” en el Registro de\n" +
                "Vehículos de la Dirección General de Tráfico.\n" +
                "- Se recomienda la no circulación de taxis libres, excepto Eurotaxis y vehículos\n" +
                "que tengan la clasificación ambiental de “CERO EMISIONES” o “ECO” en el\n" +
                "Registro de Vehículos de la Dirección General de Tráfico en todo el término\n" +
                "municipal. Estos vehículos podrán estacionar en las plazas del SER, además de\n" +
                "en sus paradas habituales a la espera de viajeros, en los términos que se\n" +
                "establezcan en la Ordenanza de Movilidad Sostenible"));
        listaDatos.add(new Escenario("ESCENARIO 4\n" , "Actuaciones:\n" +
                "· 4 días consecutivos con superación del nivel de aviso.\n " +
                "- Medidas de promoción y refuerzo del transporte público.\n" +
                "- Reducción de la velocidad a 70 km/h en la M-30 y accesos.\n" +
                "- Prohibición de la circulación en todo el término municipal a los vehículos a\n" +
                "motor, incluidos ciclomotores, que no tengan la clasificación ambiental de\n" +
                "“CERO EMISIONES”, “ECO”, “C” o “B” en el Registro de Vehículos de la\n" +
                "Dirección General de Tráfico. - Prohibición de la circulación en el interior de la M-30 y por la M-30 a los\n" +
                "vehículos a motor, incluidos ciclomotores, que no tengan la clasificación\n" +
                "ambiental de “CERO EMISIONES”, “ECO” o “C” en el Registro de Vehículos de\n" +
                "la Dirección General de Tráfico.\n" +
                "- Prohibición del estacionamiento en las plazas y horario del Servicio de\n" +
                "Estacionamiento Regulado (SER) a los vehículos a motor que no tengan la\n" +
                "clasificación ambiental de “CERO EMISIONES” o “ECO” en el Registro de\n" +
                "Vehículos de la Dirección General de Tráfico.\n" +
                "- Se recomienda la no circulación de taxis libres, excepto Eurotaxis y vehículos\n" +
                "que tengan la clasificación ambiental “CERO EMISIONES” o “ECO” en el\n" +
                "Registro de Vehículos de la Dirección General de Tráfico en todo el término\n" +
                "municipal. Estos vehículos podrán estacionar en las plazas del SER, además de\n" +
                "en sus paradas habituales a la espera de viajeros, en los términos que se\n" +
                "establezcan en la Ordenanza de Movilidad Sostenible"));
        listaDatos.add(new Escenario("ESCENARIO ALERTA\n", "Actuaciones:\n" +
                "- Medidas de promoción y refuerzo del transporte público.\n" +
                "- Reducción de la velocidad a 70 km/h en la M-30 y accesos\n" +
                "- Prohibición de la circulación en todo el término municipal a los vehículos a\n" +
                "motor, incluidos ciclomotores, que no tengan la clasificación ambiental de\n" +
                "“CERO EMISIONES” o “ECO en el Registro de Vehículos de la Dirección\n" +
                "General de Tráfico.\n" +
                "- Prohibición del estacionamiento en las plazas y horario del Servicio de\n" +
                "Estacionamiento Regulado (SER) a los vehículos a motor que no tengan la\n" +
                "clasificación ambiental de “CERO EMISIONES” en el Registro de Vehículos de la\n" +
                "Dirección General de Tráfico.\n" +
                "- Prohibición de la circulación de taxis libres, excepto Eurotaxis y vehículos que\n" +
                "tengan la clasificación ambiental de “CERO EMISIONES” o “ECO” en el Registro\n" +
                "de Vehículos de la Dirección General de Tráfico, en todo el término municipal. "));
    }

}