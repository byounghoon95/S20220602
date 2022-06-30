	package com.oracle.S20220602.kkh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.kkh.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "memlogin";
	}
	
	@PostMapping("/loginPro")
	public String loginPro(HttpServletRequest request, Member member, Model model) {
		System.out.println("loginPro start..");
		String input_id = member.getId();
		String input_pw = member.getPw();
		HttpSession session = request.getSession();
		session.setAttribute("id", input_id);
		System.out.println("input_id -> " + input_id);
		System.out.println("input_pw -> " + input_pw);
		member = ms.memberLogin(input_id);
		session.setAttribute("nickname", member.getNickname());
		model.addAttribute("input_id", input_id);
		model.addAttribute("input_pw", input_pw);
		model.addAttribute("member", member);
		return "memloginPro";
	}
	@GetMapping("/registerForm")
	public String registerForm(Member member, Model model) {
		System.out.println("MemberController registerForm start..");
		List<Common> selectLoc = ms.selectLocList();
		model.addAttribute("locList", selectLoc);
		return "memregisterForm";
	}
	@GetMapping("/register")
	public String register(Member member, Model model) {
		System.out.println("MemberController register start..");
		int result = ms.register(member);
		return "memlogin";
	}
	
	
	@PostMapping("/idCheck")
	@ResponseBody
	public String idcheck(Member member) {
		System.out.println("MemberController idCheck start..");
		String chk = "";
		int result = 0;
		if(member.getId().trim() == "") {
			chk = "none";
		}else {
			result = ms.idCheck(member);
			if(result == 1) {
				chk = "redundancy";
			}else if(result == 0) {
				chk = "noredundancy";
			}
		}
		return chk;
	}
	
	@GetMapping("/idFind")
	public String idFind(Model model) {

		return "memidFind";
	}

	@GetMapping("/idchk")
	@ResponseBody
	public Member idchk(Model model, Member member) {
		
		Member dbmember = ms.memberSelect(member);
		return dbmember;
	}
	
	@GetMapping("/pwForm")
	public String pwForm(Model model) {
		
		return "mempwForm";
	}
	@GetMapping("/pwFind")
	public String pwFind(Model model) {
		
		return "mempwFind";
	}
	
	
	//로그아웃
	@GetMapping("/logout")
	public String memlogout(HttpServletRequest request, Member member, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "memlogout";
	}
	
	//관리자
	@GetMapping("/adminlogin")
	public String adminlogin(Model model) {
		
		return "adminlogin";
	}
	
	@PostMapping("/adminloginPro")
	   public String adminloginPro(HttpServletRequest request, Member member, Model model) {
	      System.out.println("adminloginPro start..");
	      String input_id = member.getId();
	      String input_pw = member.getPw();
	      HttpSession session = request.getSession();
	      session.setAttribute("id", input_id);
	      System.out.println("input_id -> " + input_id);
	      System.out.println("input_pw -> " + input_pw);
	      member = ms.memberLogin(input_id);
//	      member = ms.adminChk(input_id);
	      session.setAttribute("nickname", member.getNickname());
	      model.addAttribute("input_id", input_id);
	      model.addAttribute("input_pw", input_pw);
	      model.addAttribute("member", member);
	      return "adminloginPro";
	   }
}
