package com.example.loginandroid_29_09_2023.login_user.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.MainActivity;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;

public class LoginUserM extends AppCompatActivity implements ContractLoginUser.View{

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    private boolean status;

    private String message;

    private LoginUserPresenter presenter =
            new LoginUserPresenter(this);

    /* PATRÓN SINGLETON*/
    private static LoginUserM mainActivity = null;
    public static LoginUserM getInstance(){
        return mainActivity; //0x457845AF
    }
    /* FIN PATRÓN SINGLETON*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_m);
        mainActivity = this;
        initComponents();

    }
    private void initComponents(){

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                edtEmail = findViewById(R.id.edtEmail);
                edtPassword = findViewById(R.id.edtPassword);
                String valoredtEmail = edtEmail.getText().toString();
                String valoredtPassword = edtPassword.getText().toString();
                if (valoredtEmail.equals("jaime") && valoredtPassword.equals("1234")){
                    User user = new User();
                    user.setUsername("jaime");
                    user.setToken("1234");
                    successLogin( user);
                    presenter.login(user);
                }else{
                    failureLogin("No has puesto bien el usuario y la contraseña");
                }
            }
        });
    }


    @Override
    public void successLogin(User user) {
        Toast.makeText(mainActivity, user.getUsername(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(mainActivity, err, Toast.LENGTH_SHORT).show();
    }
}