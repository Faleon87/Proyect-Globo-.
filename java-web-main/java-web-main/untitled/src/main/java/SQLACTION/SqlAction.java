package SQLACTION;

import beans.Producto;
import beans.Restaurante;
import beans.User;
import motorsql.motorsql;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlAction {
    private final String SQL = "select R.NOMBRE  P.ID_PRODUCTO, P.NOMBRE , " +
            "P.DESCRIPCION, P.IMAGEN, P.PRECIO FROM RESTAURANTE R JOIN PRODUCTO P ON R.ID_RESTAURANTE = P.ID_RESTAURANTE";

    private final String SQL_user = "select USERNAME , password from usuario ";

    private motorsql motorsql;
    private ResultSet rs;

    public SqlAction() {
        this.motorsql = new motorsql();
    }

//    public  ArrayList<Producto> selectProduct(){
//
//    }

    public ArrayList<User> usuarios() {
        String Sql = SQL;

        ArrayList<User> listUsuarios = new ArrayList<>();
        try {
            this.motorsql.connect();
            rs = this.motorsql.executeQuery(Sql);
            while (rs.next()) {
                User usuario = new User();
                usuario.setUsername(rs.getString(0));
                usuario.setToken(rs.getString(1));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);

        }
            return null;
    }
}
