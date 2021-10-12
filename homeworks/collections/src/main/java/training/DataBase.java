package training;

import java.sql.*;

public class DataBase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String userName = "root";
        String password = null;
        String sqlSelect = "SELECT * FROM CHARACTER_SETS";
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             //language=SQL
             PreparedStatement statement = connection.prepareStatement(sqlSelect);
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("MAXLEN"));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cannot connected!");
        }
    }
}
