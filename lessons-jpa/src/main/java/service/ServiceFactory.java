package service;

import javax.persistence.EntityManager;

public interface ServiceFactory<T> {
    T getInstance(EntityManager em);
}
