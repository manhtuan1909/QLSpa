package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect_Db {

    private String user;
    private String password;
    private String db;
    private String connectionUrl;

    public String getConnectionUrl() {
        return "jdbc:sqlserver://" + getServer() + ":1433;"
                + "database=" + getDb() + ";"
                + "user=" + getUser() + ";"
                + "password=" + getPassword() + ";"
                + "encrypt=false;" // chỉ định rằng không sử dụng mã hóa cho kết nối.
                + "trustServerCertificate=true;" // cho phép JDBC tin tưởng chứng chỉ máy chủ mặc dù không được kiểm tra.
                + "loginTimeout=30;" //  Thời gian chờ khi thử kết nối. Ở đây, loginTimeout=30 chỉ định rằng thời gian chờ là 30 giây.
                + "characterEncoding=UTF-8"; // Cài đặt bộ mã hóa ký tự. Ở đây, characterEncoding=UTF-8 chỉ định sử dụng mã hóa UTF-8 để đảm bảo hỗ trợ các ký tự đa byte.
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    private String server;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public Connect_Db() {
        server = "PIOTISK\\SQLEXPRESS_19";
        user = "sa";
        password = "123";
        db = "Sugong_Spa";
        connectionUrl = getConnectionUrl();
    }

    public Connect_Db(String server, String user, String password, String db) {
        this.server = server;
        this.user = user;
        this.password = password;
        this.db = db;
    }

    public Connection connectDB() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(connectionUrl);
            if (conn != null) {
                return conn;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect_Db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
