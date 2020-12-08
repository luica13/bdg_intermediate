package example1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomGlobalMethodLifeCycleBean {
    public static void main(String[] args) {

        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        CustomGlobalLifeCycleMethodBean bean = (CustomGlobalLifeCycleMethodBean) context.getBean("customGlobalLifeCycleMethodBean");
        context.registerShutdownHook();
    }
}
