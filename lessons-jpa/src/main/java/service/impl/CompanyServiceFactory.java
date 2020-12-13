package service.impl;

import dao.impl.CompanyDAOImpl;
import service.CompanyService;
import service.ServiceFactory;

import javax.persistence.EntityManager;

public class CompanyServiceFactory implements ServiceFactory<CompanyService> {
    @Override
    public CompanyService getInstance(EntityManager em) {
        return new CompanyServiceImpl(new CompanyDAOImpl(em));
    }
}
