package ua.fedii.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/cars";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl);

            System.out.println("Connection successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


