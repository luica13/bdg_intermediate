package airportJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PassengerJPA {
    private static CompanyJPA instance;
    protected EntityManager entityManager;

    public static CompanyJPA getInstance(){
        if (instance == null){
            instance = new CompanyJPA();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceAirport");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    PassengerJPA() {
        entityManager = getEntityManager();
    }

    public Passenger getById(final int id) {
        return entityManager.find(Passenger.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Company> getAll() {
        return entityManager.createQuery("FROM " + Passenger.class.getName()).getResultList();
    }

    public void persist(Passenger passenger) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(passenger);
            entityManager.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Passenger passenger) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(passenger);
            entityManager.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Passenger passenger){
        passenger = (Passenger) entityManager.createQuery("FROM " + Passenger.class.getName());
    }

    public void remove(Passenger passenger) {
        try {
            entityManager.getTransaction().begin();
            passenger = entityManager.find(Passenger.class, passenger.getId());
            entityManager.remove(passenger);
            entityManager.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
