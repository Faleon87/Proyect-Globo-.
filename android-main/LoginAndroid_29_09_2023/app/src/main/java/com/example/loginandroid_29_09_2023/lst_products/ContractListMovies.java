package com.example.loginandroid_29_09_2023.lst_products;


import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Producto;

import java.util.ArrayList;

public interface ContractListMovies {
    public interface Presenter{
        void lstProductos(String filtro);
    }

    public interface Model{
        void moviesAPI(String filtro,
                       OnLstProductoListener respuestaMovies);

        interface OnLstProductoListener{
            void onFinished(ArrayList<ProductRestaurant> lstProductos);
            void onFailure(String err);
        }

    }
    public interface View{
        public void successMovies(ArrayList<ProductRestaurant>  ProductoRestaurantes);
        void failureMovies(String err);
    }
}
