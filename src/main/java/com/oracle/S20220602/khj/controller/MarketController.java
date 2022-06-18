package com.oracle.S20220602.khj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.khj.service.MarketService;
import com.oracle.S20220602.khj.service.Paging;

@Controller
public class MarketController {
	
	@Autowired
	private MarketService ms;
	
	@GetMapping("/market")
	public String market(Model model, String currentPage, Item item, HttpServletRequest request, Member member) {
		System.out.println("MarketController mypageWish Start...");
//		item.setId("kanghj");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		session.setAttribute("id", id);
		model.addAttribute("id", id);

		
		int total = ms.total();
		System.out.println("MarketController total->"+total);
		Paging pg = new Paging(total, currentPage);
		item.setStart(pg.getStart());
		item.setEnd(pg.getEnd());
		List<Item> marketBestList = ms.marketBestList(item);
		List<Item> marketAllList = ms.marketAllList(item);
		
//		// header --> id 값 받기
//		String id = member.getId();
//		HttpSession session = request.getSession();
//		session.setAttribute("id", id);
//		model.addAttribute("id", id);
		
		
		System.out.println("MarketController market marketBestList.size()-> "+marketBestList.size());
		System.out.println("MarketController market marketAllList.size()-> "+marketAllList.size());
		
		model.addAttribute("marketBestList", marketBestList);
		model.addAttribute("marketAllList", marketAllList);
		model.addAttribute("pg", pg);
		model.addAttribute("total", total);
		
		
		
		return "market";
	}
	
	@GetMapping("/footer_userAgreement")
	public String footer_userAgreement(Model model) {
		model.addAttribute("data", "안녕하세요");
		return "footer_userAgreement";
	}
	
	@GetMapping("/footer_personalInfo")
	public String footer_personalInfo(Model model) {
		model.addAttribute("data", "안녕하세요");
		return "footer_personalInfo";
	}
	
	@GetMapping("/main")
	public String main(HttpServletRequest request, Member member, Model model) {
		System.out.println("MarketController main start..");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		session.setAttribute("id", id);
		model.addAttribute("id", id);
		
		return "main";
	}
	
//	@GetMapping("/main")
//	public String main(HttpServletRequest request, Member member, Model model) {
//		System.out.println("MarketController main start..");
//		String input_id = member.getId();
//		HttpSession session = request.getSession();
//		session.setAttribute("id", input_id);
//		model.addAttribute("input_id", input_id);
//		
//		return "main";
//	}
	

}
