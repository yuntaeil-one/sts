package com.web.board.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.board.repository.BoardRepository;
import com.web.board.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	public List<Board> findAll() {
		List<Board> list = boardRepository.findAll();
		return list;
	}
	
	public void createBoard(Board board) {
		boardRepository.save(board);
	}
	
	public Board getOne(int b_id) {
		return boardRepository.getOne(b_id);
	}
	
	public void updateBoard(int b_id, Board board) {
		
		boardRepository.findById((int) b_id)
		.map(Board -> {
			board.setB_title(board.getB_title());
			board.setB_contents(board.getB_contents());
			board.setB_created_date(LocalDateTime.now());
			board.setB_update_date(LocalDateTime.now());
			return boardRepository.save(board);
		}).orElseGet(() -> {
			board.setB_id(b_id);
			return boardRepository.save(board);
		});
		
	}
	
	public void deleteOne(int b_id) {
		boardRepository.deleteById(b_id);
	}
}
