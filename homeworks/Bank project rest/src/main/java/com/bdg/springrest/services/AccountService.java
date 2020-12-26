package com.bdg.springrest.services;

import com.bdg.springrest.form.AccountForm;

public interface AccountService {
    void createAccount(AccountForm accountForm);
    void deposit(int amount);
    void withdrawal(int amount);
    void getTransaction();
}
