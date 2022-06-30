package com.oracle.S20220602.ksh.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.common.domain.Warning;
import com.oracle.S20220602.ksh.service.A_WarningService;
import com.oracle.S20220602.ksh.service.Paging;
import com.oracle.S20220602.lbh.service.BoardService;

@Controller
public class A_WarningController {
	private static final Logger logger = LoggerFactory.getLogger(A_WarningController.class);
	@Autowired
	private A_WarningService ws; // 서비스랑 연결
	private BoardService bs;
	
	//신고 목록
		@RequestMapping(value = "adminWarList")
		public String list(Warning warning, String currentPage, Model model) {
			logger.info("A_WarListControllert list...");

			int total = ws.total();
			System.out.println("A_WarningController total=>" + total);
			Paging pg = new Paging(total, currentPage);
			warning.setStart(pg.getStart());
			warning.setEnd(pg.getEnd());
			
			List<Warning> listWarning = ws.listWarning(warning);
			System.out.println("A_WarningController listWarning.size()->" + listWarning.size());
			/*
			 * for (Warning warning2 : listWarning) {
			 * System.out.println("A_WarningController warning2.getWarnCatName()->" +
			 * warning2.getWarnCatName()); }
			 */
			
			model.addAttribute("listWarning", listWarning);
			model.addAttribute("pg", pg);
			model.addAttribute("total", total);
			return "adminWarList";
		}
		
		//신고 세부사항
		@GetMapping(value="adminWarDetail")
		public String detail(int warno, Model model) {
			System.out.println("A_WarningController Start detail..." );
			System.out.println("A_WarningController adminWarDetail warno->"+warno);
			Warning warning = ws.detail(warno);
			
			/*
			 * //신고 분류 이름 뽑기 메소드
			 *  Warning warnCatName=ws.warnCatNameSelect(warning);
			 * System.out.println("A_WarningController warnCatName->"+warnCatName);
			 */
			
			model.addAttribute("warning",warning);
			return "adminWarDetail";	
	}
		
	
	  @GetMapping(value="adminWarState") 
	  public String state(Warning warning, Model  model) {
		  System.out.println("A_WarningController state Start..." );
		  System.out.println("warning.getWarno->"+warning.getWarno()); 
			/* warning = ws.detail(warning.getWarno()); */
		  List<Warning> listWarning = ws.listWarning(warning);
		  
		  model.addAttribute("warning",warning);
		  model.addAttribute("listWarning", listWarning);
		  
		  return "adminWarState"; 
		  }
	 
		
	@PostMapping(value="wsupdate")
	 public String wsupdate(Warning warning, Model model){
			  System.out.println("A_WarningController wsupdate Start...");
			  
			  int result = ws.wsupdate(warning); 
			  model.addAttribute("result", result);
			  
			  return "forward:adminWarList"; 
		  
	}
	
	
	
	
	
	
}