package com.bdg.demo.models;

public class PaperStatementCreator implements StatementCreator {
    @Override
    public void create() {
        System.out.println("Paper statement created");
    }
}
