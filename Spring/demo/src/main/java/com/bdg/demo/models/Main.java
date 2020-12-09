package com.bdg.demo.models;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        ElectronicStatementCreator electronicStatementCreator = new ElectronicStatementCreator();
//
//        AccountStatement accountStatement = new AccountStatement();
//
//        accountStatement.setStatementCreator(electronicStatementCreator);
//        accountStatement.create();
//        electronicStatementCreator = null;
//
//        PaperStatementCreator paperStatementCreator = new PaperStatementCreator();
//        accountStatement.setStatementCreator(paperStatementCreator);
//        accountStatement.create();


        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("application-context.xml");

        AccountStatement accountStatement;
        accountStatement = classPathXmlApplicationContext
                .getBean("accountStatement", AccountStatement.class);
        accountStatement.create();
        accountStatement = classPathXmlApplicationContext
                .getBean("accountStatement1", AccountStatement.class);
        accountStatement.create();
    }
}
