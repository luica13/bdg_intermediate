package com.bdg.demo.models;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("application-context.xml");

        AccountStatement accountStatement;
        accountStatement = classPathXmlApplicationContext.getBean("accountStatement", AccountStatement.class);
        accountStatement.create();
        LinkedList
//        accountStatement = classPathXmlApplicationContext.getBean("accountStatement1", AccountStatement.class);
//        accountStatement.create();
    }
}
