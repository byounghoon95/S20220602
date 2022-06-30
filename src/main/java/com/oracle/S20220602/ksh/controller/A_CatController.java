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

import com.oracle.S20220602.common.domain.AdminNotice;
import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.ksh.service.A_CatService;
import com.oracle.S20220602.ksh.service.Paging;


	@Controller
	public class A_CatController {
		
		private static final Logger logger = LoggerFactory.getLogger(A_CatController.class);
		
		@Autowired
		private A_CatService cs; // 서비스랑 연결

		@RequestMapping(value = "adminCatList")
		public String list(Common common, String currentPage, Model model) {
			logger.info("A_CatController list...");

			int total = cs.total_1900();
			System.out.println("A_CatController total=>" + total);
			Paging pg = new Paging(total, currentPage);
			common.setStart(pg.getStart());
			common.setEnd(pg.getEnd());
			List<Common> listAcat = cs.listAcat(common);
			
			//Common Bcd값 뽑기
			Common commBcd900  = cs.commBcdSelect(900);
			Common commBcd1000 = cs.commBcdSelect(1000);
			
//			for (Common common3 : listAcat) {
//				System.out.println("A_CatController common common3.getBcd()->" + common3.getBcd());
//				System.out.println("A_CatController common common3.getMcd()->" + common3.getMcd());
//				System.out.println("A_CatController common common3.getContent()->" + common3.getContent());
//				
//			}
			
			System.out.println("A_CatController common listAcat.size()->" + listAcat.size());
			model.addAttribute("listAcat", listAcat);
			
			model.addAttribute("commBcd900", commBcd900);
			model.addAttribute("commBcd1000", commBcd1000);
			model.addAttribute("pg", pg);
			model.addAttribute("total", total);
			return "adminCatList";

		}
		
		@GetMapping("/adminCatWriteForm")
		public String adminCatWriteForm(Common common, Model model) {
			System.out.println("A_CatController adminCatWriteForm start..");
			List<Common> adminCatList = null;
			// 카테고리 리스트
			adminCatList = cs.CatList(common);
			System.out.println("adminCatList bcd -> " + adminCatList.get(0).getBcd());
			System.out.println("adminCatList bcd -> " + adminCatList.get(1).getBcd());
			model.addAttribute("adminCatList", adminCatList);
			return "adminCatWriteForm";
		}
		
		@PostMapping("/adminCatWrite")
		public String adminCatWrite(Common common, Model model) {
			System.out.println("A_CatController adminCatWrite Start..");
			System.out.println("adminCatWrite mcd -> " + common.getMcd());
			System.out.println("adminCatWrite bcd -> " + common.getBcd());
			int result = cs.adminCatWrite(common);
			System.out.println("adminCatWrite result -> " + result);
			model.addAttribute("result",result);
		
			return "forward:adminCatList";
	//		return "adminCatWritePro";

		}
		
		
}

