package com.example.loginandroid_29_09_2023.Parte_admin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.Parte_admin.ContractAdmin;
import com.example.loginandroid_29_09_2023.Parte_admin.presenter.LstPAdminPresenter;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;
import com.example.loginandroid_29_09_2023.lst_products.view.LstProductsActivity;

public class LoginAdminM extends AppCompatActivity implements ContractAdmin.View{
    private ImageButton btnvuelta;
    private Button btnverproductos;
    private String message;
    private Button btnEnviar;
    private TextView NombreRestaurante;
    private TextView NombreProducto;
    private  TextView DescripcionProducto;
    private TextView PrecioProducto;
    private  TextView ImagenUrl;
    private  TextView Restauranteid;
    private LstPAdminPresenter presenter =
            new LstPAdminPresenter(this);

    /* PATRÓN SINGLETON*/
    private static LoginAdminM mainActivity = null;
    public static LoginAdminM getInstance(){
        return mainActivity; //0x457845AF
    }
    /* FIN PATRÓN SINGLETON*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        mainActivity = this;
        initComponents();
    }
    private void initComponents(){
            btnEnviar =  findViewById(R.id.btnEnviarComent);
            btnEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NombreRestaurante = findViewById(R.id.NombreRestaurante);
                    NombreProducto = findViewById(R.id.NombreProducto);
                    DescripcionProducto = findViewById(R.id.Descripcion);
                    ImagenUrl = findViewById(R.id.ImagenUrl);
                    PrecioProducto = findViewById(R.id.PrecioProducto);
                    Restauranteid = findViewById(R.id.comentario);
                    String valorNombreRestaurante = NombreRestaurante.getText().toString();
                    String valorNombreProducto = NombreProducto.getText().toString();
                    String valorDescripcionProducto = DescripcionProducto.getText().toString();
                    String valorImagenUrl = ImagenUrl.getText().toString();
                    int valorPrecioProducto = 0;
                    valorPrecioProducto = Integer.parseInt(PrecioProducto.getText().toString());
                    int valorRestauranteid = Integer.parseInt(Restauranteid.getText().toString());
                    Restaurante restauranted = new Restaurante();
                    Producto producto = new Producto();
                    producto.setNombre(valorNombreProducto);
                    producto.setDescripcion(valorDescripcionProducto);
                    producto.setImagen(valorImagenUrl);
                    producto.setPrecio(valorPrecioProducto);
                    restauranted.setId_restaurante(valorRestauranteid);
                    restauranted.setNombre(valorNombreRestaurante);
                    ProductRestaurant productRestaurant = new ProductRestaurant();
                    productRestaurant.setProducto(producto);
                    productRestaurant.setRestaurante(restauranted);
                    presenter.login(productRestaurant);
                }
            });


            btnverproductos = findViewById(R.id.btnLogin2);
            btnverproductos.setOnClickListener(v -> {
                Intent intent = new Intent(LoginAdminM.this, LstProductsActivity.class);
                startActivity(intent);
            });
            btnvuelta = findViewById(R.id.imageButton);
            btnvuelta.setOnClickListener(v -> {
                Intent intent = new Intent(LoginAdminM.this, LoginUserM.class);
                startActivity(intent);
            });

    }


    @Override
    public void successLogin(ProductRestaurant productRestaurant) {
        Toast.makeText(mainActivity, productRestaurant.getProducto().getNombre(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(mainActivity, err, Toast.LENGTH_SHORT).show();
    }


}