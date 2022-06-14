package com.oracle.S20220602.khj.service;

import java.util.List;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Member;

public interface MypageService {

	Member memberMypage(String id);
	String memberLocNameSelect(String id);
	List<Board> mypageBoardSelect(Board board);
	List<Item> mypageWishList(Item item);
	List<Item> mypageBuyList(Item item);
	List<Item> mypageSellList(Item item);
	int totalSellCount(Item item);
	int totalSellCost(Item item);
	int mypagePrfUpdatePro(Member member);

}
