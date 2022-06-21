package com.oracle.S20220602.khj.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.common.domain.Reservation;

public interface MypageRepository {

	Member memberMypage(String id);
	String memberLocNameSelect(String id);
	List<Board> mypageBoardSelect(Board board);
	List<Item> mypageWishSelect(Item item);
	List<Item> mypageBuySelect(Item item);
	List<Item> mypageSellSelect(Item item);
	int totalSellCount(Item item);
	int totalSellCost(Item item);
//	int mypagePrfUpdate(Member member);
	int mypagePrfUpdate(Member member);
	List<Reservation> mypageCommentSelect(Reservation reservation);
	List<Common> selectLocList();

}
