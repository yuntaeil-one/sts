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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
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


}
