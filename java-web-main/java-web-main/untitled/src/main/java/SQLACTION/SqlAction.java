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

    private final String SQL_SELECT_RESTAURANT_VENTAS = "SELECT ID_RESTAURANTE, NOMBRE, DESCRIPCION, IMAGEN, VENTAS , TEMATICA FROM RESTAURANTE ORDER BY VENTAS DESC";

    private final String SQL_SELECT_RESTAURANT_PUNTUACION="SELECT R.ID_RESTAURANTE, R.NOMBRE, R.IMAGEN, R.DESCRIPCION, ROUND(AVG(P.puntuacion)) AS PUNTUACION_PROMEDIO FROM RESTAURANTE R LEFT JOIN PUNTUACION P ON R.ID_RESTAURANTE = P.ID_RESTAURANTE GROUP BY R.ID_RESTAURANTE, R.NOMBRE, R.IMAGEN, R.DESCRIPCION ORDER BY PUNTUACION_PROMEDIO DESC LIMIT 10;";

    private final String SQL_SELECT_FILTROAVANZADO_1="SELECT " +
            "    R.ID_RESTAURANTE,\n" +
            "    R.NOMBRE,\n" +
            "    R.IMAGEN,\n" +
            "    R.DESCRIPCION,\n" +
            "    R.TEMATICA,\n" +
            "    AVG(P.puntuacion) AS PUNTUACION_PROMEDIO\n" +
            "FROM\n" +
            "    RESTAURANTE R\n" +
            "LEFT JOIN\n" +
            "    PUNTUACION P ON R.ID_RESTAURANTE = P.ID_RESTAURANTE\n" ;
    private final String SQL_SELECT_FILTROAVANZADO_2=
            "GROUP BY\n" +
            "    R.ID_RESTAURANTE,\n" +
            "    R.NOMBRE,\n" +
            "    R.IMAGEN,\n" +
            "    R.DESCRIPCION,\n" +
            "    R.TEMATICA\n";
    private final String SQL_SELECT_FILTROAVANZADO_3=
                    "ORDER BY\n" +
                    "    PUNTUACION_PROMEDIO;\n";
    private final String SQL_INFO_REST = "SELECT NOMBRE, IMAGEN, DESCRIPCION, TEMATICA " + " FROM RESTAURANTE ";

    private final String SQL_SELECT_PRODUCTOS = "SELECT ID_PRODUCTO, DESCRIPCION, IMAGEN, NOMBRE , PRECIO FROM PRODUCTO";

    private final String SQL_INSERT_CARRITO = "INSERT INTO CARRITO(ID_CLIENTE, ID_PRODUCTO) VALUES ";


    private final String SQL_SELECT_CARRITO = "SELECT P.ID_PRODUCTO, P.NOMBRE, P.PRECIO, P.IMAGEN\n" +
            "FROM CARRITO C\n" +
            "JOIN PRODUCTO P ON C.ID_PRODUCTO = P.ID_PRODUCTO\n" +
            "WHERE C.ID_CLIENTE = ";

    private motorsql motorsql;
    private ResultSet rs;

    public ArrayList<Producto> selectinfoProducto(Carrito info){
        String sql = SQL_SELECT_CARRITO;
        sql += info.getId_cliente() + ";" ;
        ArrayList<Producto> lstproducto = new ArrayList<>();
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            while (rs.next()){
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getInt(3));
                producto.setImagen(rs.getString(4));
                lstproducto.add(producto);
            }
        }catch (Exception ex){
            System.out.println("Error: " + ex);
        }
        return lstproducto;
    }

    public Carrito insertCarrito(Carrito carrito) {
        System.out.printf(" id_producto: " + carrito.getId_producto());
        System.out.printf(" id_cliente: " + carrito.getId_cliente());
        String sql = SQL_INSERT_CARRITO;
        try {
            this.motorsql.connect();
            sql += "(" + carrito.getId_cliente() + ", ";
            sql += carrito.getId_producto() + ")";
            this.motorsql.execute(sql);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return null;
        } finally {
            this.motorsql.disconnect();
        }
     return carrito;
    }

    public SqlAction() {
        this.motorsql = new motorsql();
    }

    public ArrayList<Producto> findProductos(){
        String sql = SQL_SELECT_PRODUCTOS;
        ArrayList<Producto> lstproducto = new ArrayList<>();
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            while (rs.next()){
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setImagen(rs.getString(3));
                producto.setNombre(rs.getString(4));
                producto.setPrecio(rs.getInt(5));
                lstproducto.add(producto);
            }
        }catch (Exception ex){
            System.out.println("Error: " + ex);
        }finally {
            this.motorsql.disconnect();
        }
        return lstproducto;
    }
    public Restaurante findRestaurant(Restaurante restaurante) {
        String sql = SQL_INFO_REST;
        sql += "WHERE ID_RESTAURANTE = " + restaurante.getId_restaurante() + ";";
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            while (rs.next()) {
                restaurante.setNombre(rs.getString(1));
                restaurante.setImagen(rs.getString(2));
                restaurante.setDescripcion(rs.getString(3));
                restaurante.setTematica(rs.getString(4));
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        } finally {
            this.motorsql.disconnect();
        }
        return restaurante;
    }

    public ArrayList<RestaurantFilter >findRestaurantePorTematica(RestaurantFilter restaurantFilter){
        ArrayList<RestaurantFilter> listrestaurant = new ArrayList<>();
        String sql = SQL_SELECT_FILTROAVANZADO_1;
        sql+= " WHERE R.TEMATICA = '" + restaurantFilter.getRestaurante().getTematica() + "' ";
        sql+= SQL_SELECT_FILTROAVANZADO_2;
        sql+= " HAVING PUNTUACION_PROMEDIO >= " + restaurantFilter.getPuntuacion() + " ";
        sql+= SQL_SELECT_FILTROAVANZADO_3;
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(sql);
            while (rs.next()) {
                RestaurantFilter restaurantePuntuacion = new RestaurantFilter();
                Restaurante restaurante = new Restaurante();
                restaurante.setId_restaurante(rs.getInt(1));
                restaurante.setNombre(rs.getString(2));
                restaurante.setImagen(rs.getString(3));
                restaurante.setDescripcion(rs.getString(4));
                restaurante.setTematica(rs.getString(5));
                restaurantePuntuacion.setPuntuacion(rs.getDouble(6));
                restaurantePuntuacion.setRestaurante(restaurante);
                listrestaurant.add(restaurantePuntuacion);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return null;
        }finally {
            this.motorsql.disconnect();
        }
        return  listrestaurant;
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
        } catch (Exception ex) {
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
                restaurante.setTematica(rs.getString(6));
                ProductRestaurant productRestaurant = new ProductRestaurant();
                productRestaurant.setRestaurante(restaurante);
                restaurantList.add(productRestaurant);
            }
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

