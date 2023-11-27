package com.example.loginandroid_29_09_2023.restaurant_ventas.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;

import java.util.List;

public class ProductoVentasAdapter extends RecyclerView.Adapter<ProductoVentasAdapter.ViewHolder>{

    private List<ProductRestaurant> productoVentasList;
    private Context context;

    public ImageButton imageButtonImagen;
    public TextView textViewNombre;
    public TextView textViewVentas;

    public ProductoVentasAdapter(List<ProductRestaurant> productos, Context context) {
            this.productoVentasList = productos;
            this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lst_restaurante_ventas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductRestaurant ProductRestaurant = productoVentasList.get(position);

        // Establecer valores para cada producto
        try {
            holder.textViewNombre.setText(ProductRestaurant.getRestaurante().getNombre());
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        holder.textViewVentas.setText("Ventas: " + ProductRestaurant.getRestaurante().getVentas());

        // Cargar la imagen desde la URL usando Glide (o Picasso)
        String urlImagen = ProductRestaurant.getRestaurante().getImagen();
        Glide.with(context).load(urlImagen).centerCrop().into(holder.imageButtonImagen);
    }

    @Override
    public int getItemCount() {
        return productoVentasList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        ImageButton imageButtonImagen;
        TextView textViewVentas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            imageButtonImagen = itemView.findViewById(R.id.imageButtonImagen);
            textViewVentas = itemView.findViewById(R.id.textViewVentas);
        }
    }
}
