package com.web.board.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.board.repository.AccountRepository;
import com.web.board.vo.Account;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> findAll() {
		List<Account> list = accountRepository.findAll();
		return list;
	}
	
	public void createAccount(Account account) {
		account.setCreate_dt(LocalDate.now());
		accountRepository.save(account);
	}
	
	public Account getOne(String type) {
		return accountRepository.getOne(type);
	}
	
	public void updateAccount(String type, Account account) {
		
		accountRepository.findById(type)
		.map(Account -> {
			account.setBalance(account.getBalance());
			account.setUpdate_dt(LocalDate.now());
			return accountRepository.save(account);
		}).orElseGet(() -> {
			account.setType(type);
			return accountRepository.save(account);
		});
		
	}
	
	public void deleteOne(String type) {
		accountRepository.deleteById(type);
	}
}
