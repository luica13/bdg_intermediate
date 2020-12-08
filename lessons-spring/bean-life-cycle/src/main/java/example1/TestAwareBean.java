package example1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAwareBean {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AwareBean awareBean = (AwareBean) ctx.getBean("awareBean");
        ctx.registerShutdownHook();
    }
}
