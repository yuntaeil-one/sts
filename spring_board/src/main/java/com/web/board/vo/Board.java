package com.web.board.vo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "board")
@Data
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
	private Integer b_id;
	
	@Column(name = "b_writer", nullable = false, length = 100)
	private String b_writer;
	
	@Column(name = "b_title", nullable = false, length = 100)
	private String b_title;
	
	@Column(name = "b_contents", nullable = false, length = 512)
	private String b_contents;

	@CreationTimestamp
	@Column(name = "b_created_date")
	private LocalDateTime b_created_date;

	@UpdateTimestamp
	@Column(name = "b_update_date")
	private LocalDateTime b_update_date;

//	public Integer getB_id() {
//		return b_id;
//	}
//
//	public void setB_id(Integer b_id) {
//		this.b_id = b_id;
//	}
//
//	public String getB_writer() {
//		return b_writer;
//	}
//
//	public void setB_writer(String b_writer) {
//		this.b_writer = b_writer;
//	}
//
//	public String getB_title() {
//		return b_title;
//	}
//
//	public void setB_title(String b_title) {
//		this.b_title = b_title;
//	}
//
//	public String getB_contents() {
//		return b_contents;
//	}
//
//	public void setB_contents(String b_contents) {
//		this.b_contents = b_contents;
//	}
//
//	public LocalDateTime getB_created_date() {
//		return b_created_date;
//	}
//
//	public void setB_created_date(LocalDateTime b_created_date) {
//		this.b_created_date = b_created_date;
//	}
//
//	public LocalDateTime getB_update_date() {
//		return b_update_date;
//	}
//
//	public void setB_update_date(LocalDateTime b_update_date) {
//		this.b_update_date = b_update_date;
//	}




}
