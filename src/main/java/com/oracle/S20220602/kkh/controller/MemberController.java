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
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "login";
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
		model.addAttribute("input_id", input_id);
		model.addAttribute("input_pw", input_pw);
		model.addAttribute("member", member);
		return "loginPro";
	}
	@GetMapping("/registerForm")
	public String registerForm(Member member, Model model) {
		System.out.println("registerForm start..");
		return "registerForm";
	}
	@GetMapping("/register")
	public String register(Member member, Model model) {
		System.out.println("register start..");
		int result = ms.register(member);
		
		
		
		
		return "login";
	}
	@GetMapping("/idcheck")
	public String idcheck(Member member, Model model) {
		System.out.println("register start..");
		int result = ms.register(member);
		
		
		
		
		return "login";
	}
	
}
