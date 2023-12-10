package beans;

import com.google.gson.Gson;



public class Carrito {

    private  int id_cliente;
    private int id_producto;
    private int cantidad;

    public Carrito() {
    }

    public Carrito(int id_cliente, int id_producto, int cantidad) {
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static String convertToJsonCarrito2(Carrito info) {
        Gson gson = new Gson();
        return  gson.toJson(info);
    }

    public static Carrito convertToJsonCarrito(String info) {
        Gson gson = new Gson();
        return gson.fromJson(info, Carrito.class);
    }


}
