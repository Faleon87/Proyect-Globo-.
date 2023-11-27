package com.example.loginandroid_29_09_2023.ComentUser.presenter;

import com.example.loginandroid_29_09_2023.ComentUser.ContractUserComent;
import com.example.loginandroid_29_09_2023.ComentUser.model.ComentModel;

public class ComentPresenter implements ContractUserComent.Presenter ,  ContractUserComent.Model.OnLoginUserListener{

    public ContractUserComent.View vista;

    private ComentModel comentModel;

    public ComentPresenter(ContractUserComent.View vista){
     this.vista = vista;
     comentModel= new ComentModel(this);
    }

    @Override
    public void addComent(String coment) {
        ComentModel.loginAPI(coment, this);
    }

    @Override
    public void onFinished() {

    }

    @Override
    public void onFailure(String err) {
        vista.failure(err);
    }


}
