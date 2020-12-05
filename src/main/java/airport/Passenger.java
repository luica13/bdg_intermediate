package airport;

import java.sql.*;

public class Passenger extends JDBCconfig{
    String name;
    String phone;
    String country;
    String city;
    String SELECT_ALL_QUERY = "select * from passengers";
    String UPDATE_USERS_SQL = "update passengers set country = ? where id = ?;";
    String DELETE_USERS_SQL = "delete from passenegers where id = ?;";


    int getById(long id) throws SQLException {
        return rs.getInt(String.valueOf(id));
    }

  void getAll(){
      try (Connection connection = DriverManager.getConnection(url, userName, password);

           PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
           System.out.println(preparedStatement);
           ResultSet rs = preparedStatement.executeQuery();

          while (rs.next()) {
              int id = rs.getInt("id");
              name = rs.getString("name");
              phone = rs.getString("phone");
              country = rs.getString("country");
              city = rs.getString("city");
          }
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
  }

    void update(){
        try (Connection connection = DriverManager.getConnection(url, userName, password);

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
             preparedStatement.setString(1, "Yerevan");
             preparedStatement.setInt(2, 2);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void delete(long passengerId){
        try (Connection connection = DriverManager.getConnection(url, userName, password);

             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
             preparedStatement.setInt(1, 1);

            int result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*List<Passenger> getPassengersOfTrip(long tripNumber){

    }*/

    /*void registerTrip(Trip trip, Passenger passenger){

    }
    void cancelTrip(long passengerId, long tripNumber){

    }*/


}
