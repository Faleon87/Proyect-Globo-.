package com.example.loginandroid_29_09_2023.lst_products.view;

//import static com.example.loginandroid_29_09_2023.R.id.btnEnviar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.loginandroid_29_09_2023.R;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.presenter.LstProductsPresenter;

import java.util.ArrayList;

public class LstProductsActivity extends AppCompatActivity
        implements ContractListMovies.View {

    private LstProductsPresenter lstProductsPresenter;

    private ArrayList<ProductRestaurant> ProductoRestaurantes = new ArrayList<>();
    private ImageButton btnvuelta;

    private static LstProductsActivity lstProductsActivity = null;

    private LstProductsPresenter presenter =
            new LstProductsPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_lst_products);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lstProductsActivity = this;
        initComponents();
    }

    private void initComponents() {
//        btnvuelta = findViewById(R.id.imageButton2);
//        btnvuelta.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(LstProductsActivity.this, LoginUserM.class);
//                startActivity(intent);
//            }
//        });
        presenter.lstProductos("Ayuda");


    }

    @Override
    public void successMovies(ArrayList<ProductRestaurant> ProductoRestaurantes) {
        this.ProductoRestaurantes = ProductoRestaurantes;
        initListView();
    }

    private void initListView() {
        LinearLayoutCompat linearLayout = findViewById(R.id.constraintLayoutProduct);
        for (ProductRestaurant ProductoRestaurante : ProductoRestaurantes) {
//            View productView = getLayoutInflater().inflate(R.layout.activity_lst_products, null);

            // Configurar las vistas dentro del CardView
//            ImageView imageView = productView.findViewById(R.id.imageView4);
//            TextView productNameTextView = productView.findViewById(R.id.productNameTextView3);
//            TextView restaurantNameTextView = productView.findViewById(R.id.restaurantNameTextView3);
//            TextView priceTextView = productView.findViewById(R.id.priceTextView3);

//            RelativeLayout productView = new RelativeLayout(this);
//            productView.setMinimumHeight(100);
            TextView productNameTextView = new TextView(this);
            productNameTextView.setHeight(100);
            TextView restaurantNameTextView = new TextView(this);
            restaurantNameTextView.setHeight(100);
            TextView priceTextView = new TextView(this);
            priceTextView.setHeight(100);


            // Configurar los valores del producto en las vistas
            // (Asumiendo que Productos tiene métodos como getNombre(), getRestaurante(), getPrecio(), etc.)
            productNameTextView.setText(ProductoRestaurante.getProducto().getNombre());
            restaurantNameTextView.setText(ProductoRestaurante.getRestaurante().getNombre());
            priceTextView.setText("$" + ProductoRestaurante.getProducto().getPrecio());

            // Aquí podrías cargar la imagen desde la URL o recurso, por ejemplo:
//            Glide.with(this).load(ProductoRestaurante.getProducto().getImagen()).into(imageView);
            linearLayout.addView(productNameTextView);
            linearLayout.addView(restaurantNameTextView);
            linearLayout.addView(priceTextView);
            // Añadir la vista del producto al contenedor

//            linearLayout.addView(productView);
        }

    }

    @Override
    public void failureMovies(String err) {

    }
}

