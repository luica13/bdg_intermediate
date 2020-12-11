import config.AppConfig;
import model.PrototypeBean;
import model.with_problem.SingletonBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.util.Assert.isTrue;

public class ProblemShower {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonBean firstSingleton = ctx.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
        SingletonBean secondSingleton = ctx.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
        isTrue(firstPrototype.equals(secondPrototype), "The same instance should be returned");
    }
}
