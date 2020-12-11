import config.AppConfig;
import model.PrototypeBean;
import model.with_lookup.SingletonLookupBean;
import model.with_provider.SingletonProviderBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.util.Assert.isTrue;

public class ProviderSolution {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonProviderBean firstSingleton = ctx.getBean(SingletonProviderBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
        SingletonProviderBean secondSingleton = ctx.getBean(SingletonProviderBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
        isTrue(firstPrototype.equals(secondPrototype), "The same instance should be returned");
    }
}
