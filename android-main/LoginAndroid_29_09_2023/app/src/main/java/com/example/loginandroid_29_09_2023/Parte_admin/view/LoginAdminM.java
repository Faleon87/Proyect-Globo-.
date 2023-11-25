package com.example.loginandroid_29_09_2023.Parte_admin.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.Parte_admin.ContractAdmin;
import com.example.loginandroid_29_09_2023.Parte_admin.presenter.LstPAdminPresenter;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;
import com.example.loginandroid_29_09_2023.lst_products.view.LstProductsActivity;

public class LoginAdminM extends AppCompatActivity implements ContractLoginUser.View{



    private ImageButton btnvuelta;

    private Button btnverproductos;
    private String message;


    private LstPAdminPresenter presenter =
            new LstPAdminPresenter((ContractAdmin.View) this);

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
            btnvuelta = findViewById(R.id.imageButton);
            btnverproductos = findViewById(R.id.btnLogin2);
            btnverproductos.setOnClickListener(v -> {
                Intent intent = new Intent(LoginAdminM.this, LstProductsActivity.class);
                startActivity(intent);
            });
            btnvuelta.setOnClickListener(v -> {
                Intent intent = new Intent(LoginAdminM.this, LoginUserM.class);
                startActivity(intent);
            });

    }


    @Override
    public void successLogin(User user) {
        Toast.makeText(mainActivity, user.getUsername(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mainActivity, LstProductsActivity.class);
        startActivity(intent);
    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(mainActivity, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdmin(User user) {
        Toast.makeText(mainActivity, user.getUsername(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mainActivity, LoginAdminM.class);
        startActivity(intent);
    }
}