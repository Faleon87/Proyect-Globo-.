package com.example.loginandroid_29_09_2023.descripcion_restaurante;

import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;

public interface ContractDescripcionRest {
    public interface View{
        public void successLogin(User user);
        void failureLogin(String err);

    }
    public interface Presenter{
        // void login(String email, String pass);
        void login(User user);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(User user);
            void onFailure(String err);
        }
        void loginAPI(User user,
                      ContractLoginUser.Model.OnLoginUserListener onLoginUserListener);
    }
}
