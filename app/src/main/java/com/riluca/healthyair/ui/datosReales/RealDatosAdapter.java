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

        private TextView tvNombreComun;
        private TextView tvNombreBotanico;
        private TextView tvZona;
        private TextView tvLuz;
        private TextView tvPrecio;
        private TextView tvDisponibilidad;

        public DatoVH(@NonNull View v){
            super(v);
           /* tvNombreComun = v.findViewById(R.id.tvNombreComun);
            tvNombreBotanico = v.findViewById(R.id.tvNombreBotanico);
            tvZona = v.findViewById(R.id.tvZona);
            tvLuz = v.findViewById(R.id.tvLuz);
            tvPrecio = v.findViewById(R.id.tvPrecio);
            tvDisponibilidad = v.findViewById(R.id.tvDisponibilidad);*/
        }

        public void bindDato(DatoHorario datoH){//Vuelca la informacion de tipo planta con un layout (item_planta)
            /*tvNombreComun.setText(planta.getNombreComun());
            tvNombreBotanico.setText(planta.getNomBotanico());
            tvZona.setText(planta.getZona());
            tvLuz.setText(planta.getLuz());
            tvPrecio.setText(planta.getPrecio());
            tvDisponibilidad.setText(planta.getDisponibilidad());*/
        }
    }
}
