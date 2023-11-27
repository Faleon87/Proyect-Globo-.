package com.example.loginandroid_29_09_2023.ComentUser.view;

import android.os.Bundle;
import android.os.PersistableBundle;

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
    }

    @Override
    public void success() {

    }

    @Override
    public void failure(String err) {

    }
}
