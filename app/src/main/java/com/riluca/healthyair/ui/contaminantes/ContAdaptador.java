package com.riluca.healthyair.ui.contaminantes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riluca.healthyair.R;

import java.util.ArrayList;

public class ContAdaptador extends RecyclerView.Adapter<ContAdaptador.ContViewHolder> implements View.OnClickListener{

    private View.OnClickListener contaminantesAdapListener;
    private ArrayList<ItemLista> datos;

    public ContAdaptador(ArrayList<ItemLista> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ContViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_contaminantes, null, false);
        return new ContViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ContViewHolder holder, int position) {
        holder.bindItemLista(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public void onClick(View v) {

        if(contaminantesAdapListener != null){
            contaminantesAdapListener.onClick(v);
        }

    }

    public static class ContViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tvSuperior;
        private TextView tvInferior;


        public ContViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.ivPhoto);
            tvSuperior = itemView.findViewById(R.id.tvTextoSuperior);
            tvInferior = itemView.findViewById(R.id.tvTextoInferior);
        }

        public void bindItemLista(ItemLista iL){
            iv.setImageResource(iL.getIdPhoto());
            tvSuperior.setText(iL.getTextoSuperior());
            tvInferior.setText(iL.getTextoInferior());
        }
    }

}
