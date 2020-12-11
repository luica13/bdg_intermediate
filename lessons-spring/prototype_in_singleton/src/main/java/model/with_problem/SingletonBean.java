package model.with_problem;

import model.PrototypeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SingletonBean {

    private static final Logger LOG = LoggerFactory.getLogger(SingletonBean.class);

    @Autowired
    private PrototypeBean prototypeBean;

    public SingletonBean() {
        LOG.info("Singleton instance created");
    }

    public PrototypeBean getPrototypeBean() {
        LOG.info(String.valueOf(LocalTime.now()));
        return prototypeBean;
    }
}
