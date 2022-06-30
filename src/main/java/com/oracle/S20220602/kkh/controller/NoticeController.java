package com.oracle.S20220602.kkh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.S20220602.common.domain.Notice;
import com.oracle.S20220602.kkh.service.NoticeService;
import com.oracle.S20220602.kkh.service.Paging;

@Controller
public class NoticeController {

		@Autowired
		private NoticeService ns;
		
		@GetMapping("/footer_notice")
		public String footer_notice(Notice notice,String currentPage, Model model) {
			System.out.println("NoticeController board Start...");
			int total = ns.total();
			System.out.println("NoticeController total ->" +total);
			Paging pg = new Paging(total, currentPage);
			notice.setStart(pg.getStart());
			notice.setEnd(pg.getEnd());
			List<Notice> noticeList = ns.noticeSelect(notice);
			System.out.println("NoticeController notice noticeList.size()->"+noticeList.size());
			
			model.addAttribute("noticeList", noticeList);
			model.addAttribute("pg", pg);
			model.addAttribute("total", total);
			return "footer_notice";
	}
		@GetMapping("/footer_noticeView")
		public String footer_noticeView(int boardno, Model model) {
			System.out.println("NoticeController noticeView Start..");
			Notice notice = null;
			notice = ns.noticeView(boardno);
			model.addAttribute("notice", notice);
			return "footer_noticeView";
		}

}
