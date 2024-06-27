package io.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.bankapp.model.Accounts;
import io.bankapp.model.Logger;
import io.bankapp.service.AccountService;

import java.util.Date;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private LoggerController loggerController;

	// Create account
	@PostMapping("/account/create")
	public void createAccount(@RequestParam int acctID, @RequestParam int balance, @RequestParam String acctStatus,
							  @RequestParam String accountHolderName, @RequestParam String accountType,
							  @RequestParam Date createdDate, @RequestParam Date lastUpdatedDate,
							  @RequestParam String branch, @RequestParam double interestRate) {
		Accounts acct = new Accounts(acctID, balance, acctStatus, accountHolderName, accountType, createdDate, lastUpdatedDate, branch, interestRate);
		accountService.createAccount(acct);
	}

	// Check balance
	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID) {
		return accountService.getBalance(acctID);
	}

	// Deposit amount
	@PutMapping("/account/{acctID}/deposit/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.depositAmount(acctID, amount);
		Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount);
		loggerController.addLog(logger);
	}

	// Withdraw amount
	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.withdrawAmount(acctID, amount);
		Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
		loggerController.addLog(logger);
	}

	// Transfer amount
	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
	public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountService.transferAmount(acctID, destAcctID, amount);
		Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
		loggerController.addLog(loggerSender);
		Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver, initBalReceiver + amount);
		loggerController.addLog(loggerReceiver);
	}

	// Delete account
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) {
		accountService.deleteAccount(acctID);
		loggerController.deleteLog(acctID);
	}

	// Get account info
	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) {
		return accountService.getAccountInfo(acctID);
	}

	// Activate account
	@PutMapping("/account/{acctID}/activate")
	public void activateAccount(@PathVariable int acctID) {
		accountService.activateAccount(acctID);
		Logger logger = new Logger(acctID, "Activated", "Success");
		loggerController.addLog(logger);
	}

	// Deactivate account
	@PutMapping("/account/{acctID}/deactivate")
	public void deactivateAccount(@PathVariable int acctID) {
		accountService.deactivateAccount(acctID);
		Logger logger = new Logger(acctID, "Deactivated", "Success");
		loggerController.addLog(logger);
	}

	// Update account information
	@PutMapping("/account/{acctID}/update")
	public void updateAccountInfo(@PathVariable int acctID, @RequestParam String accountHolderName, 
								  @RequestParam String accountType, @RequestParam String branch, 
								  @RequestParam double interestRate) {
		accountService.updateAccountInfo(acctID, accountHolderName, accountType, branch, interestRate);
		Logger logger = new Logger(acctID, "Updated", "Success");
		loggerController.addLog(logger);
	}
}
