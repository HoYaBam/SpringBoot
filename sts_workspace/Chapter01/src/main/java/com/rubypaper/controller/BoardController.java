package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

@RestController
public class BoardController {
	
	public BoardController() {
		System.out.println("(☞ﾟヮﾟ)☞ BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public List<BoardVO> getBoard() {
		List<BoardVO> boardList= new ArrayList<BoardVO>();
		for(int i=1; i<=10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("테스트 제목...");
			board.setWriter("테스터");
			board.setContent(i+"테스트 내용입니다....(´▽`ʃ♡ƪ)(´▽`ʃ♡ƪ)");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		
		return boardList;
	}
}
