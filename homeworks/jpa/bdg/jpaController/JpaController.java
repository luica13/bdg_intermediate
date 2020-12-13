package com.bdg.jpaController;

import com.bdg.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Set;

public class JpaController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPersistenceUnit");
    EntityManager entityManager = emf.createEntityManager();

    public void save(Company company) {
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(id);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Company getById(Integer id)  {
        return entityManager.find(Company.class, id);
    }

    Set<Company> getAll() {
        entityManager.getTransaction().begin();
        CriteriaQuery<Object> criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(Company.class));
        Query query = entityManager.createQuery(criteriaQuery);
        return (Set<Company>) query.getResultList();
    }
}
