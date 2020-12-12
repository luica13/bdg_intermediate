package am.bdg.intermediate_group_2_W_S.airport_management.service;

import javax.persistence.EntityManager;

public interface ServiceFactory<T> {
    T getInstance(EntityManager em);
}
