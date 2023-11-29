import SQLACTION.SqlAction;
import beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static beans.ProductRestaurant.convertToJson;
import static beans.ProductRestaurant.convertToJsonToProductRest;
import static beans.Puntuacion.convertJsonToPuntuacion;
import static beans.RestaurantePuntuacion.convertToJsonRestaurantePuntuacion;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("application/json");
        String action = request.getParameter("ACTION");
        String[] keepaction = action.split("\\.");

        PrintWriter out = response.getWriter();

        switch (keepaction[0]) {
            case "LOGIN":
                out.print(selectUsers(request, response));
                break;
            case "PRODUCTREST":
                out.print(selectProductRest(request, response).toString());
                break;
            case "INSERT_PRODUCT":
                String requestBody1 = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                ProductRestaurant productRestaurant =  convertToJsonToProductRest(requestBody1);
                out.println(insertProduct(productRestaurant));
                break;
            case "SELECTRESTAURANTVENTAS":
                out.println(selectRestaurantVentas(request, response));
                break;
            case "INSERTCOMENT":
                String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                Puntuacion puntuacion = convertJsonToPuntuacion(requestBody);
                out.println(insertComent(puntuacion));
                break;
            case "SELECTRESTAURANTPUNTUACION":
                out.println(selectRestaurantPuntuacion(request, response));
                break;
        }
    }

    private String selectRestaurantPuntuacion(HttpServletRequest request , HttpServletResponse response){
        SqlAction sql = new SqlAction();
        ArrayList<RestaurantePuntuacion> r1 = sql.findRestaurantPuntuacion();
        return convertToJsonRestaurantePuntuacion(r1);

    }
    private String insertComent(Puntuacion puntuacion) {
      String comentario= puntuacion.getComentario();
      int valorPuntuacion = puntuacion.getPuntuacion();
      int valorIdRest = puntuacion.getId_restaurante();
      int valorIdCliente = puntuacion.getId_cliente();
      SqlAction sql = new SqlAction();
      sql.insertComent(puntuacion);
      return Puntuacion.convertoJson(puntuacion);

    }

    // Métodos restantes

    public String selectRestaurantVentas(HttpServletRequest request, HttpServletResponse response){
        SqlAction sql = new SqlAction();
        ArrayList<ProductRestaurant> r1 = sql.findRestaurantVentas();
        return  convertToJson(r1);
    }
    public String selectUsers(HttpServletRequest request, HttpServletResponse response){
        User usuario = new User();
        usuario.setUsername(request.getParameter("USERNAME"));
        usuario.setToken(request.getParameter("TOKEN"));
        SqlAction sql = new SqlAction();
        MyLoginData myloginData = new MyLoginData();
        myloginData.setUser(sql.findUsername(usuario));
        if (sql.findUsername(usuario) != null) {
            myloginData.setMessage("Okey");
        } else {
            myloginData.setMessage("Error");
        }
       return myloginData.convertToJson(myloginData);
    }
    public String selectProductRest(HttpServletRequest request, HttpServletResponse response){
        SqlAction sql = new SqlAction();
        ArrayList<ProductRestaurant> p1 = sql.findProduct_Restaurant();
        return convertToJson(p1);
    }

    public String insertProduct(ProductRestaurant productRestaurant){
       String nombreRestaurante = productRestaurant.getRestaurante().getNombre();
       String nombreProducto = productRestaurant.getProducto().getNombre();
       String descripcionProducto = productRestaurant.getProducto().getDescripcion();
         int precioProducto = productRestaurant.getProducto().getPrecio();
         int idRestaurante = productRestaurant.getRestaurante().getId_restaurante();
        SqlAction sql = new SqlAction();
        sql.insertProductRestaurant(productRestaurant);
        return ProductRestaurant.convertToJsonString(productRestaurant);
    }
}
