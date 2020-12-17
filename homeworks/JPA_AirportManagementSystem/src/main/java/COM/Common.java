package COM;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class Common {
//    public static <T> T getById(Session session, Class<T> tClass, long id)
//    {
//        T passenger = session.get(tClass,id);
//
//        return passenger;
//    }
    public static <T> T getById(Class<T> tClass, long id)
    {
        EntityManager em =HibernateUtil.getEntityManager();
        T passenger = em.find(tClass,id);
        em.close();
        return passenger;
    }

    public static <T> T getById(EntityManager em,Class<T> tClass, long id)
    {
        return em.find(tClass,id);
    }

    public static <T> Set<T> getAll(Class<T> tClass, String tableName)
    {
        EntityManager em =HibernateUtil.getEntityManager();
        Set<T> passengers = new HashSet<>(em.createQuery("select a from " +tableName+ " a", tClass).getResultList());
        em.close();
        return passengers;
    }

    public static <T>T save( T value)
    {
        //T tValue = value.
        EntityManager em =HibernateUtil.getEntityManager();
        em.persist(value);
        em.refresh(value);
        em.flush();
        //T tValue = (T) em.getReference(value.getClass(),value);
        em.close();
        return value;

    }

    public static <T>T update(T value)
    {
        EntityManager em =HibernateUtil.getEntityManager();
        T tValue = em.merge(value);
        em.close();
        return tValue;
    }

    public static <T> void delete(Class<T> tClass, long passengerId)
    {
       EntityManager em =HibernateUtil.getEntityManager();
       T t = getById(em, tClass,passengerId);
       if(t!=null)
            em.remove(t);
       em.close();
    }


}
