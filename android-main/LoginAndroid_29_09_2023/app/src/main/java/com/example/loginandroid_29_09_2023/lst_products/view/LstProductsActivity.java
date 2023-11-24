package com.example.loginandroid_29_09_2023.lst_products.view;

//import static com.example.loginandroid_29_09_2023.R.id.btnEnviar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.Parte_admin.view.LoginAdminM;
import com.example.loginandroid_29_09_2023.R;

import com.example.loginandroid_29_09_2023.beans.Productos;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.presenter.LstProductsPresenter;

import java.util.ArrayList;

public class LstProductsActivity extends AppCompatActivity
                                    implements ContractListMovies.View
{

    private LstProductsPresenter lstProductsPresenter;
    private ImageButton btnvuelta;

    private  static LstProductsActivity lstProductsActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_movies);
        lstProductsActivity = this;
        initComponents();

////        Button btnEnviar = findViewById(R.id.);
//        btnEnviar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lstMoviesPresenter.lstMovies("");
//            }
//        });
    }
    private void initComponents(){
        btnvuelta = findViewById(R.id.imageButton2);
        btnvuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LstProductsActivity.this, LoginUserM.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void successMovies(ArrayList<Productos> lstProductos) {
//        Toast.makeText(this, lstProductos.get(0).getTitulo(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, lstProductos.get(0).getDescripcion(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureMovies(String err) {

    }
}