package com.example.loginandroid_29_09_2023.insertarDatosCarrito.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.Carrito;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.insertarDatosCarrito;
import com.example.loginandroid_29_09_2023.insertarDatosCarrito.presenter.inserDatosPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class inserDatosModel implements insertarDatosCarrito.Model {

    private static final String IP_BASE = "192.168.0.22:8080";

    private inserDatosPresenter presenter;

    public inserDatosModel(inserDatosPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(ArrayList<Carrito> lstCarrito , OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" +  IP_BASE + "/untitled/").
                create(ApiService.class);
        Call <ArrayList<Carrito>> call = apiService.sendDataProduct("INSERTAR_DATOS_CARRITO" , lstCarrito);
    call.enqueue(new Callback<ArrayList<Carrito>>() {
            @Override
            public void onResponse(Call<ArrayList<Carrito>> call, Response<ArrayList<Carrito>> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    try {
                        ArrayList<Carrito> myData = response.body();
                        onLoginUserListener.onFinished();

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
            public void onFailure(Call<ArrayList<Carrito>> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
}
