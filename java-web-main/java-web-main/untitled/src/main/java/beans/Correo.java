package beans;

import com.google.gson.Gson;

public class Correo {
    private String correo;

    private int id_cliente;

    public Correo(String correo, int id_cliente) {
        this.correo = correo;
        this.id_cliente = id_cliente;
    }

    public Correo(){

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public static Correo convertToJsonCorreo(String info) {
        Gson gson = new Gson();
        return  gson.fromJson(info, Correo.class);
    }

    public static String convertToJsonCorreo2(Correo info) {
        Gson gson = new Gson();
        return  gson.toJson(info);
    }
}
