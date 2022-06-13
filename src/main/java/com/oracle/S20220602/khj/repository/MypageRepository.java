package com.oracle.S20220602.khj.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Member;

public interface MypageRepository {

	Member memberMypage(String id);
	String memberLocNameSelect(String id);
	List<Board> mypageBoardSelect(Board board);
	List<Item> mypageWishSelect(Item item);
	List<Item> mypageBuySelect(Item item);
	List<Item> mypageSellSelect(Item item);
	int totalSellCount(Item item);
	int totalSellCost(Item item);

}
