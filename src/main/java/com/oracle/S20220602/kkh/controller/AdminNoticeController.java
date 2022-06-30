package com.oracle.S20220602.kkh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.S20220602.common.domain.AdminNotice;
import com.oracle.S20220602.kkh.service.AdminNoticeService;
import com.oracle.S20220602.kkh.service.Paging;

@Controller
public class AdminNoticeController {
	@Autowired
	private AdminNoticeService ans;
	
	@GetMapping("/adminNotice")
	public String adminNotice(AdminNotice adminnotice, String currentPage, Model model) {
		System.out.println("AdminNoticeController adminnotice Start..");
		int total = ans.total();
		System.out.println("AdminNoticeController total ->"+total);
		Paging pg = new Paging(total, currentPage);
		adminnotice.setStart(pg.getStart());
		adminnotice.setEnd(pg.getEnd());
		List<AdminNotice> adminNoticeList = ans.adminNoticeSelect(adminnotice);
		System.out.println("adminnoticeController adminnoticeList.size"+adminNoticeList.size());
		
		model.addAttribute("adminNoticeList", adminNoticeList);
		model.addAttribute("pg", pg);
		model.addAttribute("total", total);
		
		return "adminNotice";
		
	}
	
	@GetMapping("/adminNoticeWriteForm")
	public String adminNoticeWriteForm(String id, Model model) {
		System.out.println("AdminNoticeController adminNoticeWriteForm start..");
		return "adminNoticeWriteForm";
	}
	
	@GetMapping("/adminNoticeWrite")
	public String adminNoticeWrite(AdminNotice adminnotice, Model model) {
		System.out.println("AdminNoticeController adminNoticeWrite Start..");
		int result = ans.adminNoticeWrite(adminnotice);
		model.addAttribute("result",result);
		return "adminNoticeWritePro";

	}
	
	@GetMapping("/adminNoticeDetail")
	public String adminNoticeDetail(int boardno, Model model) {
		System.out.println("AdminNoticeController adminNoticeDetail Start..");
		AdminNotice adminnotice = null;
		adminnotice = ans.adminNoticeDetail(boardno);
		model.addAttribute("adminnotice", adminnotice);
		return "adminNoticeDetail";
	}
	
	@GetMapping(value = "adminNoticeUpdateForm")
	public String adminNoticeUpdateForm(Model model, AdminNotice adminnotice) {
		System.out.println("AdminNoticeController adminNoticeUpdateForm Start");
		System.out.println("adminnotice.getBoardno()"+adminnotice.getBoardno());
		adminnotice = ans.adminNoticeDetail(adminnotice.getBoardno());
		model.addAttribute("adminnotice", adminnotice);
		return "adminNoticeUpdateForm";
	}
	
	@PostMapping(value = "adminNoticeUpdate")
	public String adminNoticeUpdate(AdminNotice adminnotice, Model model) {
		System.out.println("AdminNoticeController adminNoticeUpdate Start");
		int result = ans.adminNoticeUpdate(adminnotice);

		model.addAttribute("adminnotice", adminnotice);
		model.addAttribute("result", result);
		return "adminNoticeUpdatePro";
	}
	
	@GetMapping(value = "adminNoticeDelete")
	public String adminNoticeDelete(AdminNotice adminnotice, Model model) {
		System.out.println("AdminNoticeController adminNoticeDelete Start");
		int result = ans.adminNoticeDelete(adminnotice);
		model.addAttribute("result", result);
		return "adminNoticeDeletePro";
	}


}
