package airportJPA;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Entity
@Table(name = "passengers")
public class Passenger {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String name;

    @Column
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column
    private String country;

    public Passenger(String id, String name, String phone, String country, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.city = city;
    }

    public Passenger() {
    }

    @Column
    private  String city;


    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public void toDatabase() throws IOException {
        String line1 = null;
        BufferedReader br_companies =
                new BufferedReader(new FileReader("src/main/java/airportJPA/passengers.txt"));
        while ((line1 = br_companies.readLine()) != null) {
            String[] tmp = line1.split(",");
            name = tmp[0];
            phone = tmp[1];
            country = tmp[2];
            city = tmp[3];

            String sqlInsert2 = "INSERT INTO passengers (name,phone,country,city) values  ('"
                    + name + "','" + phone + "','" + country + "','" + city +
                    "')";
        }
    }
}
