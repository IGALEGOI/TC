package Entities;

public class ConnectionEntity {
    private String jdbcUrl;
    private String userNameDB;
    private String passwordDB;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserNameDB() {
        return userNameDB;
    }

    public void setUserNameDB(String userNameDB) {
        this.userNameDB = userNameDB;
    }

    public String getPasswordDB() {
        return passwordDB;
    }

    public void setPasswordDB(String passwordDB) {
        this.passwordDB = passwordDB;
    }

    public ConnectionEntity() {
    }
    
    public ConnectionEntity(String jdbcUrl, String userNameDB, String passwordDB) {
        this.jdbcUrl = jdbcUrl;
        this.userNameDB = userNameDB;
        this.passwordDB = passwordDB;
    }
}
