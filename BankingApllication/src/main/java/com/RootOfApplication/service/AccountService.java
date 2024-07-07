package com.RootOfApplication.service;

import org.springframework.http.ResponseEntity;

import com.RootOfApplication.mapper.AccountData;

public interface AccountService {
	
	ResponseEntity<AccountData> createAcount(AccountData accountData);
	  
	ResponseEntity<AccountData> getAccountDeatils(Long  accountNumber);
	  
	ResponseEntity<AccountData> deposite(long accountNumber , long depositeBalance);
	  
	ResponseEntity<AccountData> withDrawBalance(long accountNumber ,long amont);
	
	 ResponseEntity<AccountData> deleteAccount(long accountNumber);

}
