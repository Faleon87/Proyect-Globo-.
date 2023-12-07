package motorsql;

import interfaces.MotorSql;

import java.sql.*;



public class motorsql implements MotorSql {
    String INSTANCE_HOSTNAME = "localhost";
    String INSTANCE_PORT="3306";

    String JDBC_URL = "jdbc:mysql://" + INSTANCE_HOSTNAME + ":" + INSTANCE_PORT + "/glovo";

    private Connection conn;
    private Statement st;
    private ResultSet rs;


    @Override
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, "root", "");
            st = conn.createStatement();
        }catch (SQLException ex){
            System.out.println("Error: " + ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int execute(String sql) {
        int rs = 0;
        try {
            rs = st.executeUpdate(sql);
        }catch (SQLException ex){
            System.out.println("Error: " + ex);
        }
        return  rs;
    }

    @Override
    public ResultSet executeQuery(String sql) {
        try {
            rs= st.executeQuery(sql);
        }catch (SQLException ex){
            System.out.println("Error: " + ex);
        }
        return rs;
    }
    @Override
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        catch (SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
}
