package com.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.board.service.BoardService;
import com.web.board.vo.Board;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping(value = "/list")
	public ModelAndView boardList() {
		
		List<Board> list = boardService.findAll();
		ModelAndView view = new ModelAndView("board/list");
		
		view.addObject("boardList", list);
		return view;
	}

	@GetMapping(value = "/create")
	public ModelAndView createBoard() {
		ModelAndView view = new ModelAndView("board/create");
		return view;
	}
	
	@PostMapping(value = "/create")
	public ModelAndView createBoard(Board board) {
		
		boardService.createBoard(board);
		
		ModelAndView view = new ModelAndView("board/list");
		List<Board> list = boardService.findAll();
		view.addObject("boardList", list);
		
		return view;
	}
	
	@GetMapping(value = "/{b_id}")
	public ModelAndView boardOneRead(@PathVariable("b_id") int b_id) {
		Board board = boardService.getOne(b_id);
		ModelAndView view = new ModelAndView("board/read");
		view.addObject("board", board);
		return view;
	}
	
	@GetMapping(value = "/update/{b_id}")
	public ModelAndView updateBoard(@PathVariable("b_id") int b_id) {
		
		System.out.println("updateBoard get");
		Board board = boardService.getOne(b_id);
		ModelAndView view = new ModelAndView("board/update");
		view.addObject("board",board);
		return view;
	}
	
	@PostMapping(value = "/update/{b_id}")
	public ModelAndView updateBoard(@PathVariable("b_id") int b_id, Board board) {
		System.out.println("updateBoard post");
		boardService.updateBoard(b_id, board);
		ModelAndView view = new ModelAndView("board/read");
		Board res = boardService.getOne(b_id);
		view.addObject("board", res);
		return view;
	}
	
	@GetMapping(value = "/delete/{b_id}")
	public ModelAndView deleteBoard(@PathVariable("b_id") int b_id) {
		
		boardService.deleteOne(b_id);
		ModelAndView view = new ModelAndView("board/list");
		List<Board> list = boardService.findAll();
		view.addObject("boardList", list);
		return view;

	}

}
