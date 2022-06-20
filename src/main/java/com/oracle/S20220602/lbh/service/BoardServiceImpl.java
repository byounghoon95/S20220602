package com.oracle.S20220602.lbh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.lbh.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository boardRepository;
	@Autowired
	public BoardServiceImpl(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public List<Board> boardSelect(Board board) {
		System.out.println("BoardServiceImpl listBoard ...");
		List<Board> listBoard = null;
		listBoard = boardRepository.boardSelect(board);
		return listBoard;
	}

	@Override
	public int total() {
		int total = 0;
		System.out.println("BoardServiceImpl total start");
		total = boardRepository.total();
		return total;
	}

	@Override
	public int boardWrite(Board board) {
		int result = 0;
		System.out.println("BoardServiceImpl boardWrite Start");
		result = boardRepository.boardWrite(board);
		return result;
	}

	@Override
	public Board boardDetail(int boardno) {
		System.out.println("BoardServiceImpl boardDetail Start");
		Board board = null;
		board = boardRepository.boardDetail(boardno);
		return board;
	}
	
	@Override
	public int boardReply(Board board) {
		System.out.println("BoardServiceImpl boardReply Start");
		int result = 0;
		result = boardRepository.boardReply(board);
		return result;
	}

	@Override
	public int boardUpdate(Board board) {
		System.out.println("BoardServiceImpl boardUpdate Start");
		int result = 0;
		result = boardRepository.boardUpdate(board);
		return result;
	}

	@Override
	public int boardDelete(Board board) {
		System.out.println("BoardServiceImpl boardDelete Start");
		int result = 0;
		result = boardRepository.boardDelete(board);
		return result;
	}

	@Override
	public List<Board> boardReplyList(int ref) {
		System.out.println("BoardServiceImpl boardReplyList Start");
		List<Board> boardReplyList = null;
		boardReplyList = boardRepository.boardReplyList(ref);
		return boardReplyList;
	}

	@Override
	public Board boardReplyOne(int boardno) {
		System.out.println("BoardServiceImpl boardReplyOne Start");
		Board board = boardRepository.boardReplyOne(boardno);
		return board;
	}
	@Override
	public int boardReplyCnt(int boardno) {
		System.out.println("BoardServiceImpl boardReplyCnt Start");
		int cnt = boardRepository.boardReplyCnt(boardno);
		return cnt;
	}

	@Override
	public int boardReplyUpdate(Board board) {
		System.out.println("BoardServiceImpl boardReplyUpdate Start");
		int result = boardRepository.boardReplyUpdate(board);
		return result;
	}


}
