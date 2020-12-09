import java.sql.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PassengerImpl implements PassengerInterface {
    private final String url = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "Armgrig777";
    private ResultSet result;

    @Override
    public Passenger getById(long id) throws SQLException,NullPointerException {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Passengers "
                    + " WHERE id = " + id + " ";

            if(result.next() && result==null){
                result = stmt.executeQuery(sql);
            }
        }
        catch(SQLException e) {
            System.out.println("Exception is thrown");
        }

        return new Passenger(result.getString("name"),
                result.getString("phone"),
                new Address(result.getString("country"), result.getString("city")));
    }

    @Override
    public Set<Passenger> getAll() {
        Set<Passenger> passengers = new HashSet<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Passengers";

            result = stmt.executeQuery(sql);

            while (result.next()) {
                passengers.add(new Passenger(result.getString("name"),
                        result.getString("phone"),
                        new Address(result.getString("country"), result.getString("city"))));
            }
        }
        catch(SQLException e) {
            System.out.println("Exception is thrown");
        }


        return passengers;
    }

    @Override
    public Passenger save(Passenger passenger) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Passengers "
                    + "VALUES("+passenger.getName()+", "+passenger.getPhone()+", "+passenger.getAddress().getCity()+", "+passenger.getAddress().getCountry()+")";

            stmt.executeUpdate(sql);
        }
        catch(SQLException e) {
            System.out.println("Exception is thrown");
        }

        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public void delete(long passengerId) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Passenger" +
                    "WHERE id = "+passengerId+"";

            stmt.executeUpdate(sql);
        }
        catch(SQLException e) {
            System.out.println("Exception is thrown");
        }
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}