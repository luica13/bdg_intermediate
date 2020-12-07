package airportJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Passenger passenger = new Passenger();
        CompanyJPA companyJPA = new CompanyJPA();
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("persistenceAirport");
        EntityManager em = ef.createEntityManager();
        em.getTransaction().begin();


        try {
            company.toDatabase();
            em.persist(company);
            passenger.toDatabase();
            em.persist(passenger);

        } catch (IOException e) {
            e.printStackTrace();
        }
        em.getTransaction().commit();

        em.close();
        ef.close();
    }
}
