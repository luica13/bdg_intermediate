package config;

import model.with_functional.PrototypeBean;
import model.with_functional.SingletonFunctionBean;
import model.with_object_factory.SingletonObjectFactoryBean;
import model.with_provider.SingletonProviderBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.function.Function;

@Configuration
@ComponentScan(resourcePattern = "../**")
public class AppConfig {

    @Bean
    public SingletonProviderBean singletonProviderBean() {
        return new SingletonProviderBean();
    }

    @Bean
    public SingletonObjectFactoryBean singletonObjectFactoryBean() {
        return new SingletonObjectFactoryBean();
    }

    @Bean
    public Function<String, PrototypeBean> beanFactory() {
        return name -> prototypeBeanWithParam(name);
    }

    @Bean
    @Scope(value = "prototype")
    public PrototypeBean prototypeBeanWithParam(String name) {
        return new PrototypeBean(name);
    }

    @Bean
    public SingletonFunctionBean singletonFunctionBean() {
        return new SingletonFunctionBean();
    }
}
