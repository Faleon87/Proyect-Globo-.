package com.example.loginandroid_29_09_2023.lst_products;

import com.example.loginandroid_29_09_2023.beans.Producto;

import java.util.ArrayList;

public interface ContractListMovies {
    public interface Presenter{
        void lstMovies(String filtro);
    }

    public interface Model{
        void moviesAPI(String filtro,
                       OnLstMoviesListener respuestaMovies);

        interface OnLstMoviesListener{
            void onFinished(ArrayList<Producto> lstPelicula);
            void onFailure(String err);
        }

    }
    public interface View{
        public void successMovies(ArrayList<Producto> lstPelicula);
        void failureMovies(String err);
    }
}
