package com.example.loginandroid_29_09_2023.descripcion_restaurante.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.ContractDescripcionRest;
import com.example.loginandroid_29_09_2023.descripcion_restaurante.presenter.DescripcionRestaurantPresenter;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescripcionRestaurantModel implements ContractDescripcionRest.Model {

    private static final  String IP_BASE = "192.168.0.22:8080";

    private DescripcionRestaurantPresenter  presenter;

    public DescripcionRestaurantModel(DescripcionRestaurantPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(User user, ContractLoginUser.Model.OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        Call<ArrayList<Restaurante>> calls = apiService.getDescripcionRest("INFO_REST)");
        calls.enqueue(new Callback<ArrayList<Restaurante>>() {
            @Override
            public void onResponse(Call<ArrayList<Restaurante>> call, Response<ArrayList<Restaurante>> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    try {
                        ArrayList<Restaurante> myData = response.body();

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
            public void onFailure(Call<ArrayList<Restaurante>> call, Throwable t) {

            }
        });
    }
}
