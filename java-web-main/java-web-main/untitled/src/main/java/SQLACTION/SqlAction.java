package SQLACTION;

import beans.ProductRestaurant;
import beans.Producto;
import beans.Restaurante;
import beans.User;
import motorsql.motorsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlAction {
   private final String SQL_PRODUCT_RESTAURANTE = "select R.NOMBRE  , P.NOMBRE , " +
           "P.DESCRIPCION, P.IMAGEN, P.PRECIO , R.ID_RESTAURANTE FROM RESTAURANTE R JOIN PRODUCTO P ON R.ID_RESTAURANTE = P.ID_RESTAURANTE";
    private final String SQL_LOGIN = "select USERNAME , password from usuario where ";

    private final String SQL_INSERT_PRODUCTO= " INSERT INTO RESTAURANTE(ID_RESTAURANTE ,NOMBRE) VALUES";
    private motorsql motorsql;
    private ResultSet rs;

    public SqlAction() {
        this.motorsql = new motorsql();
    }

//    public  ArrayList<Producto> selectProduct(){
//
//    }

    public  User findUsername(User infouser) { //SELECT * FROM usuario WHERE USERNAME = 'admin' AND password = 'admin'
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
                r1.setId_restaurante(rs.getInt(6));
                productRestaurant.setRestaurante(r1);
                productRestaurant.setProducto(p1);
               listproductRestaurants.add(productRestaurant);
            }
        } catch (SQLException ex){
            System.out.println("Error de sql: " + ex);
        } catch (Exception ex){
            System.out.println("Error: " + ex);
        }
        return listproductRestaurants;
   }
    public ArrayList<ProductRestaurant> insertProductRestaurant(ProductRestaurant productRestaurant) {
        ArrayList<ProductRestaurant> productList = new ArrayList<>();
        String sql = SQL_INSERT_PRODUCTO;
        this.motorsql.connect();
        sql+="(" + productRestaurant.getRestaurante().getId_restaurante() + ", ";
        sql+= "'" + productRestaurant.getRestaurante().getNombre()+ "');";
         this.motorsql.execute(sql);
        // Recupera la lista actual de productos del restaurante
        String sql2="";
        sql2+= "INSERT INTO PRODUCTO (ID_RESTAURANTE, NOMBRE, DESCRIPCION, IMAGEN, PRECIO) VALUES";
        // Construye la consulta de inserción
        sql2 += "(" + productRestaurant.getRestaurante().getId_restaurante() + ", ";
        sql2 += "'" + productRestaurant.getProducto().getNombre() + "', ";
        sql2 += "'" + productRestaurant.getProducto().getDescripcion() + "', ";
        sql2 += "'" + productRestaurant.getProducto().getImagen() + "', ";
        sql2 += productRestaurant.getProducto().getPrecio() + ")";

        // Ejecuta la inserción
        this.motorsql.execute(sql2);
        productList.add(productRestaurant);
        // Devuelve la lista actualizada
        return productList;
    }

}

