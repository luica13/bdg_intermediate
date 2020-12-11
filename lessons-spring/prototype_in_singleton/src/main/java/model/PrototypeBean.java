package model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    private static final Logger LOG = LoggerFactory.getLogger(PrototypeBean.class);


    public PrototypeBean() {
        LOG.info("Prototype instance created");
    }
}
