package com.example.loginandroid_29_09_2023.login_user.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.data.MyLoginData;
import com.example.loginandroid_29_09_2023.login_user.model.data.MyData;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserModel implements ContractLoginUser.Model {
    private static final String IP_BASE = "192.168.0.22:8080";
    private LoginUserPresenter presenter;
    public LoginUserModel(LoginUserPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void loginAPI(User user, final OnLoginUserListener onLoginUserListener) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);
        // Realizar la solicitud al Servlet
        Call<MyLoginData> calls = apiService.getDataUser ("LOGIN", user.getUsername(), user.getToken() );
        calls.enqueue(new Callback<MyLoginData>() {
            @Override
            public void onResponse(Call<MyLoginData> call, Response<MyLoginData> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    try {
                        MyLoginData myData = response.body();
                        if (user.getUsername().equals("jaime")  && user.getToken().equals("1234")){
                           onLoginUserListener.onAdmin(myData.getUser());
                        }
                        if (myData.getMessage().equals("Okey") && !user.getUsername().equals("jaime") && !user.getToken().equals("1234 ")){
                           onLoginUserListener.onFinished(myData.getUser());
                        }else if(myData.getMessage().equals("Error")){
                            onLoginUserListener.onFailure(myData.getMessage());
                        }
                    }catch (Exception ex){
                        System.out.println("error: " + ex);
                    }
                    // Actualizar la interfaz de usuario con el mensaje recibido
                } else {
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
            public void onFailure(Call<MyLoginData> call, Throwable t) {
                // Manejar errores de red o del servidor
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
    }

