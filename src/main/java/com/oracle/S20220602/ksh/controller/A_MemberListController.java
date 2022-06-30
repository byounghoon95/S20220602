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

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.ksh.service.A_MemberListService;
import com.oracle.S20220602.ksh.service.Paging;



@Controller
public class A_MemberListController {
	private static final Logger logger = LoggerFactory.getLogger(A_MemberListController.class);

	@Autowired
	private A_MemberListService ms; // 서비스랑 연결
	
	//멤버 목록
	@RequestMapping(value = "A_Mlist")
	public String list(Member member, String currentPage, Model model) {
		logger.info("A_MemberListControllert list...");

		int total = ms.total();
		System.out.println("A_MemberListController total=>" + total);
		Paging pg = new Paging(total, currentPage);
		member.setStart(pg.getStart());
		member.setEnd(pg.getEnd());
		List<Member> listMember = ms.listMember(member);
		System.out.println("A_MemberListController member listMember.size()->" + listMember.size());
		model.addAttribute("listMember", listMember);
		model.addAttribute("pg", pg);
		model.addAttribute("total", total);
		return "A_Mlist";

	}
	//멤버 세부사항
	@GetMapping(value="A_Mdetail")
	public String detail(String id, Model model) {
		System.out.println("A_MemberListController Start detail..." );
		System.out.println("A_MemberListController A_Mdetail id->"+id );
		Member member = ms.detail(id);
		
		model.addAttribute("member",member);
		
		
		return "A_Mdetail";
	}
	//멤버 수정
	@GetMapping(value="A_MupdateForm")
	public String updateForm(String id, Model model, Common common) {
		System.out.println("A_MemberListController Start updateForm..." );
		Member member = ms.detail(id);
		//멤버상태리스트
		List<Common> memberStatusList = ms.StatusList(common);
		System.out.println("A_MemberListController A_MupdateForm +member.getContent()->"+member.getContent());
		
		model.addAttribute("member",member);
		model.addAttribute("memberStatusList",memberStatusList);
		return "A_MupdateForm";
	}
	
	
	  @PostMapping(value="update")
	  public String update(Member member, Model model){
		  int uptCnt = ms.update(member); 
		  ms.update(member); 
		  System.out.println("Controller ms.update(member) Count-->"+uptCnt);
		  model.addAttribute("uptCnt",uptCnt); 
		  model.addAttribute("kk3","Message Test"); 
		  return "forward:A_Mlist"; 
	  
	  }
	  
		//멤버 탈퇴
		 @GetMapping(value="delete") 
		  public String delete(Member member, Model model) {
		  System.out.println("A_MemberListController delete Start..."); 
		  int result = ms.delete(member); 
		  model.addAttribute("result", result);
		  return "A_MdeletePro";
		  }
		 
		
	 //멤버 검색
	 @RequestMapping(value="A_Mkeyword")
	 public String A_Mkeyword(Member member, String currentPage, Model model) {
		 logger.info("A_MemberListControllert A_Mkeyword 키워드검색...");
		 	
		 	int total = ms.totalKeyword(member);
			System.out.println("A_MemberListController total=>" + total);
			Paging pg = new Paging(total, currentPage);
			member.setStart(pg.getStart());
			member.setEnd(pg.getEnd());
			List<Member> A_Mkeyword = ms.A_Mkeyword(member);
			System.out.println("A_MemberListController member listMember.size()->" + A_Mkeyword.size());
			model.addAttribute("listMember", A_Mkeyword);//listMember와 같은뷰를 쓰기위해  사용
			model.addAttribute("pg", pg);
			model.addAttribute("total", total);
			model.addAttribute("keyword", member.getKeyword());
			return "A_Mkeyword";
	 }
	 
	 	
		
		
	

}