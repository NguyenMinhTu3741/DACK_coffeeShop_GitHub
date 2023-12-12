package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnect {
    private static final String dbURL = "jdbc:mysql://localhost:3306/coffeeShop";

    private static final String userName = "root";
    private static final String password = "minhtu150320";

    public static MySQLConnect instance;

    public static MySQLConnect getInstance() {
        if (instance == null) {
            instance = new MySQLConnect();
        }
        return instance;
    }

    private MySQLConnect() {
    }

    private static Connection connection;


    public Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect Done");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
