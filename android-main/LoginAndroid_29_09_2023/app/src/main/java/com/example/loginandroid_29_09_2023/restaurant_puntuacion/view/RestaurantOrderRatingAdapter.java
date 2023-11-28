package com.example.loginandroid_29_09_2023.restaurant_puntuacion.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.RestaurantePuntuacion;

import java.util.ArrayList;

public class RestaurantOrderRatingAdapter  extends RecyclerView.Adapter<RestaurantOrderRatingAdapter.ViewHolder>{

    private ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion = new ArrayList<>();

    private Context context;
    public RestaurantOrderRatingAdapter(ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion, Context  context) {
        this.lstRestaurantsPuntuacion = lstRestaurantsPuntuacion;
        this.context = context;
    }

    @NonNull
    @Override
    public RestaurantOrderRatingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lst_restaurante_ventas, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantOrderRatingAdapter.ViewHolder holder, int position) {
        RestaurantePuntuacion restaurantOrderRatingView = lstRestaurantsPuntuacion.get(position);
        holder.textViewNombre.setText(restaurantOrderRatingView.getRestaurante().getNombre());
        holder.textViewVentas.setText("Puntuacion: " + restaurantOrderRatingView.getPuntuacion().getPuntuacion());
        String urlImagen = restaurantOrderRatingView.getRestaurante().getImagen();
        Glide.with(context)
                .load(urlImagen)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.imageButtonImagen);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        ImageButton imageButtonImagen;
        TextView textViewVentas;

        public ViewHolder(@android.support.annotation.NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            imageButtonImagen = itemView.findViewById(R.id.imageButtonImagen);
            textViewVentas = itemView.findViewById(R.id.textViewVentas);
        }
    }
}
