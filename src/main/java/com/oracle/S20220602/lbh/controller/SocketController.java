package com.oracle.S20220602.lbh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocketController {
	@RequestMapping("/chat")
	public ModelAndView chat() {
		System.out.println("SocketController chat Start...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		return mv;
	}

}
