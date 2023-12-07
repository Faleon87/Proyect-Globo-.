package com.example.loginandroid_29_09_2023.descripcion_restaurante;

import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;

import java.util.ArrayList;

public interface ContractDescripcionRest {
    public interface View{
        public void successLogin(Restaurante restaurante);
        void failureLogin(String err);

    }
    public interface Presenter{
        // void login(String email, String pass);
        void login(Restaurante restaurant);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished( Restaurante restaurant);
            void onFailure(String err);
        }
        void loginAPI(Restaurante restaurantes);
    }
}
