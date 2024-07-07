package com.RootOfApplication.mapper;

import com.RootOfApplication.entity.Account;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long accountNumber;
	private String accountHolderName;
	private long balance;
	
	public static Account accountDtoToAccount(AccountData accountData) {
		Account account=new Account();
		account.setId(accountData.getId());
		account.setAccountNumber(accountData.getAccountNumber());
		account.setAccountHolderName(accountData.getAccountHolderName());
		account.setBalance(accountData.getBalance());
		
		return account;
	}
	
	public static AccountData AccountToAccountData(Account account) {
		AccountData accountData=new AccountData();
		accountData.setId(account.getId());
		accountData.setAccountNumber(account.getAccountNumber());
		accountData.setAccountHolderName(account.getAccountHolderName());
		accountData.setBalance(account.getBalance());
		return accountData;
	}

	public AccountData() {
		super();
	}

	public AccountData(int id, long accountNumber, String accountHolderName, long balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
	
	
	

}
