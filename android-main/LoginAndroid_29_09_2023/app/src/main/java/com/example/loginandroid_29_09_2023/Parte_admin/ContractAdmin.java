package com.example.loginandroid_29_09_2023.Parte_admin;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.beans.User;

import java.util.ArrayList;

public interface ContractAdmin {
    public interface View{
        public void successLogin(ProductRestaurant productRestaurant);
        void failureLogin(String err);

    }
    public interface Presenter{
        // void login(String email, String pass);
            void login(ProductRestaurant infopr);
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(ProductRestaurant user);
            void onFailure(String err);

        }
        void loginAPI(ProductRestaurant infopr,
                      OnLoginUserListener onLoginUserListener);
    }
}
