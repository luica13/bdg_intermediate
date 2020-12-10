package COM;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Common {
    public static <T> T getById(Session session, Class<T> tClass, long id)
    {
        T passenger = session.get(tClass,id);

        return passenger;
    }
    public static <T> T getById(EntityManager entityManager, Class<T> tClass, long id)
    {
        T passenger = entityManager.find(tClass,id);
        return passenger;
    }

    public static <T> Set<T> getAll(EntityManager entityManager, Class<T> tClass, String tableName)
    {
        Set<T> passengers = new HashSet(entityManager.createQuery("select a from " +tableName+ " a", tClass).getResultList());
        return passengers;
    }

}
