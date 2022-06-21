package com.oracle.S20220602.pch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.pch.service.SearchItemPaging;
import com.oracle.S20220602.pch.service.SearchService;

@Controller
public class SearchController {
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private SearchService ss;
	
	
	@RequestMapping(value = "/searchList")
	public String search(Item item, Common common, String currentPage, Model model) {
		logger.info("SearchController Start search 조회  ...");
		
		int total 	= ss.totalItemKeyword(item);
		
		System.out.println("SearchController item.getKeyword()=>" + item.getKeyword());
		System.out.println("SearchController total1=>" + total);
		
		SearchItemPaging   si = new SearchItemPaging(total, currentPage);
		
		item.setStart(si.getStart());
		item.setEnd(si.getEnd());
		
		System.out.println("SearchController si.getTotal=>" + si.getTotal());
		System.out.println("SearchController si.getStart()=>" + si.getStart());
		List<Item> 	 listItemKeyword   = ss.listItemKeyword(item);
		List<Common> listCommon 	   = ss.listCommon(common);
		List<Common> listCartegori	   = ss.listCartegori(common);
		
		System.out.println("SearchController list listItemKeyword ->"  	+ listItemKeyword.size());
		
		model.addAttribute("listItem", 	 listItemKeyword);
		model.addAttribute("listCommon", listCommon);
		model.addAttribute("listCartegori", listCartegori);
		model.addAttribute("cartegori", item.getCartegori());
		model.addAttribute("area", item.getArea());
		model.addAttribute("value", item.getValue());
		model.addAttribute("keyword", 	item.getKeyword());
		model.addAttribute("si", si);
		
		return "searchList";
	}
	
	
	
}





















