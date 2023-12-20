package com.example.loginandroid_29_09_2023.lst_products.model;


import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.DataProduct;
import com.example.loginandroid_29_09_2023.lst_products.presenter.LstProductsPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstProductsModel implements ContractListMovies.Model {
    private static final String IP_BASE = "192.168.104.62:8080";
    private LstProductsPresenter presenter;

    public LstProductsModel(LstProductsPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void moviesAPI(String filtro,
                          OnLstProductoListener respuestaProductos) {


        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);
        Call<ArrayList<ProductRestaurant>> call = apiService.getDataProducts("PRODUCTREST");
        call.enqueue(new Callback<ArrayList<ProductRestaurant>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductRestaurant>> call, Response<ArrayList<ProductRestaurant>> response) {
                if (response.isSuccessful()) {
                    ArrayList<ProductRestaurant> myData = response.body();
                    respuestaProductos.onFinished(myData);
                    try {
                        System.out.println("myData: " + myData);
                    } catch (Exception ex) {
                        System.out.println("error: " + ex);
                    }
                }else{
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
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
}

