package com.oracle.S20220602.lbh.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.Board;

public interface BoardRepository {
	List<Board> boardSelect(Board board);
	int total();
	int boardWrite(Board board);
	Board boardDetail(int boardno);
	int boardReply(Board board);
	int replyShape(Board board);
	int boardUpdate(Board board);
	int boardDelete(Board board);
	List<Board> boardReplyList(int ref);
	Board boardReplyOne(int boardno);
	int boardReplyCnt(int boardno);
}
