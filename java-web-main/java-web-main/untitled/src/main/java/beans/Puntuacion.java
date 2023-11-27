package beans;

import com.google.gson.Gson;

public class Puntuacion {
    private int id_puntuacion;
    private int id_restaurante;
    private int id_cliente;

    private int puntuacion;

    private String comentario;


    public Puntuacion(int id_puntuacion, int id_restaurante, int id_cliente, int puntuacion, String comentario) {
        this.id_puntuacion = id_puntuacion;
        this.id_restaurante = id_restaurante;
        this.id_cliente = id_cliente;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public Puntuacion(){

    }

    public int getId_puntuacion() {
        return id_puntuacion;
    }

    public void setId_puntuacion(int id_puntuacion) {
        this.id_puntuacion = id_puntuacion;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public static String convertoJson(Puntuacion info){
        Gson gson = new Gson();
        return gson.toJson(info);
    }
    public static Puntuacion convertJsonToPuntuacion(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Puntuacion.class);
    }
}
