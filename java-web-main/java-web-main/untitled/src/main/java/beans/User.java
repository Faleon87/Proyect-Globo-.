package beans;

public class User {
    private String username;
    private String token; //

    private Cliente cliente;

    //Constructor
    public User(String username, String token , Cliente cliente) {
        this.username = username;
        this.token = token;
        this.cliente=cliente;
    }
    public User(){

    }

    // Getters y setters


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "{" +
                "\"username\":\"" + username + '\"' +
                ", \"token\":\"" + token + '\"' +
                '}';
    }

}
