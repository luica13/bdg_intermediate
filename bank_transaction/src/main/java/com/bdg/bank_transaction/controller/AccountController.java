package com.bdg.bank_transaction.controller;


import java.util.List;

import javax.validation.Valid;


import com.bdg.bank_transaction.exception.ResourceNotFoundException;
import com.bdg.bank_transaction.model.Account;
import com.bdg.bank_transaction.operations.DepositUseCase;
import com.bdg.bank_transaction.operations.WithdrawUseCase;
import com.bdg.bank_transaction.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(produces = {"application/json"})
public class AccountController {

	private DepositUseCase depositUseCase;
	private WithdrawUseCase withdrawUseCase;

	@Autowired
	private AccountRepository accountRepository;

	public AccountController(DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase) {
		this.depositUseCase = depositUseCase;
		this.withdrawUseCase = withdrawUseCase;
	}

	@GetMapping("api/users/")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@GetMapping("api/users/{id}")
	public Account getAccountById(@PathVariable(value = "id") Long accountId) {
		return accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
	}
	

	public AccountController() {
	}

}
