package model.with_functional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class SingletonFunctionBean {

    @Autowired
    private Function<String, PrototypeBean> beanFactory;

    public PrototypeBean getPrototypeBean(String name) {
        PrototypeBean bean = beanFactory.apply(name);
        return bean;
    }
}
