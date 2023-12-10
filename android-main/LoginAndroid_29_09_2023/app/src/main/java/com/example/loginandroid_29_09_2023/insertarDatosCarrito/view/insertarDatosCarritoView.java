package com.example.loginandroid_29_09_2023.insertarDatosCarrito.view;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.ComentUser.view.ComentView;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Carrito;
import com.example.loginandroid_29_09_2023.beans.Correo;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.insertarDatosCarrito;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.presenter.inserDatosPresenter;
import com.example.loginandroid_29_09_2023.mostrarProductos.view.MostrarProductosView;

import java.util.ArrayList;

public class insertarDatosCarritoView extends AppCompatActivity implements insertarDatosCarrito.View {

    public static final String CHANNEL_ID = "your_channel_id";
    private int idCliente;
    private inserDatosPresenter presenter = new inserDatosPresenter(this);

    private static insertarDatosCarritoView mainActivity = null;

    private RecyclerView recyclerViewProductos;

    private insertarDatosCarritoAdapter adapter;

    public static insertarDatosCarritoView getInstance(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial_productos_carritos);
        mainActivity = this;
        initComponents();
        createNotificationChannel();
    }

    private void initComponents(){
        Intent intent = getIntent();
        int idProducto = intent.getIntExtra("idProducto", 0);
        int idCliente = intent.getIntExtra("idCliente", 0);
        System.out.println("idProducto: " + idProducto);
        System.out.println("idCliente: " + idCliente);
        Carrito carrito = new Carrito();
        carrito.setId_producto(idProducto);
        carrito.setId_cliente(idCliente);
        presenter.login(carrito);



    }
    @Override
    public void successLogin(Carrito carrito) {
         idCliente =carrito.getId_cliente();
        System.out.println("idCliente: " + idCliente);
        recyclerViewProductos = findViewById(R.id.listaProductosCarritosxd);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL, false));
        presenter.producto(carrito);

    }

    @Override
    public void successLogin2(ArrayList<Producto> producto) {
        adapter = new insertarDatosCarritoAdapter(producto ,this);
        recyclerViewProductos.setAdapter(adapter);
        ImageButton volver = findViewById(R.id.imageButton);
        volver.setOnClickListener(v -> {
            finish();
        });
        Button finalizarCompra = findViewById(R.id.finalizarCompra);
        finalizarCompra.setOnClickListener(v -> {
            TextView correo = findViewById(R.id.correoConfirmacion);
            String correoConfirmacion = correo.getText().toString();
            if (correoConfirmacion.isEmpty()){
                correo.setError("Introduce un correo ");
            }else if (!correoConfirmacion.contains("@")){
                correo.setError("Introduce un correo valido tiene que contener @");
            }else if (!correoConfirmacion.contains(".")){
                correo.setError("Introduce un correo valido tiene que contener .");
            }else if (correoConfirmacion.contains("ñ")){
                correo.setError("Introduce un correo valido no puede contener ñ");
            }else {
                Correo correo1 = new Correo();
                correo1.setId_cliente(idCliente);
                correo1.setCorreo(correoConfirmacion);
                presenter.insertarCorreo(correo1);
            }

        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Request notification permissions here
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            }

            CharSequence name = "Your Channel Name";
            String description = "Your Channel Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    @Override
    public void successLogin3(Correo correo) {

        Intent intent = new Intent(this, ComentView.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.baseline_fastfood_24)
                .setContentTitle("Gracias por su compra")
                .setContentText("Gracias por su compra, en breve recibira un correo con la lista de productos que ha comprado")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true); // Dismisses the notification when clicked

        // Show the notification
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }


    @Override
    public void failureLogin(String err) {

    }
}
