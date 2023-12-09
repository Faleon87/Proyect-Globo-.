package com.example.loginandroid_29_09_2023.insertarDatosCarrito.view;

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
import com.example.loginandroid_29_09_2023.beans.Producto;

import java.util.ArrayList;

public class insertarDatosCarritoAdapter extends RecyclerView.Adapter<insertarDatosCarritoAdapter.ViewHolder> {

    private Context context;

    private ArrayList<Producto> lstProductos = new ArrayList<>();

    public insertarDatosCarritoAdapter(ArrayList<Producto> lstProductos , Context context) {
        this.context = context;
        this.lstProductos = lstProductos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_productos, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull insertarDatosCarritoAdapter.ViewHolder holder, int position) {
        Producto producto = lstProductos.get(position);
        holder.textViewNombre.setText(producto.getNombre());
        holder.textViewPrecio.setText("Precio: " + producto.getPrecio() + "€");
        String urlImagen = producto.getImagen();
        Glide.with(context)
                .load(urlImagen)
                .transform(new com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lstProductos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNombre;
        TextView textViewPrecio;

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.nombreProductoCarrito);
            textViewPrecio = itemView.findViewById(R.id.precioProductoCarrito);
            imageView = itemView.findViewById(R.id.imageProductCarrito);
        }
    }
}
