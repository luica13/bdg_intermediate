package com.bdg.demo.models;

public class ElectronicStatementCreator implements StatementCreator {
    @Override
    public void create() {
        System.out.println("Electronic statement created");

    }
}
