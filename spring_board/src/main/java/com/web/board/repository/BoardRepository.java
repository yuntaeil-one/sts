package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.board.vo.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
