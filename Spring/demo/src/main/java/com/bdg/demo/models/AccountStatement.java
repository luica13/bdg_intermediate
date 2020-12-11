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

    public String getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public StatementCreator getStatementCreator() {
        return statementCreator;
    }

    public void setStatementCreator(StatementCreator statementCreator) {
        this.statementCreator = statementCreator;
    }

    public void create(){
        statementCreator.create();
    }

}
