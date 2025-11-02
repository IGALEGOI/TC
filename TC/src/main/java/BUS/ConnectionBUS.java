package BUS;

import Entities.ConnectionEntity;

public class ConnectionBUS {
    
    public ConnectionBUS() {
    }
    
    public static ConnectionEntity getConnectionSQL()
    {
        String jdbcUrl = "jdbc:sqlserver://localhost\\SQLSERVER2022:1433;databaseName=JUNDIAIGRAPH_TC;IntegratedSecurity=false;encrypt=true;trustServerCertificate=true";
        String userNameDB = "sa";
        String passwordDB = "SQLSERVER2022";
        
        return new ConnectionEntity(jdbcUrl, userNameDB, passwordDB);
    }
}
