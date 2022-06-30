package com.oracle.S20220602.kkh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.S20220602.common.domain.AdminList11;
import com.oracle.S20220602.common.domain.List11;
import com.oracle.S20220602.kkh.service.AdminList11Service;
import com.oracle.S20220602.kkh.service.Paging;

@Controller
public class AdminList11Controller {

	@Autowired
	private AdminList11Service als;
	
	@GetMapping("/adminList11")
	public String adminList11(AdminList11 adminList11, String currentPage, Model model) {
		
		System.out.println("AdminList11Controller adminList11 start");
		int total = als.total();
		System.out.println("AdminList11Controller total->"+total);
		
		
		Paging pg = new Paging(total, currentPage);
		
		adminList11.setStart(pg.getStart());
		adminList11.setEnd(pg.getEnd());
		List<AdminList11> List11 = als.adminList11Select(adminList11);
		System.out.println("AdminList11Controller List11.size->"+List11.size());
		model.addAttribute("List11", List11);
		model.addAttribute("pg", pg);
		model.addAttribute("total", total);		
		return "adminList11";
		
	}
	
	@GetMapping("/adminList11Detail")
	public String adminList11Detail(int inqno, Model model) {
		System.out.println("AdminList11Controller adminList11Detail start");
		
		List<AdminList11> adminList11ReplyList = null;
		
		int replycnt = als.adminList11ReplyCnt(inqno);
		
		AdminList11 adminList11 = als.adminList11Detail(inqno);
		
		adminList11ReplyList =als.adminList11ReplyList(adminList11.getRef());
		
		model.addAttribute("adminList11ReplyList", adminList11ReplyList);
		model.addAttribute("adminList11", adminList11);
		model.addAttribute("replycnt", replycnt);
		System.out.println("replycnt->"+replycnt);
		return "adminList11Detail";
	}
	
	@GetMapping(value = "adminList11Delete")
		public String adminList11Delete(AdminList11 adminList11 , Model model) {
		System.out.println("AdminList11Controller adminList11Delete Start");
		int result = als.adminList11Delete(adminList11);
		model.addAttribute("result", result);
		return "adminList11DeletePro";
	}
	
	@GetMapping("/adminList11reply")
	public String reply(AdminList11 adminList11 , Model model, String comment, HttpServletRequest request) {
		System.out.println("AdminList11Controller reply Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		adminList11.setSessionId(id);
		System.out.println("AdminList11Controller reply id->"+id);
		
		adminList11.setInqcontent(comment);
		int result = als.adminList11Reply(adminList11);
		
//		als.adminList11Update(adminList11.getInqno());
		
		model.addAttribute("result",result);
		model.addAttribute("adminList11",adminList11);
		return "adminList11ReplyPro";
	}
}
