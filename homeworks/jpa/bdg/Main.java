package com.bdg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger passenger = em.find(Passenger.class, 4L);
        System.out.println(passenger);

        em.getTransaction().commit();
    }
}
