package model.with_object_factory;

import model.PrototypeBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SingletonObjectFactoryBean {
    @Autowired
    private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;

    public PrototypeBean getPrototypeBean() {
        return prototypeBeanObjectFactory.getObject();
    }
}
