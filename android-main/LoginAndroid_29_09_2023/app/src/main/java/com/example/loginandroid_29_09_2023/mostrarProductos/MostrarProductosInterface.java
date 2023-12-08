package com.example.loginandroid_29_09_2023.mostrarProductos;

public interface MostrarProductosInterface {
    public interface View{
        public void success();
        void failureLogin(String err);
    }
    public interface Presenter{
        // void login(String email, String pass);
            void login();
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished();
            void onFailure(String err);

        }
        void loginAPI(OnLoginUserListener onLoginUserListener);
    }
}
