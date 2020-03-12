package com.riluca.healthyair.ui.normative;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riluca.healthyair.R;

import java.util.ArrayList;

public class EscenarioAdapter extends RecyclerView.Adapter<EscenarioAdapter.EscenarioViewHolder> {

    private ArrayList<Escenario> datos;

    public EscenarioAdapter(ArrayList<Escenario> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public EscenarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_normativa, null, false);
        return new EscenarioViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull EscenarioViewHolder holder, int position) {
        holder.bindItemLista(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class EscenarioViewHolder extends RecyclerView.ViewHolder{

        private TextView tvSuperior;
        private TextView tvInferior;


        public EscenarioViewHolder(View itemView) {
            super(itemView);
            tvSuperior = itemView.findViewById(R.id.tvTextoSuperior);
            tvInferior = itemView.findViewById(R.id.tvTextoInferior);
        }

        public void bindItemLista(Escenario e){
            tvSuperior.setText(e.getTextoSuperior());
            tvInferior.setText(e.getTextoInferior());
        }
    }
}
