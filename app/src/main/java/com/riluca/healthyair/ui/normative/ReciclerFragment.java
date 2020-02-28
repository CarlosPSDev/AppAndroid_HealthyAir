package com.riluca.healthyair.ui.normative;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riluca.healthyair.R;

import java.util.ArrayList;
import java.util.List;

public class ReciclerFragment extends Fragment {

    public static Fragment newInstance() {
        return new ReciclerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recicler_view_fragment, container, false);
        //TODO: Aqui cargaremos los datos
        List<String> list = new ArrayList<>();
        list.add("UNO");
        list.add("DOS");
        list.add("TRES");
        RecyclerView reciclerView = v.findViewById(R.id.recicler_view);
        reciclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        reciclerView.setAdapter(new RecyclerViewAdapter(list));
        return v;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView myCard;
        private TextView myTextView;
        public RecyclerViewHolder(View itemView){
            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.card_view, container, false));

            myCard = itemView.findViewById(R.id.card_container);
            myTextView = itemView.findViewById(R.id.text_holder);

        }

    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        private List<String> mList;

        public RecyclerViewAdapter(List<String> list) {
            this.mList = list;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            holder.myTextView.setText(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }


}
