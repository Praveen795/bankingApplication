package com.RootOfApplication.accRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RootOfApplication.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findByaccountNumber(Long accountNumber);

}
