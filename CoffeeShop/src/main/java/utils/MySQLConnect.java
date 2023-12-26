package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnect {
    private static final String dbURL = "jdbc:mysql://localhost:3306/coffeeShop";

    private static final String userName = "root";
    private static final String password = "minhtu150320";
      private static Connection connection;


    public static Connection getConn() throws SQLException {
        // singleton
        if (connection == null) {
            connection = getConnection();
        }
        return connection;
    }

    private MySQLConnect() {
    }

  


    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, userName, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
