package com.example.loginandroid_29_09_2023.ComentUser.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.ComentUser.ContractUserComent;
import com.example.loginandroid_29_09_2023.ComentUser.presenter.ComentPresenter;
import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComentModel implements ContractUserComent.Model{

    private  static final String IP_BASE = "192.168.0.22:8080";
    private ComentPresenter presenter;

    public ComentModel(ComentPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(String coment, ComentPresenter comentPresenter) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);
        // Realizar la solicitud al Servlet
        Call<ArrayList<ProductRestaurant>> calls = apiService.getDataRestaurantVentas ("INSERTCOMENT");
        calls.enqueue(new Callback<ArrayList<ProductRestaurant>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductRestaurant>> call, Response<ArrayList<ProductRestaurant>> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    try {
                        ArrayList<ProductRestaurant> myData = response.body();
//                        respuestaLstRestVentasPresenter.onFinished(myData);
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
            public void onFailure(Call<ArrayList<ProductRestaurant>> call, Throwable t) {
                // Manejar errores de red o del servidor
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        }


}
