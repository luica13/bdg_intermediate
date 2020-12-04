package com.bdg.servlets;

import com.bdg.models.Schedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet("/schedule")
public class ScheduleServlet extends HttpServlet {
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

    //language=SQL
    private final String SQL_SELECT_ALL_FROM_SCHEDULE = "SELECT * From schedule";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/schedule.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Schedule> schedules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_SCHEDULE);
            while (resultSet.next()) {
                String companyName = resultSet.getString("company_name");
                String plane = resultSet.getString("plane");
                String townTo = resultSet.getString("town_to");
                Time flightTime = resultSet.getTime("flightTime");
                schedules.add(new Schedule(companyName, plane, townTo, flightTime.toLocalTime()));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        req.setAttribute("scheduleListFromServer", schedules);
        req.getServletContext().getRequestDispatcher("/jsp/schedule.jsp").forward(req, resp);

    }
}
