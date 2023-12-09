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
import com.example.loginandroid_29_09_2023.beans.ProductoGroup;

import java.util.ArrayList;

public class insertarDatosCarritoAdapter extends RecyclerView.Adapter<insertarDatosCarritoAdapter.ViewHolder> {

    private Context context;

    private ArrayList<Producto> lstProductos = new ArrayList<>();

    private ArrayList<ProductoGroup> lstProductosCarrito = new ArrayList<>();

    public insertarDatosCarritoAdapter(ArrayList<Producto> lstProductos , Context context) {
        this.context = context;
        this.lstProductos = lstProductos;
        this.lstProductosCarrito = groupProductosByName(lstProductos);

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
        ProductoGroup productoGroup = lstProductosCarrito.get(position);
        Producto producto = productoGroup.getProducto();

        holder.textViewNombre.setText(producto.getNombre());

        // Verificar si hay más de un producto con el mismo nombre en el grupo
        if (productoGroup.getCount() >= 1) {
            holder.textViewContador.setVisibility(View.VISIBLE);
            holder.textViewContador.setText( "Total:" + String.valueOf(productoGroup.getCount()));
        } else {
            holder.textViewContador.setVisibility(View.GONE);
        }

        holder.textViewPrecio.setText("Precio: " + producto.getPrecio() + "€");
        String urlImagen = producto.getImagen();
        Glide.with(context)
                .load(urlImagen)
                .transform(new com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lstProductosCarrito.size();
    }
    private ArrayList<ProductoGroup> groupProductosByName(ArrayList<Producto> productos) {
        ArrayList<ProductoGroup> productoGroups = new ArrayList<>();

        for (Producto producto : productos) {
            boolean addedToGroup = false;

            // Buscar si ya existe un grupo con el mismo nombre
            for (ProductoGroup productoGroup : productoGroups) {
                if (productoGroup.getNombre().equals(producto.getNombre())) {
                    productoGroup.incrementCount();
                    addedToGroup = true;
                    break;
                }
            }

            // Si no se agregó a un grupo existente, crear un nuevo grupo
            if (!addedToGroup) {
                productoGroups.add(new ProductoGroup(producto));
            }
        }

        return productoGroups;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNombre;
        TextView textViewPrecio;

        TextView textViewContador;

        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.nombreProductoCarrito);
            textViewPrecio = itemView.findViewById(R.id.precioProductoCarrito);
            textViewContador = itemView.findViewById(R.id.contadorproductos);
            imageView = itemView.findViewById(R.id.imageProductCarrito);
        }
    }


}
