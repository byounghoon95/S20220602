package com.oracle.S20220602.kkh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.S20220602.common.domain.AdminList11;
import com.oracle.S20220602.common.domain.AdminQList;
import com.oracle.S20220602.kkh.service.AdminQListService;
import com.oracle.S20220602.kkh.service.Paging;

@Controller
public class AdminQListController {
	@Autowired
	private AdminQListService aqs;
	
	@GetMapping("/adminQList")
	public String adminQList(AdminQList adminQList, String currentPage, Model model) {
		System.out.println("AdminQListController adminQList Start..");
		int total = aqs.total();
		System.out.println("AdminQListController total ->"+total);
		Paging pg = new Paging(total, currentPage);
		adminQList.setStart(pg.getStart());
		adminQList.setEnd(pg.getEnd());
		List<AdminQList> QList = aqs.adminQListSelect(adminQList);
		System.out.println("AdminQListController adminQList.size"+QList.size());
		
		model.addAttribute("QList", QList);
		model.addAttribute("pg", pg);
		model.addAttribute("total", total);
		
		return "adminQList";
		
	}
	
	@GetMapping("/adminQListWriteForm")
	public String adminQListWriteForm(String id, Model model) {
		System.out.println("AdminQListController adminQListWriteForm Start..");
		return "adminQListWriteForm";
	}
	
	@GetMapping("/adminQListWrite")
	public String adminQListWrite(AdminQList adminqlist, Model model) {
		System.out.println("AdminQListController adminQListWrite Start...");
		int result = aqs.adminQListWrite(adminqlist);
		model.addAttribute("result",result);
		return "adminQListWritePro";
	}
	
	@GetMapping("/adminQListDetail")
	public String adminQlistDetail(int boardno, Model model) {
		System.out.println("AdminQListController adminQListDetail Start");
		AdminQList adminqlist = null;
		adminqlist = aqs.adminQListDetail(boardno);
		model.addAttribute("adminqlist", adminqlist);
		return "adminQListDetail";
	}
	
	@GetMapping(value = "adminQListUpdateForm")
	public String adminQListUpdateForm(Model model, AdminQList adminqlist) {
		System.out.println("AdminQListController adminQListUpdateForm start");
		System.out.println("adminqlist.getBoradno()->"+adminqlist.getBoardno());
		adminqlist = aqs.adminQListDetail(adminqlist.getBoardno());
		model.addAttribute("adminqlist", adminqlist);
		return "adminQListUpdateForm";
	}
	
	@PostMapping(value = "adminQListUpdate")
	public String adminQListUpdate(AdminQList adminqlist, Model model) {
		System.out.println("AdminQListController adminQListUpdate Start");
		int result = aqs.adminQListUpdate(adminqlist);
		model.addAttribute("adminqlist", adminqlist);
		model.addAttribute("result", result);
		return "adminQListUpdatePro";
		
	}
	
	@GetMapping(value = "adminQListDelete")
	public String adminQListDelete(AdminQList adminqlist, Model model) {
		System.out.println("AdminQListController adminQListDelete Start");
		int result = aqs.adminQListDelete(adminqlist);
		model.addAttribute("result", result);
		return "adminQListDeletePro";
	}
	


}
