package SQLACTION;

import beans.ProductRestaurant;
import beans.Producto;
import beans.Restaurante;
import beans.User;
import motorsql.motorsql;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlAction {
   private final String SQL_PRODUCT_RESTAURANTE = "select R.NOMBRE  , P.NOMBRE , " +
           "P.DESCRIPCION, P.IMAGEN, P.PRECIO FROM RESTAURANTE R JOIN PRODUCTO P ON R.ID_RESTAURANTE = P.ID_RESTAURANTE";

    private final String SQL_LOGIN = "select USERNAME , password from usuario where ";

    private motorsql motorsql;
    private ResultSet rs;

    public SqlAction() {
        this.motorsql = new motorsql();
    }

//    public  ArrayList<Producto> selectProduct(){
//
//    }

    public  User findUsername(User infouser) {
        String sql = SQL_LOGIN;
        sql+= "USERNAME = '" + infouser.getUsername() + "' AND password= '" + infouser.getToken() + "'";
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            while (rs.next()) {
                User usuario = new User();
                usuario.setUsername(rs.getString(1));
                usuario.setToken(rs.getString(2));
                return usuario;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);

        }
            return null;
    }

    public ArrayList<ProductRestaurant> findProduct_Restaurant(){
        String sql = SQL_PRODUCT_RESTAURANTE;
        ArrayList <ProductRestaurant> listproductRestaurants = new ArrayList<>();
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            while (rs.next()){
               ProductRestaurant productRestaurant = new ProductRestaurant();
               Restaurante r1 = new Restaurante();
               Producto p1 = new Producto();
                r1.setNombre(rs.getString(1));
                p1.setNombre(rs.getString(2));
                p1.setDescripcion(rs.getString(3));
                p1.setImagen(rs.getString(4));
                p1.setPrecio(rs.getInt(5));

                productRestaurant.setRestaurante(r1);
                productRestaurant.setProducto(p1);
               listproductRestaurants.add(productRestaurant);
            }
        }catch (Exception ex){
            System.out.println("Error: " + ex);
        }
        return listproductRestaurants;
    }
}

