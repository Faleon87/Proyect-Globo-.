package com.example.loginandroid_29_09_2023.Parte_admin;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.User;

public interface ContractAdmin {
    public interface View{
        public void successLogin(User user);
        void failureLogin(String err);

    }
    public interface Presenter{
        // void login(String email, String pass);

    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(User user);
            void onFailure(String err);

        }
        void loginAPI(ProductRestaurant infopr,
                      OnLoginUserListener onLoginUserListener);
    }
}
