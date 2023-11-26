package com.example.loginandroid_29_09_2023.restaurant_ventas;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.restaurant_ventas.presenter.LstRestVentasPresenter;

import java.util.ArrayList;

public interface ContractProductUser {
    public interface View{
        public void success(ArrayList<ProductRestaurant> ProductoRestaurantes);
        void failure(String err);


    }
    public interface Presenter{

        void lstProductosRest( String filtro);


    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(ArrayList<ProductRestaurant> lstRestVentasModel);
            void onFailure(String err);

        }
        void loginAPI(String filtro,
                      LstRestVentasPresenter respuestaLstRestVentasPresenter);
    }
}
