package service.impl;

import dao.impl.PassengerDAOImpl;
import service.PassengerService;
import service.ServiceFactory;

import javax.persistence.EntityManager;

public class PassengerServiceFactory implements ServiceFactory<PassengerService> {
    @Override
    public PassengerService getInstance(EntityManager em) {
        return new PassengerServiceImpl(new PassengerDAOImpl(em));
    }
}
