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

	@RequestMapping(value = "api/users/register",method = RequestMethod.POST)
	public Account createAccount(@Valid @RequestBody Account account) {
		return accountRepository.save(account);
	}

	@PutMapping(value = "api/transaction/deposit")
	public Account makeDeposit(@PathVariable(value = "id") Long accountId, @RequestParam("amount") double amount) {

		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

		account.setBalance(account.getBalance() + amount);
		Account updatedAccount = accountRepository.save(account);
		return updatedAccount;
	}

	@PostMapping(value = "api/transaction/withdraw")
	public Account makeWithdraw(@PathVariable(value = "id") Long accountId, @RequestParam("amount") double amount) {

		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

		account.setBalance(account.getBalance() - amount);
		Account updatedAccount = accountRepository.save(account);
		return updatedAccount;
	}
	

	public AccountController() {
	}

}
