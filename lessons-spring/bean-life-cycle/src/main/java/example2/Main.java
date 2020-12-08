package example2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans2.xml");
        AwareBeanImpl awareBeanImpl = (AwareBeanImpl) ctx.getBean("awareBean");
        ctx.registerShutdownHook();
    }
}
