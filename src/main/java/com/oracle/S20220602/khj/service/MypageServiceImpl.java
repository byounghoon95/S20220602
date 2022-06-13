package com.oracle.S20220602.khj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.khj.repository.MypageRepository;

@Service
public class MypageServiceImpl implements MypageService {
	
	private final MypageRepository mypageRepository;
	@Autowired
	public MypageServiceImpl(MypageRepository mypageRepository) {
		this.mypageRepository = mypageRepository;
	}

	@Override
	public Member memberMypage(String id) {
		System.out.println("MypageServiceImpl memberMypage Start...");
		Member member = null;
		System.out.println("MypageServiceImpl id-> "+id);
		member = mypageRepository.memberMypage(id);
		return member;
	}

	@Override
	public String memberLocNameSelect(String id) {
		 System.out.println("MypageServiceImpl memberLocNameSelect Start....");
	     String memberLocName = null;
	     memberLocName = mypageRepository.memberLocNameSelect(id);
	     return memberLocName;
	}

	@Override
	public List<Board> mypageBoardSelect(Board board) {
		System.out.println("MypageServiceImpl mypageBoardSelect ...");
		List<Board> mypageBoardSelect = null;
		mypageBoardSelect = mypageRepository.mypageBoardSelect(board);
		return mypageBoardSelect;
	}

	@Override
	public List<Item> mypageWishList(Item item) {
		System.out.println("MypageServiceImpl mypageWishList ...");
		List<Item> mypageWishSelect = null;
		mypageWishSelect = mypageRepository.mypageWishSelect(item);
		return mypageWishSelect;
	}
	
	@Override
	public List<Item> mypageBuyList(Item item) {
		System.out.println("MypageServiceImpl mypageBuyList ...");
		List<Item> mypageBuySelect = null;
		mypageBuySelect = mypageRepository.mypageBuySelect(item);
		return mypageBuySelect;
	}

	@Override
	public List<Item> mypageSellList(Item item) {
		System.out.println("MypageServiceImpl mypageSellList ...");
		List<Item> mypageSellSelect = null;
		mypageSellSelect = mypageRepository.mypageSellSelect(item);
		return mypageSellSelect;
	}

	@Override
	public int totalSellCount(Item item) {
		System.out.println("MypageServiceImpl totalSellCount Start....");
	    int totalSellCount = 0;
	    totalSellCount = mypageRepository.totalSellCount(item);
	    return totalSellCount;
		
	}

	@Override
	public int totalSellCost(Item item) {
		System.out.println("MypageServiceImpl totalSellCost Start....");
	    int totalSellCost = 0;
	    totalSellCost = mypageRepository.totalSellCost(item);
	    return totalSellCost;
	}




}
