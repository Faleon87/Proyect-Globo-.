package com.example.loginandroid_29_09_2023.restaurant_ventas.view;

import static androidx.core.content.ContextCompat.startActivity;

import static com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.view.ActionBarPolicy;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.loginandroid_29_09_2023.ComentUser.view.ComentView;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Cliente;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.User;

import java.util.HashMap;
import java.util.List;

public class ProductoVentasAdapter extends RecyclerView.Adapter<ProductoVentasAdapter.ViewHolder>{

    private List<ProductRestaurant> productoVentasList;
    private Context context;

    public ImageButton imageButtonImagen;
    public TextView textViewNombre;
    public TextView textViewVentas;

    private ActionBarPolicy items;

    public ProductoVentasAdapter(List<ProductRestaurant> productos, Context context) {
            this.productoVentasList = productos;
            this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lst_restaurante_ventas, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductRestaurant productRestaurant = productoVentasList.get(position);
         int idRestaurante = productRestaurant.getRestaurante().getId_restaurante();

        // Establecer valores para cada producto
        


        holder.textViewNombre.setText(productRestaurant.getRestaurante().getNombre());
        holder.textViewVentas.setText("Ventas: " + productRestaurant.getRestaurante().getVentas());

        // Cargar la imagen desde la URL usando Glide (o Picasso)
        String urlImagen = productRestaurant.getRestaurante().getImagen();
        Glide.with(context)
                .load(urlImagen)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.imageButtonImagen);


        // Guardar el id_restaurante como una etiqueta en el ImageButton
        HashMap<String , Integer> map = new HashMap<>();
        map.put("idRestaurante", idRestaurante);
        Intent intent = ((Activity) context).getIntent();
        map.put("idCliente", intent.getIntExtra("clienteId", 0 ));
        holder.imageButtonImagen.setTag(map);

        holder.imageButtonImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recuperar el id_restaurante cuando se hace clic en el ImageButton

              // Suponiendo que el método para obtener el ID del cliente sea getIdCliente()
                HashMap<String , Integer> map = (HashMap<String, Integer>) view.getTag();


                if (map.containsKey("idRestaurante") && map.containsKey("idCliente")) {
                    int restauranteId =Integer.parseInt(map.get("idRestaurante").toString());
                    int clienteId = map.get("idCliente"); // Obtener el ID del cliente
                    Intent intent = new Intent(context, ComentView.class);
                    intent.putExtra("restauranteId", restauranteId);
                    intent.putExtra("clienteId", clienteId); // Agregar el ID del cliente
                    context.startActivity(intent);
                }
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
