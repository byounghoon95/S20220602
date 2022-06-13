package com.oracle.S20220602.khj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.khj.service.MypageService;
import com.oracle.S20220602.lbh.service.BoardService;
import com.oracle.S20220602.lbh.service.Paging;

@Controller
public class MypageController {
	@Autowired
	private MypageService ms;
	
	
	@GetMapping("/mypage")
	public String mypage(String id, Model model) {
		System.out.println("MypageController mypage Start...");
		id = "kanghj";
		Member member = null;
		String memberLocName = ms.memberLocNameSelect(id);
		member = ms.memberMypage(id);
		model.addAttribute("member", member);
		model.addAttribute("memberLocName", memberLocName);
		return "mypage";
	}
	
	@GetMapping("/mypagePrfUpdate")
	public String mypagePrfUpdate(String id, Model model) {
		System.out.println("MypageController mypagePrfUpdate Start...");
		id = "kanghj";
		Member member = null;
		model.addAttribute("member", member);
		return "mypagePrfUpdate";
	}
	
	@GetMapping("/mypageBoard")
	public String mypageBoard(Model model, Board board) {
		System.out.println("MypageController mypageBoard Start...");
		board.setId("kanghj");
		List<Board> mypageBoardList = ms.mypageBoardSelect(board);
		System.out.println("MypageController mypageBoardList boardList.size()->"+mypageBoardList.size());
		
		model.addAttribute("mypageBoardList", mypageBoardList);
		
		return "mypageBoard";
	}
	
	// 관심상품
	@GetMapping("/mypageWish")
	public String mypageWish(Model model, Item item) {
		System.out.println("MypageController mypageWish Start...");
//		id = "kanghj";
		item.setId("kanghj");
		List<Item> mypageWishList = ms.mypageWishList(item);
//		String itemLocName = ms.itemLocNameSelect(id);
		System.out.println("MypageController mypageWish mypageWishList.size()-> "+mypageWishList.size());
		
//		데이터를 잘 가져왔는지 확인하는 방법
//		for(Item item2 : mypageWishList ) {
//			System.out.println("item2.getItemno()->"+item2.getItemno());
//			System.out.println("item2.getId()->"+item2.getId());
//		}
		model.addAttribute("mypageWishList", mypageWishList);
//		model.addAttribute("itemLocName", itemLocName);
		
		return "mypageWish";
	}
	
	@GetMapping("/mypageDeal")
	public String mypageDeal(Model model, Item item) {
		System.out.println("MypageController mypageDeal Start...");
		item.setId("kanghj");
		List<Item> mypageBuyList = ms.mypageBuyList(item);
		List<Item> mypageSellList = ms.mypageSellList(item);
		System.out.println("MypageController mypageDeal mypageBuyList.size()->"+mypageBuyList.size());
		System.out.println("MypageController mypageDeal mypageSellList.size()->"+mypageSellList.size());
		model.addAttribute("mypageBuyList", mypageBuyList);
		model.addAttribute("mypageSellList", mypageSellList);
		
		return "mypageDeal";
	}
	
	@GetMapping("/mypageBank")
	public String mypageBank(Model model, Item item) {
		System.out.println("MypageController mypageBank Start...");
		item.setId("kanghj");
		int totalSellCount =  ms.totalSellCount(item);
		int totalSellCost =  ms.totalSellCost(item);
		model.addAttribute("totalSellCount", totalSellCount);
		model.addAttribute("totalSellCost", totalSellCost);
		
		return "mypageBank";
	}
	
	
}
