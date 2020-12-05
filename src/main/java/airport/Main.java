package airport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        JDBCconfig config = new JDBCconfig();
        Company company = new Company();
        Passenger passenger = new Passenger();
        Trip trip = new Trip();
        String line1 = null;
        String line2 = null;

        try {
            config.con = DriverManager.getConnection(config.url, config.userName, config.password);
            BufferedReader br_companies = new BufferedReader(new FileReader("src/main/java/airport/companies.txt"));
            BufferedReader br_passengers = new BufferedReader(new FileReader("src/main/java/airport/passengers.txt"));
            while ((line1 = br_companies.readLine()) != null)
            {
                String[] tmp = line1.split(",");
                company.name = tmp[0];
                company.found_date = tmp[1];

                System.out.println(company.name+ "\t" + company.found_date + "\t");
                String sqlInsert =
                        "INSERT INTO companies (name,found_date) values ('"
                                + company.name + "','" + company.found_date + "')";

                config.ps = config.con.prepareStatement(sqlInsert);
                config.ps.executeUpdate();

                company.getById(2);
                company.getAll();
                company.update();
                company.delete(3);
            }
            while ((line2 = br_passengers.readLine()) != null)
            {
                String[] tmp2 = line2.split(",");
                passenger.name = tmp2[0];
                passenger.phone = tmp2[1];
                passenger.country = tmp2[2];
                passenger.city = tmp2[3];

                String sqlInsert2;
                sqlInsert2 = "INSERT INTO passengers (name,phone,country,city) values  ('"
                        + passenger.name + "','" + passenger.phone + "','" + passenger.country + "','" + passenger.city +
                        "')";

                config.ps = config.con.prepareStatement(sqlInsert2);
                config.ps.executeUpdate();


                String sqlInsert3;
                sqlInsert3 = "INSERT INTO trip (name,phone,country,city) values  ('"
                        + passenger.name + "','" + passenger.phone + "','" + passenger.country + "','" + passenger.city +
                        "')";

                passenger.getAll();
                passenger.update();
                passenger.delete(3);
            }

            br_companies.close();
            br_passengers.close();
            config.con.close();
            config.ps.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
