import config.AppConfig;
import model.PrototypeBean;
import model.with_bad_solution.SingletonAppContextBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.util.Assert.isTrue;


public class BadSolution {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonAppContextBean firstSingleton = ctx.getBean(SingletonAppContextBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
        SingletonAppContextBean secondSingleton = ctx.getBean(SingletonAppContextBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
        isTrue(!firstPrototype.equals(secondPrototype));
    }
}
