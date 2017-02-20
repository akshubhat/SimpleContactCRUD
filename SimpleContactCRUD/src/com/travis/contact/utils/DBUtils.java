package com.travis.contact.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtils {
    private static final Logger LOGGER = Logger.getLogger(DBUtils.class.getName());
    
    public static Connection getConnection(Connection connection) {
        
        if(connection == null) {
            InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            
            try {
                properties.load(inputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                LOGGER.log(Level.INFO, "Connection Established.");
            } catch (IOException | ClassNotFoundException | SQLException err) {
                LOGGER.log(Level.FINER, err.toString());
            }
        }
               	
        return connection;
    }
    
    public static void close(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
                LOGGER.log(Level.INFO, "Connection Closed.");
            } catch (SQLException err) {
            	LOGGER.log(Level.FINER, err.toString());
            }
        }
    }
    
    public static void close(Statement statement) {
        if(statement != null) {
            try {
                statement.close();
                LOGGER.log(Level.INFO, "Statement Close.");
            } catch (SQLException err) {
            	LOGGER.log(Level.FINER, err.toString());
            }
        }
    }
    
    public static void close(ResultSet result) {
        if(result != null) {
            try {
                result.close();
                LOGGER.log(Level.INFO, "ResultSet Close.");
            } catch (SQLException err) {
            	LOGGER.log(Level.FINER, err.toString());
            }
        }
    }
}