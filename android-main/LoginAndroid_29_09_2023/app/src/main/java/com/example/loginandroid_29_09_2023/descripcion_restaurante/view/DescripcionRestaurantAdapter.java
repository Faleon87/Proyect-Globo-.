package com.example.loginandroid_29_09_2023.descripcion_restaurante.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Restaurante;



public class DescripcionRestaurantAdapter extends RecyclerView.Adapter<DescripcionRestaurantAdapter.ViewHolder> {

    private Restaurante restaurante;

    private Context context;
    public DescripcionRestaurantAdapter(Restaurante restaurante, Context context) {
     this.restaurante = restaurante;
     this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_descripcion_rest, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Restaurante restaurante = this.restaurante;
            holder.textViewNombreRest.setText(restaurante.getNombre());
            holder.textViewDescripcion.setText(restaurante.getDescripcion());
            holder.textViewTematica.setText(restaurante.getTematica());
            String urlImagen = restaurante.getImagen();
            Glide.with(context)
                .load(urlImagen)
                .into(holder.imageRestaurante);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNombreRest;
        TextView textViewDescripcion;

        TextView textViewTematica;

        ImageView imageRestaurante;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombreRest = itemView.findViewById(R.id.nombreRest);
            textViewDescripcion = itemView.findViewById(R.id.descripcionRestaurante);
            textViewTematica = itemView.findViewById(R.id.tematicaRestauranteperso);
            imageRestaurante = itemView.findViewById(R.id.imagenRestaurantePerso);
        }
    }
}
