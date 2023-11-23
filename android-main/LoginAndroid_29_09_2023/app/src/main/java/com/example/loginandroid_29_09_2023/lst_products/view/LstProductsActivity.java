package com.example.loginandroid_29_09_2023.lst_products.view;

//import static com.example.loginandroid_29_09_2023.R.id.btnEnviar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.R;

import com.example.loginandroid_29_09_2023.beans.Productos;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.presenter.LstProductsPresenter;

import java.util.ArrayList;

public class LstProductsActivity extends AppCompatActivity
                                    implements ContractListMovies.View
{

    private LstProductsPresenter lstMoviesPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_movies);

        LstProductsPresenter lstMoviesPresenter = new LstProductsPresenter(this);
        lstMoviesPresenter.lstMovies("");

////        Button btnEnviar = findViewById(R.id.);
//        btnEnviar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lstMoviesPresenter.lstMovies("");
//            }
//        });
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