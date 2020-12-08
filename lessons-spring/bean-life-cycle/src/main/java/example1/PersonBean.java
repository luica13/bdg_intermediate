package example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PersonBean implements InitializingBean, DisposableBean {

    private String name;

    public PersonBean() {
        System.out.println("Constructor of person bean is called !! ");
    }

    public void destroy() throws Exception {
        System.out.println("destroy method of person bean is called !! ");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method of person bean is called !! ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
