import config.AppConfig;
import model.PrototypeBean;
import model.with_object_factory.SingletonObjectFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.util.Assert.isTrue;

public class ObjectFactorySolution {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonObjectFactoryBean firstSingleton = ctx.getBean(SingletonObjectFactoryBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
        SingletonObjectFactoryBean secondSingleton = ctx.getBean(SingletonObjectFactoryBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
        isTrue(!firstPrototype.equals(secondPrototype), "The same instance should be returned");
    }
}
