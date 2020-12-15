package example2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BookBeanPostProcessor implements BeanPostProcessor, BeanFactoryPostProcessor {

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


    //first before beanAware setBeanName
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("Post Process Bean  Factory method " + configurableListableBeanFactory.toString());
    }
}
