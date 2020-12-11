package model.with_functional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrototypeBean {
    private String name;
    private static final Logger LOG = LoggerFactory.getLogger(model.PrototypeBean.class);


    public PrototypeBean(String name) {
        this.name = name;
        LOG.info("Prototype instance " + name + " created");
    }
}
