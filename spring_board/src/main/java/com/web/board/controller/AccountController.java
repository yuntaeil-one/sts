package com.web.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.board.api.OpenAPI;
import com.web.board.service.AccountService;
import com.web.board.vo.Account;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	@Autowired
	OpenAPI openAPI;
	
	
	@GetMapping(value = "/list")
	public ModelAndView AccountList() {
		
		HashMap<String, Integer> map = new HashMap<>();
		List<Account> list = accountService.findAll();
		
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getType(), list.get(i).getBalance());
		}
		
		ModelAndView view = new ModelAndView("account/list");
		
		view.addObject("accountList", list);
		view.addObject("accountMap", map);
		
		return view;
	}

	@GetMapping(value = "/create")
	public ModelAndView createAccount() {
		ModelAndView view = new ModelAndView("account/create");
		return view;
	}
	
	@PostMapping(value = "/create")
	public ModelAndView createAccount(Account account) {
		
		accountService.createAccount(account);
		
		ModelAndView view = new ModelAndView("account/list");
		List<Account> list = accountService.findAll();
		view.addObject("accountList", list);
		
		return view;
	}
	
	@GetMapping(value = "/update/{type}")
	public ModelAndView updateAccount(@PathVariable("type") String type) {
		Account account = accountService.getOne(type);
		ModelAndView view = new ModelAndView("account/update");
		view.addObject("account", account);
		return view;
	}
	
	@PostMapping(value = "/update/{type}")
	public ModelAndView updateAccount(@PathVariable("type") String type, Account account) {
		accountService.updateAccount(type, account);
		ModelAndView view = new ModelAndView("account/read");
		Account res = accountService.getOne(type);
		view.addObject("account", res);
		return view;
	}
	
	@GetMapping(value = "/delete/{type}")
	public ModelAndView deleteAccount(@PathVariable("type") String type) {
		
		accountService.deleteOne(type);
		ModelAndView view = new ModelAndView("account/list");
		List<Account> list = accountService.findAll();
		view.addObject("accountList", list);
		return view;

	}
	
	@PostMapping(value = "/api/ExchangeRate")
	public ModelAndView ExchangeRate() {
		
		ModelAndView view = new ModelAndView("account/list");
//		HashMap<String, String> map = new HashMap<String, String>();
//		map = openAPI.getKoreaexim();
		
		view.addObject("exchangeRate", openAPI.getKoreaexim());
		
		return view;
	}
}
