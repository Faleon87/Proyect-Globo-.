import SQLACTION.SqlAction;
import beans.*;
import services.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static beans.Carrito.convertToJsonCarrito;
import static beans.ProductRestaurant.convertToJson;
import static beans.ProductRestaurant.convertToJsonToProductRest;
import static beans.Producto.convertoJson;
import static beans.Puntuacion.convertJsonToPuntuacion;
import static beans.Restaurante.*;
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
            case "RESTAURANTE_FILTER":
                out.println(selectRestaurantTematica(request, response));
                break;
            case "INFO_REST":
                out.println(selectInfoRest(request, response));
                break;
            case "SELECT_PRODUCTOS":
                out.println(selectProductos(request, response));
                break;
            case "SEND_MAIL":
                try {
                    MailService mailService = new MailService("smtp.gmail.com", 587);
                    mailService.sendMail("a26969@svalero.com","a26969@svalero.com","Prueba","Prueba");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "INSERTAR_DATOS_CARRITO":
                String requestBody2 = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                Carrito carrito = convertToJsonCarrito(requestBody2);
                out.println(insertCarrito(carrito));

                break;
        }
    }

    private String insertCarrito(Carrito carrito) {
        SqlAction sql = new SqlAction();
        int id_producto = carrito.getId_producto();
        int id_cliente = carrito.getId_cliente();
        sql.insertCarrito(carrito);
        return Carrito.convertToJsonCarrito2(carrito);
    }
    private String selectProductos(HttpServletRequest request, HttpServletResponse response) {
        SqlAction sql = new SqlAction();
        ArrayList<Producto> p1 = sql.findProductos();
        return convertoJson(p1);
    }

    private String selectInfoRest(HttpServletRequest request, HttpServletResponse response) {
        SqlAction sql = new SqlAction();
        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(Integer.parseInt(request.getParameter("IDRESTAURANTE")));
        Restaurante restaurant = sql.findRestaurant(restaurante);
        return converToJsonRestaurante(restaurant);


    }

    private String selectRestaurantTematica(HttpServletRequest request, HttpServletResponse response) {
        SqlAction sql = new SqlAction();
        RestaurantFilter restaurantFilter = new RestaurantFilter();
        Restaurante restaurante = new Restaurante();
        restaurante.setTematica(request.getParameter("TEMATICA"));
        restaurantFilter.setRestaurante(restaurante);
        restaurantFilter.setPuntuacion(Double.parseDouble(request.getParameter("PUNTUACION")));
        ArrayList<RestaurantFilter> r1 = sql.findRestaurantePorTematica(restaurantFilter);
        return convertToJsonRestauranteFilterArraylist(r1);
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
