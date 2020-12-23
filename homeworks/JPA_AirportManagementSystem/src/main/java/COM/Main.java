package COM;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    private static final String folderURL =  "D:\\for Projects\\Java\\resouses\\homework(JDBC)";

    public static void main(String[] args) {

        ArrayList<String[]>  companiesArrayList = arrayFromFile("companies.txt");
        ArrayList<String[]>  addressPassengerArrayList = arrayFromFile("passengers.txt");

        if (companiesArrayList!=null) {
            System.out.println("filling companies");
            fillCompanies(companiesArrayList);
        }
        if (addressPassengerArrayList!=null) {
            System.out.println("filling address and passengers");
            fillAddressPassenger(addressPassengerArrayList);
        }
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Connection_JPA");
//        EntityManager em = emf.createEntityManager();

        //HibernateUtil.getInstance();

//        EntityManager entityManager = HibernateUtil.getEntityManager();
//        entityManager.getTransaction().begin();
//        //transaction.begin();
//        Address address = new Address("Armenia","Ijevan");
//
//        Passenger passenger = new Passenger("Valod","021469845",address);
//        //Passenger.
//        entityManager.persist(address);
//        entityManager.persist(passenger);
//        entityManager.getTransaction().commit();
//        entityManager.close();

    }

    private static void fillAddressPassenger(ArrayList<String[]> addressPassengerArrayList) {
    }

    private static void fillCompanies(ArrayList<String[]> companiesArrayList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        for (String[] companyArray: companiesArrayList) {
            Company company = new Company(companyArray[0], LocalDate.parse(companyArray[1],formatter));
            company.save();
        }
    }

    public static ArrayList<String[]>  arrayFromFile(String fileName) {
        // = "";
        FileReader input = null;
        ArrayList<String[]> retArrayList = null;
        try {
            input = new FileReader(folderURL+"\\"+fileName);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = null;

            if(bufRead.readLine()==null)
                return retArrayList;

            retArrayList = new ArrayList<>();
            while ( (myLine = bufRead.readLine()) != null)
            {
                String[] array1 = myLine.split(",");
                retArrayList.add(array1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't read from file");
            e.printStackTrace();
        }

        return retArrayList;
    }

}
