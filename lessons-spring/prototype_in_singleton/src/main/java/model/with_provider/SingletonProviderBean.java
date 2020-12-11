package model.with_provider;

import model.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Provider;

public class SingletonProviderBean {

    @Autowired
    private Provider<PrototypeBean> prototypeBeanProvider;

    public PrototypeBean getPrototypeBean() {
        return prototypeBeanProvider.get();
    }
}
