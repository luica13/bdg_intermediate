package example1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonBean {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonBean bean = (PersonBean) context.getBean("personBean");
        System.out.println(bean.getName());
        context.registerShutdownHook();
    }
}
