package com.bdg.demo.models;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        AccountStatement accountStatement;
        accountStatement = classPathXmlApplicationContext
                .getBean("accountStatement", AccountStatement.class);
        accountStatement.create();
        accountStatement = classPathXmlApplicationContext
                .getBean("accountStatement1", AccountStatement.class);
        accountStatement.create();
    }
}
