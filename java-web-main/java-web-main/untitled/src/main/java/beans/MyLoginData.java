package beans;

import com.google.gson.Gson;

public class MyLoginData {
    private String message;
    private User user;

    private Cliente cliente;


    public MyLoginData(String message, User user, Cliente cliente) {
        this.message = message;
        this.user = user;
        this.cliente = cliente;
    }

    public MyLoginData(){

    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String convertToJson(MyLoginData info) {
        Gson gson = new Gson();
        return gson.toJson(info);
    }
}
