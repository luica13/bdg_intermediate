package com.bdg.demo.models;

public class Main {
    public static void main(String[] args) {

        ElectronicStatementCreator electronicStatementCreator = new ElectronicStatementCreator();

        AccountStatement accountStatement = new AccountStatement();

        accountStatement.setStatementCreator(electronicStatementCreator);
        accountStatement.create();
        electronicStatementCreator = null;






        PaperStatementCreator paperStatementCreator = new PaperStatementCreator();
        accountStatement.setStatementCreator(paperStatementCreator);
        accountStatement.create();
    }
}
