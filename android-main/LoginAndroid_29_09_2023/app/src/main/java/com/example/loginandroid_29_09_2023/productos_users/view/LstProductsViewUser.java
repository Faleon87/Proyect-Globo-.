package com.example.loginandroid_29_09_2023.productos_users.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.Parte_admin.view.LoginAdminM;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.lst_products.view.LstProductsActivity;
import com.example.loginandroid_29_09_2023.productos_users.ContractProductUser;

public class LstProductsViewUser extends AppCompatActivity implements ContractProductUser.View{

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    private String message;



    /* PATRÓN SINGLETON*/
    private static LstProductsViewUser mainActivity = null;
    public static LstProductsViewUser getInstance(){
        return mainActivity; //0x457845AF
    }
    /* FIN PATRÓN SINGLETON*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_user);
        mainActivity = this;
        initComponents();
    }
    private void initComponents(){

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public void successLogin(User user) {

    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(mainActivity, err, Toast.LENGTH_SHORT).show();
    }


}