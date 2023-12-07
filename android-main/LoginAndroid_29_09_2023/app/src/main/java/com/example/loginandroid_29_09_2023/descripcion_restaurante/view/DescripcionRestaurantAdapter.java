package com.example.loginandroid_29_09_2023.descripcion_restaurante.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Restaurante;

import java.util.ArrayList;

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
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNombreRest;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombreRest = itemView.findViewById(R.id.nombreRest);
        }
    }
}
