package com.oracle.S20220602.lbh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.S20220602.lbh.service.BoardService;

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardService bs;
	
	
}
