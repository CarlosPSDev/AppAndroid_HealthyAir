package com.riluca.healthyair.ui.datosReales;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.riluca.healthyair.R;
import com.riluca.healthyair.javabean.DatoHorario;
import java.util.ArrayList;

public class RealDatosAdapter extends RecyclerView.Adapter<RealDatosAdapter.DatoVH> {
    private ArrayList<DatoHorario>listaDatos;

    public RealDatosAdapter(ArrayList<DatoHorario> listaDatos) {
        this.listaDatos = listaDatos;
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

        public void bindDato(DatoHorario datoH){//Vuelca la informacion de tipo planta con un layout (item_planta)
            //tvProvincia.setText(String.format(getString(R.string.tv_provincia), datoH.getProvincia()));
            /*tvMunicipio;
            tvEstacion;
            tvFecha;
            tvMuestreo;
            tvMagnitud;
            tvNivel8am;
            tvNivel6pm;
            tvNive24pm;*/

            /*tvNombreComun.setText(planta.getNombreComun());
            tvNombreBotanico.setText(planta.getNomBotanico());
            tvZona.setText(planta.getZona());
            tvLuz.setText(planta.getLuz());
            tvPrecio.setText(planta.getPrecio());
            tvDisponibilidad.setText(planta.getDisponibilidad());*/
        }
    }
}
