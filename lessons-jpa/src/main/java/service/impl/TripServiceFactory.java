package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import dao.impl.TripDAOImpl;
import am.bdg.intermediate_group_2_W_S.airport_management.service.ServiceFactory;
import am.bdg.intermediate_group_2_W_S.airport_management.service.TripService;

import javax.persistence.EntityManager;

public class TripServiceFactory implements ServiceFactory<TripService> {
    @Override
    public TripService getInstance(EntityManager em) {
        return new TripServiceImpl(new TripDAOImpl(em));
    }
}
