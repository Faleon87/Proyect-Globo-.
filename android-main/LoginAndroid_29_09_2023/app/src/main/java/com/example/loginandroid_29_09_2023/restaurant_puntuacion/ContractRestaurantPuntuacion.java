package com.example.loginandroid_29_09_2023.restaurant_puntuacion;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.RestaurantePuntuacion;

import java.util.ArrayList;

public interface ContractRestaurantPuntuacion {
    public interface View{
        public void successLogin(ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion);
        void failureLogin(String err);

    }
    public interface Presenter{
        // void login(String email, String pass);
            void login();
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion);
            void onFailure(String err);

        }
        void loginAPI(OnLoginUserListener onLoginUserListener);
    }
}
