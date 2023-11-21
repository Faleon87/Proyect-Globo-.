package SQLACTION;

import beans.Producto;
import beans.Restaurante;
import beans.User;
import motorsql.motorsql;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlAction {
//    private final String SQL = "select R.NOMBRE  P.ID_PRODUCTO, P.NOMBRE , " +
//            "P.DESCRIPCION, P.IMAGEN, P.PRECIO FROM RESTAURANTE R JOIN PRODUCTO P ON R.ID_RESTAURANTE = P.ID_RESTAURANTE";

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
}
