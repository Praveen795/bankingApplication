package com.RootOfApplication.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.RootOfApplication.DTO.AmountRequest;
import com.RootOfApplication.mapper.AccountData;
import com.RootOfApplication.serviceImpl.AccountSeriveImpl;

@RestController
@RequestMapping("/bank")
public class AccountController {

	@Autowired
	private AccountSeriveImpl accountSeriveImpl;

	@PostMapping("/createAccount")
	public ResponseEntity<AccountData> createAccount(@RequestBody AccountData accountData) {
		ResponseEntity<AccountData> receviedAccountData = accountSeriveImpl.createAcount(accountData);
		return receviedAccountData;

	}

	@GetMapping("/searchAccount")
	public ResponseEntity<AccountData> getAccountDetails(@RequestBody Map<String, Long> request) {
		Long accountNumber = request.get("AccountNumber");
		ResponseEntity<AccountData> receviedAccountData = accountSeriveImpl.getAccountDeatils(accountNumber);
		return receviedAccountData;

	}

	
	  @PutMapping("/depositeAmount")
	  public ResponseEntity<AccountData> depositeTheAmount(@RequestBody AmountRequest depositeRequest){
	  
	  long accountNumber1=depositeRequest.getAccountNumber();
	  long depositeAmount=depositeRequest.getAmount();
	  
	  ResponseEntity<AccountData> receviedAccountData=accountSeriveImpl.deposite(accountNumber1, depositeAmount);
	  return receviedAccountData;
	  
	
	  }
	  
	  @PutMapping("/withdrawAmount")
	  public ResponseEntity<AccountData> withdrawAmount(@RequestBody AmountRequest withdrawAmount ){
		  
		  long accountNumber=withdrawAmount.getAccountNumber();
		  long withdrawAmounts=withdrawAmount.getAmount();
		  ResponseEntity<AccountData> receviedAccountData=accountSeriveImpl.withDrawBalance(accountNumber, withdrawAmounts);
		  
		  return receviedAccountData;
		  
		  
	  }
	  
	  @DeleteMapping("/deleteAccount")
	  public ResponseEntity<AccountData> deleteAccount(@RequestBody Map<String, Long> request){
		  
		  long accountNumber=request.get("accountNumber");
		  ResponseEntity<AccountData> deletedAccount=accountSeriveImpl.deleteAccount(accountNumber);
		  
		  return deletedAccount;
		  
		  
		  
	  }
	 

}
