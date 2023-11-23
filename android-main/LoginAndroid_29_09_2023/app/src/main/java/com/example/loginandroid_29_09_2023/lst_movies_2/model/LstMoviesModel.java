package com.example.loginandroid_29_09_2023.lst_movies_2.model;

import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.lst_movies_2.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_movies_2.DataProduct;
import com.example.loginandroid_29_09_2023.lst_movies_2.presenter.LstMoviesPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstMoviesModel implements ContractListMovies.Model {
    private static final String IP_BASE = " 192.168.0.22:8080";
    private LstMoviesPresenter presenter;

    public LstMoviesModel(LstMoviesPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void moviesAPI(String filtro,
                          OnLstMoviesListener respuestaMovies) {

        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);
        Call<DataProduct> call = apiService.getDataProducts("PRODUCTREST");
        call.enqueue(new Callback<DataProduct>() {
            @Override
            public void onResponse(Call<DataProduct> call, Response<DataProduct> response) {
                if (response.isSuccessful()) {
                    DataProduct myData = response.body();
                    ArrayList<Producto> lstProducto = myData.getLstPeliculas();
                    respuestaMovies.onFinished(lstProducto);
                }
            }

            @Override
            public void onFailure(Call<DataProduct> call, Throwable t) {

            }
        });
    }
}

