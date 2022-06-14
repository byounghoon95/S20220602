package com.oracle.S20220602.khj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	// 마이페이지
	@GetMapping("/mypage")
	public String mypage(Model model, HttpServletRequest request, Member member) {
		System.out.println("MypageController mypage Start...");
		String id = null;
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		
		String memberLocName = ms.memberLocNameSelect(id);
		member = ms.memberMypage(id);
		model.addAttribute("member", member);
		model.addAttribute("memberLocName", memberLocName);
		return "mypage";
	}
	
	// 프로필 수정폼
	@GetMapping("/mypagePrfUpdate")
	public String mypagePrfUpdate(HttpServletRequest request, Model model, Member member) {
		System.out.println("MypageController mypagePrfUpdate Start...");
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		member = ms.memberMypage(id);
		
		model.addAttribute("member", member);
		return "mypagePrfUpdate";
		
	}
	
	// 프로필 업데이트
	@PostMapping(value="/mypagePrfUpdatePro")
	public String mypagePrfUpdatePro(HttpServletRequest request, Model model, Member member) {
		System.out.println("MypageController mypagePrfUpdatePro Start...");
		int result = ms.mypagePrfUpdatePro(member);
		model.addAttribute("result", result);
		return "mypagePrfUpdatePro";
	}
	
	
	
	// 내가 작성한 글 
	@GetMapping("/mypageBoard")
	public String mypageBoard(Model model, HttpServletRequest request, Board board) {
		System.out.println("MypageController mypageBoard Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		board.setId(id);
		
		List<Board> mypageBoardList = ms.mypageBoardSelect(board);
		System.out.println("MypageController mypageBoardList boardList.size()->"+mypageBoardList.size());
		
		model.addAttribute("mypageBoardList", mypageBoardList);
		
		return "mypageBoard";
	}
	
	// 관심상품
	@GetMapping("/mypageWish")
	public String mypageWish(Model model, HttpServletRequest request, Item item) {
		System.out.println("MypageController mypageWish Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		
		List<Item> mypageWishList = ms.mypageWishList(item);
		System.out.println("MypageController mypageWish mypageWishList.size()-> "+mypageWishList.size());
		
//		데이터를 잘 가져왔는지 확인하는 방법
//		for(Item item2 : mypageWishList ) {
//			System.out.println("item2.getItemno()->"+item2.getItemno());
//			System.out.println("item2.getId()->"+item2.getId());
//		}
		model.addAttribute("mypageWishList", mypageWishList);
		
		return "mypageWish";
	}
	
	// 구매/판매내역
	@GetMapping("/mypageDeal")
	public String mypageDeal(Model model, HttpServletRequest request, Item item) {
		System.out.println("MypageController mypageDeal Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		
		List<Item> mypageBuyList = ms.mypageBuyList(item);
		List<Item> mypageSellList = ms.mypageSellList(item);
		System.out.println("MypageController mypageDeal mypageBuyList.size()->"+mypageBuyList.size());
		System.out.println("MypageController mypageDeal mypageSellList.size()->"+mypageSellList.size());
		model.addAttribute("mypageBuyList", mypageBuyList);
		model.addAttribute("mypageSellList", mypageSellList);
		
		return "mypageDeal";
	}
	
	// 가계부
	@GetMapping("/mypageBank")
	public String mypageBank(Model model, HttpServletRequest request, Item item) {
		System.out.println("MypageController mypageBank Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		
		int totalSellCount =  ms.totalSellCount(item);
		int totalSellCost =  ms.totalSellCost(item);
		model.addAttribute("totalSellCount", totalSellCount);
		model.addAttribute("totalSellCost", totalSellCost);
		
		return "mypageBank";
	}
	
	
}
