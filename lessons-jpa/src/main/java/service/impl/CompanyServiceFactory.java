package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import dao.impl.CompanyDAOImpl;
import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.ServiceFactory;

import javax.persistence.EntityManager;

public class CompanyServiceFactory implements ServiceFactory<CompanyService> {
    @Override
    public CompanyService getInstance(EntityManager em) {
        return new CompanyServiceImpl(new CompanyDAOImpl(em));
    }
}
