package com.example.loginandroid_29_09_2023.ComentUser.view;

import android.content.Intent;
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

import com.example.loginandroid_29_09_2023.ComentUser.ContractUserComent;
import com.example.loginandroid_29_09_2023.ComentUser.presenter.ComentPresenter;
import com.example.loginandroid_29_09_2023.Parte_admin.view.LoginAdminM;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Puntuacion;
import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.restaurant_ventas.view.LstProductsViewUser;

public class ComentView extends AppCompatActivity implements ContractUserComent.View {


    private static ComentView mainActivity = null;

    private  TextView comentario;

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
    }
    private  void initComponents(){
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
                 String valorcomentario= comentario.getText().toString();
                 int valorestrellas = (int) ratingBar.getRating();
                 // Obtener el Intent que inició esta actividad
                 Intent intent = getIntent();

                 // Verificar si el Intent contiene la clave "restauranteId"
                 if (intent.hasExtra("restauranteId")) {
                     // Obtener el valor asociado con la clave "restauranteId"
                     int restauranteId = intent.getIntExtra("restauranteId", -1); // -1 es un valor predeterminado si no se encuentra el extra
                     Puntuacion puntuacion = new Puntuacion();
                     puntuacion.setId_restaurante(restauranteId);
                     puntuacion.setComentario(valorcomentario);
                     puntuacion.setPuntuacion(valorestrellas);
                     presenter.addComent(puntuacion);
                 }
             }
         });
    }

    @Override
    public void success() {
        Toast.makeText(mainActivity, "Enviados correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String err) {
        Toast.makeText(mainActivity, "Error al enviar", Toast.LENGTH_SHORT).show();
    }
}
