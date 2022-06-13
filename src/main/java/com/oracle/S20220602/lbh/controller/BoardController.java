package com.oracle.S20220602.lbh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.lbh.service.BoardService;
import com.oracle.S20220602.lbh.service.Paging;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("data", "안녕하세요");
		return "main";
	}
	// Board 전체 리스트 불러오기
	@GetMapping("/board")
	public String board(Board board,String currentPage, Model model) {
		System.out.println("BoardController board Start...");
		int total = bs.total();
		System.out.println("BoardController total ->" +total);
		Paging pg = new Paging(total, currentPage);
		board.setStart(pg.getStart());
		board.setEnd(pg.getEnd());
		List<Board> boardList = bs.boardSelect(board);
		System.out.println("BoardController board boardList.size()->"+boardList.size());
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pg", pg);
		model.addAttribute("total", total);
		return "board";
	}
	// 글 작성하기 클릭 후 새글 작성 페이지로 이동
	@GetMapping("/boardWriteForm")
	public String boardWriteForm(String id, Model model) {
		System.out.println("BoardController boardWriteForm Start...");
//		model.addAttribute("id",id); id 넘길 것으로 예상
		return "boardWriteForm";
	}
	// 글 등록 후 board 페이지로 전환
	@GetMapping("/boardWrite")
	public String boardWrite(Board board, Model model) {
		System.out.println("BoardController boardWrite Start...");
		int result = bs.boardWrite(board);
		model.addAttribute("result",result);
		return "boardWritePro";
	}
	@GetMapping("/boardDetail")
	public String boardDetail(int boardno, Model model) {
		System.out.println("BoardController boardDetail Start...");
		Board board = null;
		board = bs.boardDetail(boardno);
		model.addAttribute("board",board);
		return "boardDetail";
	}
	@GetMapping(value="boardUpdateForm")
	public String updateForm(Model model, Board board) {
		System.out.println("BoardController updateForm Start...");
		System.out.println("board.getBoardno() -> " + board.getBoardno());
		board = bs.boardDetail(board.getBoardno());
		model.addAttribute("board",board);

		return "boardUpdateForm";
	}
	//게시판 상세 수정
	@PostMapping(value="boardUpdate")
	public String boardUpdate(Board board, Model model) {
		System.out.println("BoardController boardUpdate Start...");
		int result = bs.boardUpdate(board);
		model.addAttribute("result", result);
		return "boardUpdatePro";
	}
	//게시판 상세 삭제
	@GetMapping(value="boardDelete")
	public String boardDelete(Board board, Model model) {
		System.out.println("BoardController boardUpdate Start...");
		int result = bs.boardDelete(board);
		model.addAttribute("result", result);
		return "boardDeletePro";
	}
	//리뷰
	@GetMapping("/reply")
	public String reply(Board board, Model model, String comment) {
		System.out.println("BoardController reply Start...");
		board.setBoardcontent(comment);
		int result = bs.boardReply(board);
		model.addAttribute("result",result);
		model.addAttribute("board",board);
		return "boardReplyPro";
	}
	
}