package com.example.loginandroid_29_09_2023.ComentUser.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.ComentUser.ContractUserComent;
import com.example.loginandroid_29_09_2023.R;

public class ComentView extends AppCompatActivity implements ContractUserComent.View {


    private static ComentView mainActivity = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coment_user);
        mainActivity = this;
        initComponents();
    }
    private  void initComponents(){
        btn
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
