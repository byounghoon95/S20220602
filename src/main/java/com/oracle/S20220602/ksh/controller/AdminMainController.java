package com.oracle.S20220602.ksh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.S20220602.common.domain.Member;

@Controller
public class AdminMainController {
	@RequestMapping("/adminMain")
	public String adminMain(Model model) {
		model.addAttribute("data", "안녕하세요");
		return "adminMain";
	}
	

}
