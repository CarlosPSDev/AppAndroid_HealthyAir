package com.riluca.healthyair.ui.datosReales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.riluca.healthyair.R;
import com.riluca.healthyair.javabean.DatoHorario;
import com.riluca.healthyair.javabean.EstacionesData;
import java.util.ArrayList;
import java.util.Map;

public class RealDatosAdapter extends RecyclerView.Adapter<RealDatosAdapter.DatoVH> {
    private ArrayList<DatoHorario>listaDatos;
    Context contexto;

    public RealDatosAdapter(ArrayList<DatoHorario> listaDatos, Context context) {
        this.listaDatos = listaDatos;
        contexto = context;
    }

    @NonNull
    @Override
    public DatoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dator, parent, false);
        return new DatoVH(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull DatoVH holder, int position) {
        holder.bindDato(listaDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }


    public class DatoVH extends RecyclerView.ViewHolder {

        private TextView tvProvincia;
        private TextView tvMunicipio;
        private TextView tvEstacion;
        private TextView tvFecha;
        private TextView tvMuestreo;
        private TextView tvMagnitud;
        private TextView tvNivel8am;
        private TextView tvNivel6pm;
        private TextView tvNive24pm;


        public DatoVH(@NonNull View v){
            super(v);
            tvProvincia = v.findViewById(R.id.tvProvincia);
            tvMunicipio = v.findViewById(R.id.tvMunicipio);
            tvEstacion = v.findViewById(R.id.tvEstacion);
            tvFecha = v.findViewById(R.id.tvFecha);
            tvMuestreo = v.findViewById(R.id.tvMuestreo);
            tvMagnitud = v.findViewById(R.id.tvMagnitud);
            tvNivel8am = v.findViewById(R.id.tvNivel8am);
            tvNivel6pm = v.findViewById(R.id.tvNivel16pm);
            tvNive24pm = v.findViewById(R.id.tvNivel24pm);
        }

        public void bindDato(DatoHorario datoH){
            EstacionesData ed = new EstacionesData();

            tvProvincia.setText(String.format(contexto.getString(R.string.tv_provincia), datoH.getProvincia()));
            tvMunicipio.setText(String.format(contexto.getString(R.string.tv_municipio), datoH.getMunicipio()));

            Map<String, String> estaciones = ed.mapearEstaciones(); //Cargamos mapa con la equivalencia de los codigos de las estaciones

            String codEstac = datoH.getEstacion(); //Comprobamos que tenemos equivalencia para ese código, y sino mostramos el código
            String estacion = (estaciones.containsKey(codEstac))? codEstac + " " + estaciones.get(codEstac): codEstac;

            tvEstacion.setText(String.format(contexto.getString(R.string.tv_estacion), estacion));
            tvFecha.setText(String.format(contexto.getString(R.string.tv_fecha),datoH.getDia(), datoH.getMes(), datoH.getAnio()));
            tvMuestreo.setText(String.format(contexto.getString(R.string.tv_muestreo), datoH.getPuntoMuestreo()));

            Map<Integer, String> magnitudes = ed.mapearMagnitudes();//Cargamos mapa con la equivalencia de los codigos de las magnitudes
            String codMagnit = datoH.getMagnitud();//Comprobamos que tenemos equivalencia para ese código, y sino mostramos el código
            int codMag = Integer.parseInt(codMagnit);
            String magnitud = (magnitudes.containsKey(codMag))? codMagnit + " " + magnitudes.get(codMag): codMagnit;
            tvMagnitud.setText(String.format(contexto.getString(R.string.tv_magnitud), magnitud));

            String medida = "μg/m3"; //Mostramos la medida del contaminante según el tipo
            if (codMag == 6 | (codMag >= 42 & codMag <= 44)) medida = "mg/m3";
            tvNivel8am.setText(String.format(contexto.getString(R.string.tv_nivel8am), datoH.getH08(), medida));
            tvNivel6pm.setText(String.format(contexto.getString(R.string.tv_nivel16pm), datoH.getH16(), medida));
            tvNive24pm.setText(String.format(contexto.getString(R.string.tv_nivel24pm), datoH.getH24(), medida));
        }
    }
}
