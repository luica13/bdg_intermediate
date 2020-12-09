import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataCreation {
    private final String url = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "Armgrig777";

    public void createCompany() {
        String sql = "CREATE TABLE Company(" +
                "id INT," +
                "name VARCHAR(30)," +
                "founding_date DATE," +
                "trip_id INT," +
                "PRIMARY KEY (id))";
        try  {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
    }

    public void createTrip() {
        String sql = "CREATE TABLE Trip(" +
                "id INT," +
                "timeIn Time," +
                "timeOut Time," +
                "toTown VARCHAR(30)," +
                "fromTown VARCHAR(30)," +
                "companyId INT," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (companyId) REFERENCES Company(id))";
        try  {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
    }

    public void createAddress() {
        String sql = "CREATE TABLE Address(" +
                "id INT," +
                "country VARCHAR(30)," +
                "city VARCHAR(30)," +
                "PRIMARY KEY (id))";
        try  {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void createPassenger() {
        String sql = "CREATE TABLE Passengers(" +
                "id INT," +
                "name VARCHAR(30)," +
                "phone VARCHAR(30)," +
                "addressId INT," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (addressId) REFERENCES Address(id))";
        try  {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
    }

    public void createPassenger_Trip() {
        String sql = "CREATE TABLE Passenger_Trip(" +
                "id INT," +
                "passenger_id INT," +
                "trip_id INT," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (passenger_id) REFERENCES Passengers(id)," +
                "FOREIGN KEY (trip_id) REFERENCES Trip(id))";
        try  {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
    }


    public void insertDataIntoCompany() {
        String sql = "INSERT INTO Company(name, founding_date) VALUES(?,?)";
        try  {
            BufferedReader companiesReader = new BufferedReader(new FileReader("C:\\Users\\Arman\\OneDrive\\Desktop\\companies.txt"));
            Connection conn = DriverManager.getConnection(url, "root", "Armgrig777");
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            String s;
            while ((s = companiesReader.readLine()) != null) {
                String[] nameDate = s.split(",");
                stmt.setString(1, nameDate[0]);

                Date date = (Date) new SimpleDateFormat("MM/dd/yyyy").parse(nameDate[1]);
                stmt.setDate(2, new java.sql.Date(date.getTime()));
                stmt.executeUpdate();
            }
        } catch (SQLException | IOException | ParseException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DataCreation creator = new DataCreation();
        creator.createCompany();
        creator.insertDataIntoCompany();
    }
}