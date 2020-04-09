package com.web.board.vo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {
	
	@Id
	@Column(name = "type")
	private String type;
	
	@Column(name = "balance")
	private int balance;
	
	@CreatedDate
	@Column(name = "create_dt")
	private LocalDate create_dt;
	
	@CreatedDate
	@Column(name = "update_dt")
	private LocalDate update_dt;
	
}
