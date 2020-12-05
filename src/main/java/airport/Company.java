package airport;

import java.sql.*;

public class Company extends JDBCconfig {
    String name;
    String found_date;
    String QUERY = "select id,name,found_date from companies where id =?";
    String SELECT_ALL_QUERY = "select * from companies";
    String UPDATE_USERS_SQL = "update companies set name = ? where id = ?;";
    String DELETE_USERS_SQL = "delete from users where id = ?;";


    void getById(long id) throws SQLException {

        try (Connection connection = DriverManager.getConnection(url, userName, password);
             // create statement
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 1);
            //exequte
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_company = rs.getInt("id");
                name = rs.getString("name");
                found_date = rs.getString("found_date");
            }
        }

    }

    void getAll() throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, userName, password);

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
             System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                name = rs.getString("name");
                found_date = rs.getString("found_date");
            }
        }
    }
    void update(){
        try (Connection connection = DriverManager.getConnection(url, userName, password);

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
             preparedStatement.setString(1, "Mesrop");
             preparedStatement.setInt(2, 1);

             preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void delete(long companyId){
        try (Connection connection = DriverManager.getConnection(url, userName, password);

             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
             preparedStatement.setInt(1, 1);

             int result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
