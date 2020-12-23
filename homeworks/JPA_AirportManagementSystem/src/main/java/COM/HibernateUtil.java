package COM;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {


    private static final String persistenceUnitName = "Connection_JPA";
    private static HibernateUtil instance = null;

    private static EntityManagerFactory entityManagerFactory;

    private HibernateUtil(){
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public static HibernateUtil getInstance(){
        if(instance == null){
            instance  = new HibernateUtil();
        }
        return instance;
    }

    public static EntityManager getEntityManager() {
        getInstance();
        return entityManagerFactory.createEntityManager();
    }

}