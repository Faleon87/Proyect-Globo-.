package com.example.loginandroid_29_09_2023.lst_products;


import com.example.loginandroid_29_09_2023.beans.Productos;

import java.util.ArrayList;

public interface ContractListMovies {
    public interface Presenter{
        void lstMovies(String filtro);
    }

    public interface Model{
        void moviesAPI(String filtro,
                       OnLstProductoListener respuestaMovies);

        interface OnLstProductoListener{
            void onFinished(ArrayList<Productos> lstProductos);
            void onFailure(String err);
        }

    }
    public interface View{
        public void successMovies(ArrayList<Productos> lstProductos);
        void failureMovies(String err);
    }
}
