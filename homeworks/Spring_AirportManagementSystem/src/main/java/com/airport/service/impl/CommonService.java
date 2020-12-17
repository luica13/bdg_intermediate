package com.airport.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Service
public class CommonService <T>{
    private JpaRepository<T> repository ;
//    public static <T> T getById(Session session, Class<T> tClass, long id)
//    {
//        T passenger = session.get(tClass,id);
//
//        return passenger;
//    }
    public <T> T getById(Class<T> tClass, long id)
    {

        T t = repository.getOne(id);//repo.find(tClass,id);
        ///em.close();
        return t;
    }

    public static <T> T getById(EntityManager em,Class<T> tClass, long id)
    {
        return em.find(tClass,id);
    }

    public static <T> Set<T> getAll(Class<T> tClass, String tableName)
    {
//        EntityManager em =HibernateUtil.getEntityManager();
//        Set<T> passengers = new HashSet<>(em.createQuery("select a from " +tableName+ " a", tClass).getResultList());
//        em.close();
//        return passengers;
        return  null;
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
