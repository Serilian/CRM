package pl.filiphagno.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "springstudent";
        String pass = "springstudent";
        try {
            System.out.println("Connecting to DB " + url);
            Connection myConn = DriverManager.getConnection(url, user,pass);
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println("Connecting to DB failed");
            e.printStackTrace();
        }
    }
}
