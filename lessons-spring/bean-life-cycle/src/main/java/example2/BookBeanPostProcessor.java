package example2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BookBeanPostProcessor implements BeanPostProcessor {

    //fourth step
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process Before Initialization method is called : Bean Name " + beanName);
        return bean;
    }

    //sixth step
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process After Initialization method is called : Bean Name " + beanName);
        return bean;
    }
}
