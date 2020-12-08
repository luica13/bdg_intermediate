package example1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomMethodLifeCycleBean {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        CustomLifeCycleMethodBean customLifeCycleMethodBean = ctx.getBean("customLifeCycleMethodBean", CustomLifeCycleMethodBean.class);
        ctx.registerShutdownHook();
    }
}
