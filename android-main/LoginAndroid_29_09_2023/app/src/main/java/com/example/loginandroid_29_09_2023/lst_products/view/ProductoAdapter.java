package com.example.loginandroid_29_09_2023.lst_products.view;

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

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private List<ProductRestaurant> productos;
    private Context context;

    public ProductoAdapter(List<ProductRestaurant> productos, Context context) {
        this.productos = productos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductRestaurant productoRestaurante = productos.get(position);


        // Establecer valores para cada producto
        holder.textViewNombreProducto.setText(productoRestaurante.getProducto().getNombre());
        holder.textViewNombreRestaurante.setText(productoRestaurante.getRestaurante().getNombre());
        holder.textViewPrecio.setText("$" + productoRestaurante.getProducto().getPrecio());

        // Cargar la imagen desde la URL usando Glide (o Picasso)
        String urlImagen = productoRestaurante.getProducto().getImagen();
        Glide.with(context).load(urlImagen).into(holder.imageButtonProducto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombreProducto;
        ImageButton imageButtonProducto;
        TextView textViewNombreRestaurante;
        TextView textViewPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombreProducto = itemView.findViewById(R.id.textViewNombreProducto);
            imageButtonProducto = itemView.findViewById(R.id.imageButtonProducto);
            textViewNombreRestaurante = itemView.findViewById(R.id.textViewNombreRestaurante);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecio);
        }
    }
}
