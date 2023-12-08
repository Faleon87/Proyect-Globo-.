package com.example.loginandroid_29_09_2023.ComentUser.view;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.loginandroid_29_09_2023.ComentUser.ContractUserComent;
import com.example.loginandroid_29_09_2023.ComentUser.presenter.ComentPresenter;
import com.example.loginandroid_29_09_2023.Parte_admin.view.LoginAdminM;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Puntuacion;
import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.restaurant_ventas.view.LstProductsViewUser;

public class ComentView extends AppCompatActivity implements ContractUserComent.View {

    public static final String CHANNEL_ID = "your_channel_id";

    private static ComentView mainActivity = null;

    private TextView comentario;

    private RatingBar ratingBar;

    private Button btnEnviarComent;

    private ComentPresenter presenter =
            new ComentPresenter(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coment_user);
        mainActivity = this;
        initComponents();

        createNotificationChannel();
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


    private void initComponents() {
        ImageButton imagebutton = findViewById(R.id.imageButton);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComentView.this, LstProductsViewUser.class);
                startActivity(intent);
            }
        });


        ratingBar = findViewById(R.id.ratingBar);
        comentario = findViewById(R.id.comentario);
        btnEnviarComent = findViewById(R.id.btnEnviarComent);
        btnEnviarComent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorcomentario = comentario.getText().toString();
                int valorestrellas = (int) ratingBar.getRating();
                // Obtener el Intent que inició esta actividad
                Intent intent = getIntent();

                // Verificar si el Intent contiene la clave "restauranteId"
                // Obtener el valor asociado con la clave "restauranteId"
                int restauranteId = intent.getIntExtra("restauranteId", -1); // -1 es un valor predeterminado si no se encuentra el extra
                int clienteId = intent.getIntExtra("clienteId", -1); // -1 es un valor predeterminado si no se encuentra el extra
                Puntuacion puntuacion = new Puntuacion();
                puntuacion.setId_restaurante(restauranteId);
                puntuacion.setId_cliente(clienteId);
                puntuacion.setComentario(valorcomentario);
                puntuacion.setPuntuacion(valorestrellas);
                presenter.addComent(puntuacion);

            }
        });
    }

    @Override
    public void success() {
//        Toast.makeText(mainActivity, "Enviados correctamente", Toast.LENGTH_SHORT).show();
//        mainActivity.finish();


        Intent intent = new Intent(this, ComentView.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.baseline_fastfood_24)
                .setContentTitle("Comentario enviado")
                .setContentText("Gracias por su comentario")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true); // Dismisses the notification when clicked

        // Show the notification
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }

    @Override
    public void failure(String err) {
        Toast.makeText(mainActivity, "Error al enviar", Toast.LENGTH_SHORT).show();
    }
}
