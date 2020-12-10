package com.company;

import java.sql.*;

public class AmbulanceDB {

    public static Connection connectDB(){

        String url = "jdbc:mysql://localhost:3306/Ambulance";
        String userName = "root";
        String password = "root";
        String sqlSelect = "SELECT * FROM company";
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             //language=SQL
             PreparedStatement statement = connection.prepareStatement(sqlSelect);
             ResultSet resultSet = statement.getResultSet();
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cannot connected!");
        }
        return null;
    }
}