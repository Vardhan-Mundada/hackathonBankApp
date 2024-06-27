package io.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.bankapp.dao.AccountsRepository;
import io.bankapp.model.Accounts;

@Service
public class AccountService {
	@Autowired
	private AccountsRepository accountRepository;

	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

	public Accounts getAccountInfo(int acctID) {
		return accountRepository.findById(acctID).orElse(null);
	}

	public void deleteAccount(int acctID) {
		accountRepository.deleteById(acctID);
	}

	public int getBalance(int acctID) {
		Accounts acct = getAccountInfo(acctID);
		return (acct != null) ? acct.getBalance() : 0;
	}

	public void depositAmount(int acctID, int amount) {
		Accounts acct = getAccountInfo(acctID);
		if (acct != null) {
			acct.deposit(amount);
			accountRepository.save(acct);
		}
	}

	public void withdrawAmount(int acctID, int amount) {
		Accounts acct = getAccountInfo(acctID);
		if (acct != null) {
			acct.withdraw(amount);
			accountRepository.save(acct);
		}
	}

	public void transferAmount(int acctID, int destAcctID, int amount) {
		Accounts sourceAcct = getAccountInfo(acctID);
		Accounts destAcct = getAccountInfo(destAcctID);
		if (sourceAcct != null && destAcct != null) {
			sourceAcct.transfer(destAcct, amount);
			accountRepository.save(sourceAcct);
			accountRepository.save(destAcct);
		}
	}

	public void activateAccount(int acctID) {
		Accounts acct = getAccountInfo(acctID);
		if (acct != null) {
			acct.activate();
			accountRepository.save(acct);
		}
	}

	public void deactivateAccount(int acctID) {
		Accounts acct = getAccountInfo(acctID);
		if (acct != null) {
			acct.deactivate();
			accountRepository.save(acct);
		}
	}

	public void updateAccountInfo(int acctID, String accountHolderName, String accountType, String branch, double interestRate) {
		Accounts acct = getAccountInfo(acctID);
		if (acct != null) {
			acct.setAccountHolderName(accountHolderName);
			acct.setAccountType(accountType);
			acct.setBranch(branch);
			acct.setInterestRate(interestRate);
			accountRepository.save(acct);
		}
	}
}
