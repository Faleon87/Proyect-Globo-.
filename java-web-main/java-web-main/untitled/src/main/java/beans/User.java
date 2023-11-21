package beans;

public class User {
    private String username;
    private String token; //

    //Constructor
    public User(String username, String token) {
        this.username = username;
        this.token = token;
    }
    // Getters y setters
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
        return "beans.User{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
