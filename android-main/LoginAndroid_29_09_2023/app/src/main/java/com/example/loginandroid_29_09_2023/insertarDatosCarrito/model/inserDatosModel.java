package com.example.loginandroid_29_09_2023.insertarDatosCarrito.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.Carrito;
import com.example.loginandroid_29_09_2023.beans.Producto;
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
    public void loginAPI(Carrito carrito, OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" +  IP_BASE + "/untitled/").
                create(ApiService.class);
        Call <Carrito> call = apiService.sendDataProduct("INSERTAR_DATOS_CARRITO" ,carrito );
    call.enqueue(new Callback<Carrito>() {
            @Override
            public void onResponse(Call<Carrito> call, Response<Carrito> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    try {
                        Carrito myData = response.body();
                        carrito.setId_cliente(myData.getId_cliente());
                        onLoginUserListener.onFinished(carrito);

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
            public void onFailure(Call<Carrito> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }

    @Override
    public void productoAPI(Carrito carrito, OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" +  IP_BASE + "/untitled/").
                create(ApiService.class);
        Call <Producto> call = apiService.selectProductUser("SELECT_PRODUCTOS_USER" ,carrito.getId_cliente());
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    try {
                        Producto myData = response.body();
                        onLoginUserListener.onFinished2(myData);
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
            public void onFailure(Call<Producto> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }


}
