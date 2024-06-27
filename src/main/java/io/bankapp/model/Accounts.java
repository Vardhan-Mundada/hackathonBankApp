package io.bankapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Accounts {
	@Id
	private int acctID;
	private int balance;
	private String acctStatus;
	private String accountHolderName;
	private String accountType;
	private Date createdDate;
	private Date lastUpdatedDate;
	private String branch;
	private double interestRate;

	public Accounts() {
		this.acctStatus = "active";
		this.createdDate = new Date();
		this.lastUpdatedDate = new Date();
	}

	public Accounts(int acctID, int balance, String acctStatus, String accountHolderName, String accountType, 
			Date createdDate, Date lastUpdatedDate, String branch, double interestRate) {
		super();
		this.acctID = acctID;
		this.balance = balance;
		this.acctStatus = acctStatus;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.createdDate = createdDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.branch = branch;
		this.interestRate = interestRate;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
		this.lastUpdatedDate = new Date(); 
	}

	public String getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
		this.lastUpdatedDate = new Date();
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
		this.lastUpdatedDate = new Date(); 
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
		this.lastUpdatedDate = new Date();
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
		this.lastUpdatedDate = new Date();
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
		this.lastUpdatedDate = new Date();
	}

	public void deposit(int amount) {
		if (amount > 0) {
			this.balance += amount;
			this.lastUpdatedDate = new Date(); 
		} else {
			System.out.println("Deposit amount must be positive.");
		}
	}

	public void withdraw(int amount) {
		if (amount > 0) {
			if (this.balance >= amount) {
				this.balance -= amount;
				this.lastUpdatedDate = new Date(); 
			} else {
				System.out.println("Insufficient funds.");
			}
		} else {
			System.out.println("Withdrawal amount must be positive.");
		}
	}

	public void transfer(Accounts targetAccount, int amount) {
		if (targetAccount != null && amount > 0) {
			if (this.balance >= amount) {
				this.withdraw(amount);
				targetAccount.deposit(amount);
				this.lastUpdatedDate = new Date();
			} else {
				System.out.println("Insufficient funds.");
			}
		} else {
			System.out.println("Invalid transfer details.");
		}
	}

	public void deactivate() {
		this.acctStatus = "inactive";
		this.lastUpdatedDate = new Date(); 
	}

	public void activate() {
		this.acctStatus = "active";
		this.lastUpdatedDate = new Date();
	}

	public boolean isActive() {
		return "active".equalsIgnoreCase(this.acctStatus);
	}

	@Override
	public String toString() {
		return "Accounts [acctID=" + acctID + ", balance=" + balance + ", acctStatus=" + acctStatus 
			+ ", accountHolderName=" + accountHolderName + ", accountType=" + accountType 
			+ ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate 
			+ ", branch=" + branch + ", interestRate=" + interestRate + "]";
	}
}
