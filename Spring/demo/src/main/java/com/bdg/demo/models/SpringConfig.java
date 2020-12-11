package com.bdg.demo.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.bdg.demo.models")
@PropertySource("classpath:accountStatement.properties")
public class SpringConfig {

    @Bean
    public ElectronicStatementCreator electronicStatementCreator(){
        return new ElectronicStatementCreator();
    }

    @Bean
    public PaperStatementCreator paperStatementCreator(){
        return new PaperStatementCreator();
    }

    @Bean
    public StatementCreator paperAccountStatement(){
        return new PaperStatementCreator();
    }

    @Bean
    public StatementCreator electronicAccountStatement(){
        return new ElectronicStatementCreator();
    }
}
