package beans;

public class Reservas {
    private  int id_reservas;
    private  int id_restaurante;

    public Reservas(int id_reservas, int id_restaurante) {
        this.id_reservas = id_reservas;
        this.id_restaurante = id_restaurante;
    }

    public Reservas(){

    }
    public int getId_reservas() {
        return id_reservas;
    }

    public void setId_reservas(int id_reservas) {
        this.id_reservas = id_reservas;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "id_reservas=" + id_reservas +
                ", id_restaurante=" + id_restaurante +
                '}';
    }

}
