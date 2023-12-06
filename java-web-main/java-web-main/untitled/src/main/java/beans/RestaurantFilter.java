package beans;

public class RestaurantFilter {

    private Restaurante restaurante;
    private double puntuacion;

    public RestaurantFilter(Restaurante restaurante, double puntuacion) {
        this.restaurante = restaurante;
        this.puntuacion = puntuacion;
    }
    public RestaurantFilter(){

    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
