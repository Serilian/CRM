package pl.filiphagno.jdbc;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/testDb")
@Slf4j
public class TestDBServlet extends HttpServlet {
    public static final long serialVersionUID = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "springstudent";
        String pass = "springstudent";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter out = resp.getWriter();
            out.println("Connecting to db " + url);
//            log.info("Connecting");

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(url, user,pass);

            out.println("Connection successful");

            myConn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
