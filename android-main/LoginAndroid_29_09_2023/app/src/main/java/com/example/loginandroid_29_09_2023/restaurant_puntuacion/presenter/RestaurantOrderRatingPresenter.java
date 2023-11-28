package com.example.loginandroid_29_09_2023.restaurant_puntuacion.presenter;

import com.example.loginandroid_29_09_2023.beans.RestaurantePuntuacion;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.ContractRestaurantPuntuacion;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.model.RestaurantOrderRatingModel;
import com.example.loginandroid_29_09_2023.restaurant_ventas.ContractProductUser;


import java.util.ArrayList;

public class RestaurantOrderRatingPresenter implements ContractRestaurantPuntuacion.Presenter,
        ContractRestaurantPuntuacion.Model.OnLoginUserListener {
    private ContractProductUser.View vista;
    private com.example.loginandroid_29_09_2023.restaurant_ventas.model.RestaurantModel RestaurantModel;

        private ContractRestaurantPuntuacion.View view;

        private RestaurantOrderRatingModel restaurantOrderRatingModel;

        private ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion = new ArrayList<>();

        public RestaurantOrderRatingPresenter(ContractRestaurantPuntuacion.View view){
            this.view = view;
            restaurantOrderRatingModel = new RestaurantOrderRatingModel(this);
        }
        @Override
        public void login() {
            restaurantOrderRatingModel.loginAPI(this);
        }

        @Override
        public void onFinished(ArrayList<RestaurantePuntuacion> lstRestaurantsPuntuacion) {
            this.lstRestaurantsPuntuacion = lstRestaurantsPuntuacion;
            view.successLogin(lstRestaurantsPuntuacion);
        }

        @Override
        public void onFailure(String err) {

        }
}
