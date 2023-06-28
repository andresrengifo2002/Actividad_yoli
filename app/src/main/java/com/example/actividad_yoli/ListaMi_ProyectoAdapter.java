package com.example.actividad_yoli;

import static com.example.actividad_yoli.R.drawable.imagenactivity_background;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListaMi_ProyectoAdapter extends RecyclerView.Adapter<ListaMi_ProyectoAdapter.ViewHolder > {

    private RecyclerView recyclerView;

    private ArrayList<Mi_Proyecto> dataset;

    private ListaMi_ProyectoAdapter listaMi_proyectoAdapterAdapter;

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView nombreTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.textView2);
            imagen = itemView.findViewById(R.id.imageView);
        }
    }
    public ListaMi_ProyectoAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_proyecto, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public int getItemCount(){
        return dataset.size();
    }

    @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Mi_Proyecto m = dataset.get(position);
            holder.nombreTextView.setText(m.getNombre()); //envio del nombre al texto

            Glide.with(context)
                    .load("https://assets.chucknorris.host/img/avatar/chuck-norris.png")
                    .into(holder.imagen);
        }


        public void add(ArrayList<Mi_Proyecto> listaMi_proyectos){
            dataset.addAll(listaMi_proyectos);
            notifyDataSetChanged();
        }
    }

