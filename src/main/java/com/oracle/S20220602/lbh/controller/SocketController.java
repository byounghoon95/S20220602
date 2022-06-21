package com.oracle.S20220602.lbh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.S20220602.common.domain.Member;

@Controller
public class SocketController {
	@RequestMapping("/chat")
	public ModelAndView chat(Member member) {
		System.out.println("SocketController chat Start...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		mv.addObject("member",member);
		return mv;
	}

}
