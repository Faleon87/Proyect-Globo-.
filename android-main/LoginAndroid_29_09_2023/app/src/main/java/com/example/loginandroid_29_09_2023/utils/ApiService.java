package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.beans.ProductRestaurant;
import com.example.loginandroid_29_09_2023.login_user.data.MyLoginData;
import com.example.loginandroid_29_09_2023.lst_products.DataProduct;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
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


       @GET("MyServlet")
      Call<ArrayList<ProductRestaurant>> getMyData(@Query("ACTION") String action, @Query("NOMBRE_REST") String rname,@Query("NOMBRE_PRODUCTO")String pname ,
                                                   @Query("DESCRIPCION") String description,@Query("IMAGEN") String image, @Query("PRECIO") int precio , @Query("ID_REST") int idrest);

//        @GET("MyServlet/{id}")
//        Call<MyData> getMyDataURL(@Path("id") String id);*/

        /*
        @FormUrlEncoded
        @POST("/login")
        Call<ApiResponse> login(@Field("username") String username, @Field("password") String password);
    */
}
