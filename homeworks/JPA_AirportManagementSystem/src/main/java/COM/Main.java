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
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Connection_JPA");
//        EntityManager em = emf.createEntityManager();

        //HibernateUtil.getInstance();

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        //transaction.begin();
        Address address = new Address("Armenia","Ijevan");
        Passenger passenger = new Passenger("Valod","021469845",address);
        entityManager.persist(address);
        entityManager.persist(passenger);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
