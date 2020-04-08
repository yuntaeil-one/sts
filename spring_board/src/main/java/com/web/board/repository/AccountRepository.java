package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.board.vo.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
