package service.impl;

import dao.impl.TripDAOImpl;
import service.ServiceFactory;
import service.TripService;

import javax.persistence.EntityManager;

public class TripServiceFactory implements ServiceFactory<TripService> {
    @Override
    public TripService getInstance(EntityManager em) {
        return new TripServiceImpl(new TripDAOImpl(em));
    }
}
