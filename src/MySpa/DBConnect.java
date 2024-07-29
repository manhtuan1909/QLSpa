package MySpa;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static void main(String[] args) {
        System.out.println("hello");
        getConnection();
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://PIOTISK\\SQLEXPRESS_19:1433;databaseName=Sugong_Spa;"
                    + "encrypt=false;trustServerCertificate=false;"
                    + "hostNameInCertificate=DESKTOP-94RIAE0\\ECUSSQL2008";
            String user = "sa";
            String password = "123";

            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
