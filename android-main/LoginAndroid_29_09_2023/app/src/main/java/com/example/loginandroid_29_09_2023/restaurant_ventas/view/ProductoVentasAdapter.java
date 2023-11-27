package com.example.loginandroid_29_09_2023.restaurant_ventas.view;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginandroid_29_09_2023.ComentUser.view.ComentView;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.User;

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

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductRestaurant productRestaurant = productoVentasList.get(position);
         int idRestaurante = productRestaurant.getRestaurante().getId_restaurante();

        // Establecer valores para cada producto
        try {
            holder.textViewNombre.setText(productRestaurant.getRestaurante().getNombre());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        holder.textViewVentas.setText("Ventas: " + productRestaurant.getRestaurante().getVentas());

        // Cargar la imagen desde la URL usando Glide (o Picasso)
        String urlImagen = productRestaurant.getRestaurante().getImagen();
        Glide.with(context).load(urlImagen).centerCrop().into(holder.imageButtonImagen);

        // Guardar el id_restaurante como una etiqueta en el ImageButton
        holder.imageButtonImagen.setTag(idRestaurante);

        holder.imageButtonImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recuperar el id_restaurante cuando se hace clic en el ImageButton
                int  restauranteId = (int) view.getTag();
                // Acción a realizar cuando se hace clic en el ImageButton
                // Por ejemplo, iniciar una nueva actividad pasando el id_restaurante
                Intent intent = new Intent(context, ComentView.class);
                intent.putExtra("restauranteId", restauranteId);
                context.startActivity(intent);
            }
        });
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
