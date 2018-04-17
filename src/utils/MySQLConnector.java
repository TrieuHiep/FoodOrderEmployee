package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnector {
    private static MySQLConnector ourInstance = new MySQLConnector();

    private Connection connection;

    public static MySQLConnector getInstance() {
        return ourInstance;
    }

    public Connection getMySQLConnection() {
        return connection;
    }

    private MySQLConnector() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(new File("config.properties")));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
