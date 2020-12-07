package airportJPA;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_comp;

    public Company(int id_comp, String name, String found_date) {
        this.id_comp = id_comp;
        this.name = name;
        this.found_date = found_date;
    }

    public Company() {
    }

    @Column
    private String name;

    @Column
    private String found_date;


    public int getId() {
        return id_comp;
    }
    public void setId(int id) {
        this.id_comp = id;
    }

    public String getFound_date() {
        return found_date;
    }

    public void setFound_date(String found_date) {
        this.found_date = found_date;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void toDatabase() throws IOException {
        String line1 = null;
        BufferedReader br_companies =
                new BufferedReader(new FileReader("src/main/java/airportJPA/companies.txt"));
        while ((line1 = br_companies.readLine()) != null) {
            String[] tmp = line1.split(",");
            name = tmp[0];
            found_date = tmp[1];

            System.out.println(name + "\t" + found_date + "\t");
            String sqlInsert =
                    "INSERT INTO companies (name,found_date) values ('"
                            + name + "','" + found_date + "')";
        }
    }

}
