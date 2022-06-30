package com.oracle.S20220602.khj.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.common.domain.Reservation;

@Repository
public class MypageRepositoryImpl implements MypageRepository {
	
	@Autowired
	private SqlSession session;

	@Override
	public Member memberMypage(Member member) {
		System.out.println("MypageRepositoryImpl memberMypage Start...");
		Member locname = null;
		System.out.println("MypageRepositoryImpl memberMypage id-> "+member.getId());
		try {
			member = session.selectOne("khjMemberMypage", member);
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl memberMypage Exception-> "+e.getMessage());
		}
		
		return member;
	}

	
	@Override
	public String memberLocNameSelect(String id) {
		   System.out.println("MypageRepositoryImpl memberLocNameSelect Start....");
		      String memberLocName = null;
		      try {
		         memberLocName = session.selectOne("khjMemberMypageLocname", id);
		         System.out.println("MypageRepositoryImpl memberLocNameSelect  memberLocName->" + memberLocName );
		      }catch(Exception e){
		         System.out.println("MypageRepositoryImpl memberLocNameSelect Exception->"+e.getMessage());
		      }
		      return memberLocName;

	}


	@Override
	public List<Board> mypageBoardSelect(Board board) {
		List<Board> mypageListBoard = null;
		System.out.println("MypageRepositoryImpl boardSelect start...");
		try {
			mypageListBoard = session.selectList("khjmypageListBoard",board);
			System.out.println("MypageRepositoryImpl boardSelect listBoard.size() -> " + mypageListBoard.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl boardSelect Exception->"+e.getMessage());
		}
		return mypageListBoard;
	}


	@Override
	public List<Item> mypageWishSelect(Item item) {
		List<Item> mypageWishSelect = null;
		System.out.println("MypageRepositoryImpl mypageWishSelect start...");
		try {
			mypageWishSelect = session.selectList("khjmypageWishList",item);
			System.out.println("MypageRepositoryImpl mypageWishSelect mypageWishSelect.size() -> " + mypageWishSelect.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl mypageWishSelect Exception->"+e.getMessage());
		}
		return mypageWishSelect;
	}


	@Override
	public List<Item> mypageBuySelect(Item item) {
		List<Item> mypageBuySelect = null;
		System.out.println("MypageRepositoryImpl mypageBuySelect start...");
		try {
			mypageBuySelect = session.selectList("khjmypageBuyList",item);
			System.out.println("MypageRepositoryImpl mypageBuySelect mypageBuySelect.size() -> " + mypageBuySelect.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl mypageBuySelect Exception->"+e.getMessage());
		}
		return mypageBuySelect;
	}
	
	
	@Override
	public List<Item> mypageSellSelect(Item item) {
		List<Item> mypageSellSelect = null;
		System.out.println("MypageRepositoryImpl mypageSellSelect start...");
		try {
			mypageSellSelect = session.selectList("khjmypageSellList",item);
			System.out.println("MypageRepositoryImpl mypageSellSelect mypageSellSelect.size() -> " + mypageSellSelect.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl mypageSellSelect Exception->"+e.getMessage());
		}
		return mypageSellSelect;
	}
	
	@Override
	public List<Item> mypageSellSelect2(Item item) {
		List<Item> mypageSellSelect2 = null;
		System.out.println("MypageRepositoryImpl mypageSellSelect2 start...");
		try {
			mypageSellSelect2 = session.selectList("khjmypageSellList2",item);
			System.out.println("MypageRepositoryImpl mypageSellSelect2 mypageSellSelect.size() -> " + mypageSellSelect2.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl mypageSellSelect2 Exception->"+e.getMessage());
		}
		return mypageSellSelect2;
	}


	@Override
	public int totalSellCount(Item item) {
		System.out.println("MypageRepositoryImpl totalSellCount Start....");
	    int totalSellCount = 0;
	    try {
	    	totalSellCount = session.selectOne("khjtotalSellCount", item);
	        System.out.println("MypageRepositoryImpl totalSellCount  totalSellCount->" + totalSellCount );
	      }catch(Exception e){
	         System.out.println("MypageRepositoryImpl totalSellCount Exception->"+e.getMessage());
	      }
	    return totalSellCount;
	}


	@Override
	public int totalSellCost(Item item) {
		System.out.println("MypageRepositoryImpl totalSellCost Start....");
	    int totalSellCost = 0;
	    try {
	    	totalSellCost = session.selectOne("khjtotalSellCost", item);
	        System.out.println("MypageRepositoryImpl totalSellCost->" + totalSellCost );
	      }catch(Exception e){
	         System.out.println("MypageRepositoryImpl totalSellCost Exception->"+e.getMessage());
	      }
	    return totalSellCost;
	}


	@Override
	public int mypagePrfUpdate(Member member) {
		System.out.println("MypageRepositoryImpl mypagePrfUpdate Start...");
		int result = 0;
		try {
			System.out.println("MypageRepositoryImpl mypagePrfUpdate id -> " + member.getId());
			System.out.println("업데이트 되는 사진 ->" + member.getUserImg());
			result = session.update("khjmypagePrfUpdate", member);
		}catch (Exception e) {
			System.out.println("MypageRepositoryImpl mypagePrfUpdate Exception -> " + e.getMessage());
		}
		return result;
	}


	@Override
	public List<Reservation> mypageCommentSelect(Reservation reservation) {
		List<Reservation> mypageListComment = null;
		System.out.println("MypageRepositoryImpl mypageCommentSelect start...");
		try {
			mypageListComment = session.selectList("khjmypageCommentList",reservation);
			System.out.println("MypageRepositoryImpl mypageCommentSelect listBoard.size() -> " + mypageListComment.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl mypageCommentSelect Exception->"+e.getMessage());
		}
		return mypageListComment;
	}


	@Override
	public List<Common> selectLocList() {
		List<Common> selectLocList = null;
		
		System.out.println("MypageRepositoryImpl selectLocList start");
		try {
			selectLocList = session.selectList("khjselectLocList");
		}catch (Exception e) {
			System.out.println("MypageRepositoryImpl selectLocList exception -> " + e.getMessage());
		}
		return selectLocList;
	}


	@Override
	public Member memberMypage(String id) {
		System.out.println("MypageRepositoryImpl memberMypage Start...");
		Member member = null;
		Member locname = null;
		System.out.println("MypageRepositoryImpl memberMypage id-> "+id);
		try {
			member = session.selectOne("khjMemberMypageOther", id);
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl memberMypage Exception-> "+e.getMessage());
		}
		
		return member;
	}


	@Override
	public List<Item> mypageOtherSellList(Item item) {
		List<Item> mypageOtherSellSelect = null;
		System.out.println("MypageRepositoryImpl mypageSellSelect start...");
		try {
			mypageOtherSellSelect = session.selectList("khjmypageOtherSellList",item);
			System.out.println("MypageRepositoryImpl mypageSellSelect mypageOtherSellSelect.size() -> " + mypageOtherSellSelect.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl mypageSellSelect Exception->"+e.getMessage());
		}
		return mypageOtherSellSelect;
	}






}
