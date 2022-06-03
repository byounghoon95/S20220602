package com.oracle.S20220602.lbh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Board;
@Repository
public class BoardRepositoryImpl implements BoardRepository{
	
	@Autowired
	private SqlSession		session;
	
	//Board 전체 리스트 조회
	@Override
	public List<Board> boardSelect(Board board) {
		List<Board> listBoard = null;
		System.out.println("BoardRepositoryImpl boardSelect start...");
		try {
			listBoard = session.selectList("lbhListBoard",board);
			System.out.println("BoardRepositoryImpl boardSelect listBoard.size() -> " + listBoard.size());
		} catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardSelect Exception->"+e.getMessage());
		}
		return listBoard;
	}
	//Board 댓글을 제외한 나머지 count
	@Override
	public int total() {
		int total = 0;
		System.out.println("BoardRepositoryImpl total start...");
		try {
			total = session.selectOne("lbhBoardCount");
			System.out.println("BoardRepositoryImpl total -> " + total);
		} catch (Exception e) {
			System.out.println("BoardRepositoryImpl total() Exception->"+e.getMessage());
		}
		return total;
	}

	@Override
	public int boardWrite(Board board) {
		int result = 0;
		System.out.println("BoardRepositoryImpl boardWrite Start");
		try {
			result = session.insert("lbhBoardWrite",board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardWrite Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public Board boardDetail(int boardno) {
		System.out.println("BoardRepositoryImpl boardDetail Start");
		Board board = null;
		try {
			board = session.selectOne("lbhBoardDetail",boardno);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardDetail Exception -> " + e.getMessage());
		}
		return board;
	}
	
	//리뷰 S
	@Override
	public int boardReply(Board board) {
		System.out.println("BoardRepositoryImpl boardReply Start");
		int result = 0;
		replyShape(board);
		try {
			System.out.println("board.getRef()->"+board.getRef());
			System.out.println("board.getRef_level()->"+board.getRef_level());
			System.out.println("board.getRef_step()->"+board.getRef_step());
			System.out.println("board.getBoardtitle()->"+board.getBoardtitle());
			if (board.getBoardtitle() == null) {
				System.out.println("board.getBoardtitle() is NULL");
			}
			result = session.insert("lbhReplyWrite",board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardReply Exception -> " + e.getMessage());
		}
		System.out.println("boardDao boardReply result->"+result);
		return result;
	}
	@Override
	public int replyShape(Board board) {
		System.out.println("BoardRepositoryImpl replyShape Start");
		int result = 0;
		try {
			result = session.update("lbhReplyShape", board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl replyShape Exception -> " + e.getMessage());
		}
		return result;
	}
	//리뷰 E
	@Override
	public int boardUpdate(Board board) {
		System.out.println("BoardRepositoryImpl boardUpdate Start");
		int result = 0;
		try {
			System.out.println("boardno -> " + board.getBoardno());
			result = session.update("lbhboardUpdate", board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardUpdate Exception -> " + e.getMessage());
		}
		return result;
	}
	@Override
	public int boardDelete(Board board) {
		System.out.println("BoardRepositoryImpl boardDelete Start");
		int result = 0;
		try {
			result = session.update("lbhboardDelete", board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardDelete Exception -> " + e.getMessage());
		}
		return result;
	}
	
}
