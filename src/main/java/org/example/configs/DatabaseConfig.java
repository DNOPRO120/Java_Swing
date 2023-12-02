package org.example.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static Connection conn;
    public static Connection getConnection(){
        DatabaseConfig.conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            DatabaseConfig.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_management",
                    "root",
                    "");
        }catch (SQLException ex){
            ex.getSuppressed();
        }
        return DatabaseConfig.conn;
    }
    public static void closeConnection(){
        try {
            if(DatabaseConfig.conn != null) DatabaseConfig.conn.close();
        } catch (SQLException ex){
            ex.getSuppressed();
        }
    }
}
