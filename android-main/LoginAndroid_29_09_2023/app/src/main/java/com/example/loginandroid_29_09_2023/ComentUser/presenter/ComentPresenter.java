package com.example.loginandroid_29_09_2023.ComentUser.presenter;

import android.widget.Toast;

import com.example.loginandroid_29_09_2023.ComentUser.ContractUserComent;
import com.example.loginandroid_29_09_2023.ComentUser.model.ComentModel;
import com.example.loginandroid_29_09_2023.beans.Puntuacion;

public class ComentPresenter implements ContractUserComent.Presenter ,  ContractUserComent.Model.OnLoginUserListener{

    public ContractUserComent.View vista;

    private ComentModel comentModel;

    public ComentPresenter(ContractUserComent.View vista){
     this.vista = vista;
     comentModel= new ComentModel(this);
    }

    @Override
    public void addComent(Puntuacion puntuacion) {
        comentModel.loginAPI(puntuacion, this);
    }

    @Override
    public void onFinished() {
        vista.success();
    }

    @Override
    public void onFailure(String err) {
        vista.failure(err);
    }


}
