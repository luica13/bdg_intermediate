package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import dao.impl.PassengerDAOImpl;
import am.bdg.intermediate_group_2_W_S.airport_management.service.PassengerService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.ServiceFactory;

import javax.persistence.EntityManager;

public class PassengerServiceFactory implements ServiceFactory<PassengerService> {
    @Override
    public PassengerService getInstance(EntityManager em) {
        return new PassengerServiceImpl(new PassengerDAOImpl(em));
    }
}
