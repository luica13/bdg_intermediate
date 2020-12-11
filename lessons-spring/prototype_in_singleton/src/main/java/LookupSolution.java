import config.AppConfig;
import model.PrototypeBean;
import model.with_lookup.SingletonLookupBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.util.Assert.isTrue;

public class LookupSolution {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonLookupBean firstSingleton = ctx.getBean(SingletonLookupBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
        SingletonLookupBean secondSingleton = ctx.getBean(SingletonLookupBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
        isTrue(firstPrototype.equals(secondPrototype), "The same instance should be returned");
    }
}
