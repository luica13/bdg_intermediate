package com.bdg.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/jsp/addEmployee.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String birthDate = request.getParameter("birthDate");
        String townFrom = request.getParameter("town-from");

        //using Statement for query
        /*try {
            Statement statement = connection.createStatement();
            //language=SQL
            String sqlInsert = "INSERT INTO employee(firstName, lastName, birthDate, townFrom)" +
                    " VALUES('" + firstName + "','" + lastName + "','" + birthDate + "', '" + townFrom + "')";
            statement.execute(sqlInsert);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }*/

        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO employee(firstName, lastName, birthDate, townFrom) " +
                            "VALUES(?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, birthDate);
            statement.setString(4, townFrom);
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        //request.getServletContext().getRequestDispatcher("/jsp/schedule.jsp").forward(request, response);
        response.sendRedirect("/schedule");
    }
}
