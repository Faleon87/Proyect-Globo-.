package com.example.loginandroid_29_09_2023.lst_products.model;


import com.example.loginandroid_29_09_2023.beans.Productos;
import com.example.loginandroid_29_09_2023.lst_products.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_products.DataProduct;
import com.example.loginandroid_29_09_2023.lst_products.presenter.LstProductsPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstProductsModel implements ContractListMovies.Model {
    private static final String IP_BASE = " 192.168.0.22:8080";
    private LstProductsPresenter presenter;

    public LstProductsModel(LstProductsPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void moviesAPI(String filtro,
                          OnLstProductoListener respuestaProductos) {


        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);
        Call<DataProduct> call = apiService.getDataProducts("PRODUCTREST");
        call.enqueue(new Callback<DataProduct>() {
            @Override
            public void onResponse(Call<DataProduct> call, Response<DataProduct> response) {
                if (response.isSuccessful()) {
                    DataProduct myData = response.body();
//                    ArrayList<Productos> lstProducto = myData.getLstPeliculas();
//                    respuestaProductos.onFinished(lstProducto);
                }
            }

            @Override
            public void onFailure(Call<DataProduct> call, Throwable t) {

            }
        });
    }
}

