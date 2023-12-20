package com.example.loginandroid_29_09_2023.restaurant_puntuacion.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.RestaurantePuntuacion;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.ContractRestaurantPuntuacion;
import com.example.loginandroid_29_09_2023.restaurant_puntuacion.presenter.RestaurantOrderRatingPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantOrderRatingModel implements ContractRestaurantPuntuacion.Model {

    private static final String IP_BASE = "192.168.104.62:8080";

    private RestaurantOrderRatingPresenter presenter;
    public RestaurantOrderRatingModel(RestaurantOrderRatingPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI( OnLoginUserListener onLoginUserListener) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);
        // Realizar la solicitud al Servlet
        Call<ArrayList<RestaurantePuntuacion>> calls = apiService.getDataRestaurantPuntuacion ("SELECTRESTAURANTPUNTUACION");
        calls.enqueue(new Callback<ArrayList<RestaurantePuntuacion>>() {
            @Override
            public void onResponse(Call<ArrayList<RestaurantePuntuacion>> call, Response<ArrayList<RestaurantePuntuacion>> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    try {
                        ArrayList<RestaurantePuntuacion> myData = response.body();
                        onLoginUserListener.onFinished(myData);
                    }catch (Exception ex){
                        System.out.println("error: " + ex);
                    }
                    // Actualizar la interfaz de usuario con el mensaje recibido
                } else {
                    // Manejar una respuesta no exitosa
                    Log.e("Response Error", "Código de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("Response Error", "Cuerpo de error: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<RestaurantePuntuacion>> call, Throwable t) {
                // Manejar errores de red o del servidor
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
}
