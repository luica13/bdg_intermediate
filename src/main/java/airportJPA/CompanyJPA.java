package airportJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CompanyJPA {
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

    CompanyJPA() {
        entityManager = getEntityManager();
    }

    public Company getById(final int id) {
        return entityManager.find(Company.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Company> getAll() {
        return entityManager.createQuery("FROM " + Company.class.getName()).getResultList();
    }

    public void persist(Company company) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(company);
            entityManager.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Company company) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(company);
            entityManager.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Company company){
        company = (Company) entityManager.createQuery("FROM " + Company.class.getName());
    }

    public void remove(Company company) {
        try {
            entityManager.getTransaction().begin();
            company = entityManager.find(Company.class, company.getId());
            entityManager.remove(company);
            entityManager.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Company company = getById(id);
            remove(company);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}








