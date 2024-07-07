package com.RootOfApplication.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.RootOfApplication.accRepository.AccountRepository;
import com.RootOfApplication.entity.Account;
import com.RootOfApplication.mapper.AccountData;
import com.RootOfApplication.service.AccountService;

@Service
public class AccountSeriveImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public ResponseEntity<AccountData> createAcount(AccountData accountData) {
		Account account= AccountData.accountDtoToAccount(accountData);
		
		if(accountRepository.findByaccountNumber(account.getAccountNumber())==null) {
			AccountData newAccountData= AccountData.AccountToAccountData(accountRepository.save(account));
			return ResponseEntity.status(HttpStatus.CREATED).body(newAccountData);
			 
			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}

	@Override
	public ResponseEntity<AccountData> getAccountDeatils(Long accountNumber) {
		
		Account account=accountRepository.findByaccountNumber(accountNumber);
		
		if(account!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(AccountData.AccountToAccountData(account));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	
	
	

	@Override
	public ResponseEntity<AccountData> deposite(long accountNumber, long depositeBalance) {
		Account account=accountRepository.findByaccountNumber(accountNumber);
		
		if(account!=null) {
			long totalBalance=account.getBalance()+depositeBalance;
			account.setBalance(totalBalance);
			Account newAccount=accountRepository.save(account);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(AccountData.AccountToAccountData(newAccount));
		
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
		
		
	}
	
	

	@Override
	public ResponseEntity<AccountData> withDrawBalance(long accountNumber, long withdrawAmount) {

		Account account = accountRepository.findByaccountNumber(accountNumber);

		if (account != null && account.getBalance() > withdrawAmount) {
			long totalBalance = account.getBalance() - withdrawAmount;
			account.setBalance(totalBalance);
			Account newAccount = accountRepository.save(account);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(AccountData.AccountToAccountData(newAccount));

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		
	}

	public ResponseEntity<AccountData> deleteAccount(long accountNumber) {
		
		Account account=accountRepository.findByaccountNumber(accountNumber);
		if(account!=null) {
	    accountRepository.delete(account);
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body(AccountData.AccountToAccountData(account));	
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
	}

	
	
	

}
