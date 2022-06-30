package com.oracle.S20220602.kkh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.S20220602.common.domain.List11;
import com.oracle.S20220602.kkh.service.List11Serveice;
import com.oracle.S20220602.kkh.service.Paging;

@Controller
public class List11Controller {

	@Autowired
	private List11Serveice ls;
	
	@GetMapping("/footer_list11")
	public String footer_list11(List11 list11, String currentPage, Model model, HttpServletRequest request) {
		System.out.println("List11Controller List11 Start..");
		
		String result = null;
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		list11.setId(id);
		model.addAttribute("id", id);
		
		if(id != null) {
		
		int total = ls.total();
		System.out.println("List11Controller total ->"+total);
		Paging pg = new Paging(total, currentPage);
		list11.setStart(pg.getStart());
		list11.setEnd(pg.getEnd());
		List<List11> list11list = ls.List11Select(list11);
		System.out.println("List11Controller list11list.size()->"+list11list.size());
		
		model.addAttribute("list11list", list11list);
		model.addAttribute("pg", pg);
		model.addAttribute("total", total);
		
		result = "footer_list11";
		} else {
			result = "redirect:login";
		}
		
		return result;
		
	}
	
	@GetMapping("/footer_list11Detail")
	public String list11Detail(int inqno, Model model, HttpServletRequest request, List11 list11) {
		System.out.println("list11Controller list11Detail Start");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		list11.setId(id);
		model.addAttribute("id", id);
		
		List<List11> list11ReplyList = null;
		int replycnt = ls.list11ReplyCnt(inqno);
		list11 = ls.list11Detail(inqno);
		list11ReplyList = ls.List11ReplyList(list11.getRef());
		model.addAttribute("list11ReplyList", list11ReplyList);
		model.addAttribute("list11", list11);
		model.addAttribute("replycnt", replycnt);
		return "footer_list11Detail";
	}
	
	@GetMapping("/footer_list11WriteForm")
	public String list11WriteForm(String id, Model model, HttpServletRequest request) {
		System.out.println("list11Controller list11WriteForm Start");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		
		return "footer_list11WriteForm";
	}
	
	@GetMapping("/footer_list11Write")
	public String list11Write(List11 list11, Model model, HttpServletRequest request) {
		System.out.println("list11Controller list11Write Start");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		list11.setId(id);
		model.addAttribute("id", id);
		
		int result = ls.list11Write(list11);
		model.addAttribute("result",result);
		return "footer_list11WritePro";
	}
	
	@GetMapping(value = "footer_list11UpdateForm")
	public String list11UpdateForm(Model model, List11 list11) {
		System.out.println("list11Controller list11UpdateForm start");
		System.out.println("list11.getInqno()->"+list11.getInqno());
		list11 = ls.list11Detail(list11.getInqno());
		model.addAttribute("list11", list11);
		return "footer_list11UpdateForm";
	}
	
	@PostMapping(value = "footer_list11Update")
	public String list11Update(List11 list11, Model model) {
		System.out.println("List11Controller list11Update Start");
		int result = ls.list11Update(list11);
		model.addAttribute("list11", list11);
		model.addAttribute("result", result);
		return "footer_list11UpdatePro";
	}
	
	@GetMapping(value = "footer_list11Delete")
	public String list11Delete(List11 list11 , Model model) {
		System.out.println("List11Controller list11Delete Start");
		int result = ls.list11Delete(list11);
		model.addAttribute("result", result);
		return "footer_list11DeletePro";
	}
}
