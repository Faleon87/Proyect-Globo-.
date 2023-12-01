package SQLACTION;

import beans.*;
import motorsql.motorsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlAction {
   private final String SQL_PRODUCT_RESTAURANTE = "select R.NOMBRE  , P.NOMBRE , " +
           "P.DESCRIPCION, P.IMAGEN, P.PRECIO , R.ID_RESTAURANTE FROM RESTAURANTE R JOIN PRODUCTO P ON R.ID_RESTAURANTE = P.ID_RESTAURANTE";
    private final String SQL_LOGIN = "SELECT " + "    U.ID_CLIENTE, " + " U.USERNAME, " + " U.PASSWORD " + " FROM " + " USUARIO U " +
            "JOIN " + " CLIENTE C ON U.ID_CLIENTE = C.ID_CLIENTE  where ";

    private final String SQL_INSERT_PRODUCTO= " INSERT INTO PUNTUACION (ID_RESTAURANTE, ID_CLIENTE, PUNTUACION, COMENTARIO) VALUES ";

    private final String SQL_INSERT_RESTAURANTE = "INSERT INTO RESTAURANTE (ID_RESTAURANTE,NOMBRE) VALUES ";

    private final String SQL_SELECT_RESTAURANT_VENTAS = "SELECT ID_RESTAURANTE, NOMBRE, DESCRIPCION, IMAGEN, VENTAS FROM RESTAURANTE ORDER BY VENTAS DESC";

    private final String SQL_SELECT_RESTAURANT_PUNTUACION="SELECT R.ID_RESTAURANTE, R.NOMBRE, R.IMAGEN, R.DESCRIPCION, ROUND(AVG(P.puntuacion)) AS PUNTUACION_PROMEDIO FROM RESTAURANTE R LEFT JOIN PUNTUACION P ON R.ID_RESTAURANTE = P.ID_RESTAURANTE GROUP BY R.ID_RESTAURANTE, R.NOMBRE, R.IMAGEN, R.DESCRIPCION ORDER BY PUNTUACION_PROMEDIO DESC LIMIT 10;";

    private final String SQL_SELECT_TEMATICA="SELECT * FROM RESTAURANTE WHERE";

    private motorsql motorsql;
    private ResultSet rs;


    public SqlAction() {
        this.motorsql = new motorsql();
    }

    public Restaurante findRestaurantePorTematica(){
        Restaurante restaurante = new Restaurante();
        String sql = SQL_SELECT_TEMATICA + "TEMATICA = " + restaurante.getTematica();
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            if (rs.next()) {
                restaurante.setId_restaurante(rs.getInt(1));
                restaurante.setNombre(rs.getString(2));
                restaurante.setImagen(rs.getString(3));
                restaurante.setDescripcion(rs.getString(4));
                restaurante.setVentas(rs.getInt(5));
                return restaurante;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return null;
        }finally {
            this.motorsql.disconnect();
        }
    }
    public ArrayList<RestaurantePuntuacion> findRestaurantPuntuacion() {
        String sql = SQL_SELECT_RESTAURANT_PUNTUACION;
        ArrayList<RestaurantePuntuacion> restaurantList = new ArrayList<>();
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            while (rs.next()) {
                Restaurante restaurante = new Restaurante();
                Puntuacion puntuacion = new Puntuacion();
                restaurante.setId_restaurante(rs.getInt(1));
                restaurante.setNombre(rs.getString(2));
                restaurante.setImagen(rs.getString(3));
                restaurante.setDescripcion(rs.getString(4));
                puntuacion.setPuntuacion(rs.getInt(5));
                RestaurantePuntuacion productRestaurant = new RestaurantePuntuacion();
                productRestaurant.setPuntuacion(puntuacion);
                productRestaurant.setRestaurante(restaurante);
                restaurantList.add(productRestaurant);
            }
        } catch (SQLException ex) {
            System.out.println("Error de sql: " + ex);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }finally {
            this.motorsql.disconnect();
        }
        return restaurantList;
    }
    public Puntuacion insertComent(Puntuacion puntacion){
        String sql = SQL_INSERT_PRODUCTO;
        try {
                 this.motorsql.connect();
                Puntuacion puntuacion = new Puntuacion();
                sql += "(" + puntacion.getId_restaurante() + ", ";
                sql += puntacion.getId_cliente() + ", ";
                sql += puntacion.getPuntuacion() + ", ";
                sql += "'" + puntacion.getComentario() + "')";
                this.motorsql.execute(sql);
                return puntuacion;

        }catch (Exception ex){
            System.out.println("Error: " + ex);
        }finally {
            this.motorsql.disconnect();
        }
        return null;
    }
    public  User findUsername(User infouser) { //SELECT * FROM usuario WHERE USERNAME = 'admin' AND password = 'admin'
        String sql = SQL_LOGIN + "U.USERNAME = '" + infouser.getUsername() + "' AND U.password= '" + infouser.getToken() + "'";
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            if (rs.next()) {
                User usuario = new User();
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt(1));
                usuario.setUsername(rs.getString(2));
                usuario.setToken(rs.getString(3));
                usuario.setCliente(cliente);
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return null;
        }finally {
            this.motorsql.disconnect();
        }
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
        }finally {
            this.motorsql.disconnect();
        }
        return listproductRestaurants;
   }

   public ArrayList<ProductRestaurant> findRestaurantVentas() {
        String sql = SQL_SELECT_RESTAURANT_VENTAS;
        ArrayList<ProductRestaurant> restaurantList = new ArrayList<>();
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            while (rs.next()) {
                Restaurante restaurante = new Restaurante();
                restaurante.setId_restaurante(rs.getInt(1));
                restaurante.setNombre(rs.getString(2));
                restaurante.setDescripcion(rs.getString(3));
                restaurante.setImagen(rs.getString(4));
                restaurante.setVentas(rs.getInt(5));
                ProductRestaurant productRestaurant = new ProductRestaurant();
                productRestaurant.setRestaurante(restaurante);
                restaurantList.add(productRestaurant);
            }
        } catch (SQLException ex) {
            System.out.println("Error de sql: " + ex);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }finally {
            this.motorsql.disconnect();
        }
        return restaurantList;
    }

    public ArrayList<ProductRestaurant> insertProductRestaurant(ProductRestaurant productRestaurant) {
        ArrayList<ProductRestaurant> productList = new ArrayList<>();
        String sql = SQL_INSERT_RESTAURANTE;
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
        this.motorsql.disconnect();
        // Devuelve la lista actualizada
        return productList;
    }

}

