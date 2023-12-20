package com.example.loginandroid_29_09_2023.mostrarProductos.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.mostrarProductos.MostrarProductosInterface;
import com.example.loginandroid_29_09_2023.mostrarProductos.presenter.MostrarProductosPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostrarProductosModel implements MostrarProductosInterface.Model {


    private static final String IP_BASE = "192.168.104.62:8080";
    private MostrarProductosPresenter mostrarProductosPresenter;

    public MostrarProductosModel(MostrarProductosPresenter mostrarProductosPresenter){
        this.mostrarProductosPresenter = mostrarProductosPresenter;
    }
    @Override
    public void loginAPI(OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        Call<ArrayList<Producto>> calls = apiService.getDataProductos("SELECT_PRODUCTOS");
        calls.enqueue(new Callback<ArrayList<Producto>>() {
            @Override
            public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    try {
                        ArrayList<Producto> myData = response.body();
                        onLoginUserListener.onFinished(myData);

                    }catch (Exception ex){
                        System.out.println("error: " + ex);
                    }
                    // Actualizar la interfaz de usuario con el mensaje recibido
                } else {
                    // Manejar una respuesta no exitosa
                    //Log.e("Response Error", "Código de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        //Log.e("Response Error", "Cuerpo de error: " + errorBody);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
}
