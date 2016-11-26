package DAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static Connection instance = null;
    private static final String DB_URL = "jdbc:mysql://54.200.61.123:3306/soen387";
    private static final String USER = "root";
    private static final String PASSWORD = "dDf32lsa";

    private static void createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance = connection;
    }

    private static Connection getConnection() {
        if (instance == null) {
            createConnection();
        }
        return instance;
    }

    public static ResultSet executeQuery(String sql) {
        try {
            Statement statement = getConnection().createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int executeUpdate(String sql) {
        try {
            Statement statement = getConnection().createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}