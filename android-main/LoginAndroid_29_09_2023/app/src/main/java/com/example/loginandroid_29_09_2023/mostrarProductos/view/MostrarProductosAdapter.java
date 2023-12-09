package com.example.loginandroid_29_09_2023.mostrarProductos.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.view.insertarDatosCarritoView;

import java.util.List;

public class MostrarProductosAdapter extends RecyclerView.Adapter<MostrarProductosAdapter.ViewHolder> {

    private List<Producto> lstFilterRestaurantAdapter;

    private Context context;

    private int idCliente;

    public MostrarProductosAdapter(List<Producto> lstProductos, Context context , int id_cliente) {
        this.lstFilterRestaurantAdapter= lstProductos;
        this.context = context;
        this.idCliente = id_cliente;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_productos, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostrarProductosAdapter.ViewHolder holder, int position) {
       Producto producto = lstFilterRestaurantAdapter.get(position);
       int idProducto = producto.getId_producto();
        System.out.println("idProducto: " + idProducto);


       holder.textViewNombre.setText(producto.getNombre());
       holder.textViewPrecio.setText("Precio: " + producto.getPrecio() + "€");
       String urlImagen = producto.getImagen();
        Glide.with(context)
                .load(urlImagen)
                .transform(new com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.imageView);
        holder.btnAddCarrito.setTag(idProducto);

        holder.btnAddCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el idProducto de la etiqueta del botón
                int idProducto = (int) v.getTag();

                Intent intent = new Intent(context, insertarDatosCarritoView.class);
                intent.putExtra("idProducto", idProducto);
                intent.putExtra("idCliente", idCliente);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lstFilterRestaurantAdapter.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        ImageView imageView;

        TextView textViewPrecio;

        Button btnAddCarrito;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.nombreProductoCarrito);
            imageView = itemView.findViewById(R.id.ImgProductos);
            textViewPrecio = itemView.findViewById(R.id.precioProductoCarrito);
            btnAddCarrito = itemView.findViewById(R.id.añadirCarrito);

        }
    }
}
