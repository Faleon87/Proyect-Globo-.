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
    public ProductoVentasAdapter(List<ProductRestaurant> productos, Context context) {
            this.productoVentasList = productoVentasList;
            this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lst_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductRestaurant ProductRestaurant = productoVentasList.get(position);

        // Establecer valores para cada producto
        holder.textViewNombre.setText(ProductRestaurant.getProducto().getNombre());
        holder.textViewVentas.setText("Ventas: " + ProductRestaurant.getRestaurante().getVentas());

        // Cargar la imagen desde la URL usando Glide (o Picasso)
        String urlImagen = ProductRestaurant.getProducto().getImagen();
        Glide.with(context).load(urlImagen).into(holder.imageButtonImagen);
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
