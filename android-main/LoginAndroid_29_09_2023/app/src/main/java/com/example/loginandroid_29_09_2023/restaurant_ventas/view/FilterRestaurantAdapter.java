package com.example.loginandroid_29_09_2023.restaurant_ventas.view;

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
import com.example.loginandroid_29_09_2023.beans.RestaurantFilter;

import java.util.List;

public class FilterRestaurantAdapter extends RecyclerView.Adapter<FilterRestaurantAdapter.ViewHolder> {

    private List<RestaurantFilter> restaurantFilterList;

    private Context context;


    public FilterRestaurantAdapter(List<RestaurantFilter> restaurantFilterList , Context context) {
        this.restaurantFilterList = restaurantFilterList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterRestaurantAdapter.ViewHolder holder, int position) {
        RestaurantFilter productRestaurant = restaurantFilterList.get(position);
        // Establecer valores para cada producto
        holder.textViewNombre.setText(productRestaurant.getRestaurante().getNombre());
        holder.textViewTematica.setText("Tematica: " + productRestaurant.getRestaurante().getTematica());
        String urlImagen = productRestaurant.getRestaurante().getImagen();
        Glide.with(context)
                .load(urlImagen)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.imageButtonImagen);
    }

    @Override
    public int getItemCount() {
        return restaurantFilterList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        ImageButton imageButtonImagen;
        TextView textViewTematica;

        public ViewHolder(@android.support.annotation.NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.nombreProducto);
            imageButtonImagen = itemView.findViewById(R.id.ImgTematica);
            textViewTematica = itemView.findViewById(R.id.PrecioProductos);
        }

    }
}
