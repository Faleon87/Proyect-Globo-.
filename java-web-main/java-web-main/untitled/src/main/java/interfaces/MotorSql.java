package interfaces;

import java.sql.ResultSet;

public interface MotorSql {
    public void connect();
    public int execute(String sql);
    public ResultSet executeQuery(String sql);
    public void disconnect();
}
