package com.bdg.demo.models;

import lombok.*;

@Getter
@Setter
public class AccountStatement {

    private String accountNumber;
    private StatementCreator statementCreator;

    public AccountStatement() {
        statementCreator = new ElectronicStatementCreator();
    }

    public AccountStatement(StatementCreator statementCreator) {
        this.statementCreator = statementCreator;
    }

    public void create(){
        statementCreator.create();
    }

}
