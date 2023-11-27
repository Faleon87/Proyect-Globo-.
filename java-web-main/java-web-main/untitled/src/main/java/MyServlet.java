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
import static beans.Puntuacion.convertJsonToPuntuacion;

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
                out.print(selectUsers(request, response).toString());
                break;
            case "PRODUCTREST":
                out.print(selectProductRest(request, response).toString());
                break;
            case "INSERT_PRODUCT":
                out.println(insertProduct(request, response));
                break;
            case "SELECTRESTAURANTVENTAS":
                out.println(selectRestaurantVentas(request, response));
                break;
            case "INSERTCOMENT":
                String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                Puntuacion puntuacion = convertJsonToPuntuacion(requestBody);
                out.println(insertComent(puntuacion));
                break;
        }
    }

    private Puntuacion insertComent(Puntuacion puntuacion) {
      String comentario= puntuacion.getComentario();
      int valorPuntuacion = puntuacion.getPuntuacion();
      int valorIdRest = puntuacion.getId_restaurante();
      SqlAction sql = new SqlAction();
      return sql.insertComent(puntuacion);
    }

    // Métodos restantes

    public String selectRestaurantVentas(HttpServletRequest request, HttpServletResponse response){
        SqlAction sql = new SqlAction();
        ArrayList<ProductRestaurant> r1 = sql.findRestaurantVentas();
        String json = convertToJson(r1);
        return json;
    }
    public MyLoginData selectUsers(HttpServletRequest request, HttpServletResponse response){
        User usuario = new User();
        usuario.setUsername(request.getParameter("USERNAME"));
        usuario.setToken(request.getParameter("TOKEN"));
        SqlAction sql = new SqlAction();
        MyLoginData myloginData = new MyLoginData();
        myloginData.setUser(sql.findUsername(usuario));
        if (sql.findUsername(usuario) != null){
            myloginData.setMessage("Okey");
        }else {
            myloginData.setMessage("Error");
        }
        return  myloginData;
    }
    public String selectProductRest(HttpServletRequest request, HttpServletResponse response){
        SqlAction sql = new SqlAction();
        ArrayList<ProductRestaurant> p1 = sql.findProduct_Restaurant();
        String json = convertToJson(p1);
        return json;
    }

    public ArrayList<ProductRestaurant> insertProduct(HttpServletRequest request, HttpServletResponse response){
        SqlAction sql = new SqlAction();
        ProductRestaurant productRestaurant = new ProductRestaurant();
        Restaurante r1 = new Restaurante();
        Producto p1 = new Producto();
        r1.setNombre(request.getParameter("NOMBRE_REST"));
        p1.setNombre(request.getParameter("NOMBRE_PRODUCTO"));
        p1.setDescripcion(request.getParameter("DESCRIPCION"));
        p1.setImagen(request.getParameter("IMAGEN"));
        p1.setPrecio(Integer.parseInt(request.getParameter("PRECIO")));
        r1.setId_restaurante(Integer.parseInt(request.getParameter("ID_REST")));
        productRestaurant.setRestaurante(r1);
        productRestaurant.setProducto(p1);
        return sql.insertProductRestaurant(productRestaurant);
    }
}
