package SQLACTION;

import motorsql.motorsql;

public class SqlAction {
    private String SQL_RESTAURANTE = "select * from restaurante";

    private motorsql motorsql;

    public SqlAction(){
        this.motorsql = new motorsql();
    }

}
