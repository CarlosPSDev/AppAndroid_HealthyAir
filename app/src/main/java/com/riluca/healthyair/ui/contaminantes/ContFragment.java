package com.riluca.healthyair.ui.contaminantes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riluca.healthyair.R;

import java.util.ArrayList;

public class ContFragment extends Fragment {

    static final String CLAVE_ITEM = "ITEM";

    RecyclerView rv;
    LinearLayoutManager llm;
    ArrayList<ItemLista> listaDatos;
    ContAdaptador adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_contaminantes, container, false);

        rv = vista.findViewById(R.id.rvContaminantes);

        listaDatos = new ArrayList<>();

        llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        
        rellenarLista();

        adapter = new ContAdaptador(listaDatos);

        adapter.asignacionOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = rv.indexOfChild(v);
                ItemLista caso = listaDatos.get(i);

                //Intent intent = new Intent(getContext(), ContamInfoActivity.class);
                //intent.putExtra(CLAVE_ITEM, caso);
                //startActivity(intent);
            }
        });
        rv.setAdapter(adapter);

        return vista;
    }

    private void rellenarLista() {
        listaDatos.add(new ItemLista(R.drawable.o_2, "Oxígeno O2", "El oxígeno es un elemento químico de número atómico 8 y representado por el símbolo O. Su nombre proviene de las raíces griegas ὀξύς y –γόνος, porque en la época en que se le dio esta denominación se creía, incorrectamente, que todos los ácidos requerían oxígeno para su composición."));
        listaDatos.add(new ItemLista(R.drawable.co2,"Dióxido de Carbono CO2" , "El dióxido de carbono es un gas incoloro. Este compuesto químico está compuesto de un átomo de carbono unido con enlaces covalentes dobles a dos átomos de oxígeno. El CO₂ existe naturalmente en la atmósfera de la Tierra como gas traza en una fracción molar de alrededor de 400 ppm."));
        listaDatos.add(new ItemLista(R.drawable.o3, "Ozono O3", "El ozono es una sustancia cuya molécula está compuesta por tres átomos de oxígeno, formada al disociarse los dos átomos que componen el gas oxígeno. Cada átomo de oxígeno liberado se une a otra molécula de oxígeno gaseoso, formando moléculas de ozono."));
        listaDatos.add(new ItemLista(R.drawable.nitrogen, "Nitrógeno N2", "Se conoce como nitrógeno al elemento químico que se caracteriza por tener como número atómico al 7 y que se simboliza con la letra N. Se trata de un gas sin color ni olor y de carácter insípido que está presente en las cuartas quintas partes del aire de la atmósfera (en su versión molecular, es reconocido como N2)."));
        listaDatos.add(new ItemLista(R.drawable.water,"Agua H2O", "El agua es una sustancia cuya molécula está compuesta por dos átomos de hidrógeno y uno de oxígeno. El término agua generalmente se refiere a la sustancia en su estado líquido, aunque la misma puede hallarse en su forma sólida, llamada hielo, y en su forma gaseosa, denominada vapor"));
        listaDatos.add(new ItemLista(R.drawable.benceno, "Benceno C6H6", "El benceno es un hidrocarburo aromático de fórmula molecular C6H6, (originariamente a él y sus derivados se le denominaban compuestos aromáticos debido a la forma característica que poseen) también es conocido como benzol. En el benceno cada átomo de carbono ocupa el vértice de un hexágono regular, aparentemente tres de las cuatro valencias de los átomos de carbono se utilizan para unir átomos de carbono contiguos entre sí, y la cuarta valencia con un átomo de hidrógeno."));

    }
}