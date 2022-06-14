	package com.oracle.S20220602.kkh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.kkh.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@GetMapping("/memlogin")
	public String login(Model model) {
		
		return "memlogin";
	}
	
	@PostMapping("/memloginPro")
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
	@GetMapping("/memregisterForm")
	public String registerForm(Member member, Model model) {
		System.out.println("registerForm start..");
		return "memregisterForm";
	}
	@GetMapping("/memregister")
	public String register(Member member, Model model) {
		System.out.println("register start..");
		int result = ms.register(member);
		
		
		return "memlogin";
	}
	@GetMapping("/memidcheck")
	public String idcheck(Member member, Model model) {
		System.out.println("register start..");
		int result = ms.register(member);
		
		
		return "memlogin";
	}
	
	@GetMapping("/memlogout")
	public String memlogout(HttpServletRequest request, Member member, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "memlogout";
	}
	
}
