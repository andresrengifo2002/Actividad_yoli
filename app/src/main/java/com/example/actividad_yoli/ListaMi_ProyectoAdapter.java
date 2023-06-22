package com.example.actividad_yoli;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaMi_ProyectoAdapter extends RecyclerView.Adapter<ListaMi_ProyectoAdapter.ViewHolder > {

    private RecyclerView recyclerView;

    private ArrayList<Mi_Proyecto> dataset;

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView nombreTextView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.Text1);
        }

    }

    @NonNull
    @Override
    public ListaMi_ProyectoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaMi_ProyectoAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



}
