package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.beans.Puntuacion;
import com.example.loginandroid_29_09_2023.beans.RestaurantFilter;
import com.example.loginandroid_29_09_2023.beans.Restaurante;
import com.example.loginandroid_29_09_2023.beans.RestaurantePuntuacion;
import com.example.loginandroid_29_09_2023.login_user.data.MyLoginData;
import com.example.loginandroid_29_09_2023.lst_products.DataProduct;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

      @Headers({
              "Accept: application/json",
              "Content-Type: application/json"
      })
//
//      @GET("MyServlet")
//      Call<MyData> getDataUser(@Query("ACTION") String action);
        @GET("MyServlet")
        Call<MyLoginData> getDataUser(@Query("ACTION") String action,
                                      @Query("USERNAME") String username,
                                      @Query("TOKEN") String token);


        @GET("MyServlet")
        Call<ArrayList<ProductRestaurant>> getDataProducts(@Query("ACTION") String action);


       @POST("MyServlet")
       Call<ProductRestaurant> sendDataProductRest(
               @Query("ACTION") String action,
               @Body ProductRestaurant productRestaurant
       );


       @GET("MyServlet")
        Call<ArrayList<ProductRestaurant>> getDataRestaurantVentas (@Query("ACTION") String action);


         @POST("MyServlet")
         Call<Puntuacion> sendData(
            @Query("ACTION") String action,
            @Body Puntuacion puntuacion
        );
         @GET("MyServlet")
         Call<ArrayList<RestaurantePuntuacion>> getDataRestaurantPuntuacion(@Query("ACTION") String action);

         @GET("MyServlet")
        Call<ArrayList<Restaurante>> getDescripcionRest(@Query("ACTION")String action);

            @GET("MyServlet")
            Call<ArrayList<RestaurantFilter>> getFilterAvanzado(@Query("ACTION") String action, @Query("PUNTUACION") double puntuacion, @Query("TEMATICA") String tematica);
         /*
        @FormUrlEncoded
        @POST("/login")
        Call<ApiResponse> login(@Field("username") String username, @Field("password") String password);
    */
}
