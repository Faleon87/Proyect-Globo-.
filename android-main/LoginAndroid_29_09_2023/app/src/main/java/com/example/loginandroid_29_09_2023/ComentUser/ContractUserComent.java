package com.example.loginandroid_29_09_2023.ComentUser;

import com.example.loginandroid_29_09_2023.ComentUser.presenter.ComentPresenter;
import com.example.loginandroid_29_09_2023.beans.Puntuacion;

public interface ContractUserComent {
    public interface View {
        public void success();

        void failure(String err);
    }
    public interface Presenter{
        void addComent(Puntuacion puntuacion);
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished();
            void onFailure(String err);
        }
        void loginAPI(Puntuacion puntuacion,
                      ComentPresenter comentPresenter);
    }
}
