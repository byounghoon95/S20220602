package com.oracle.S20220602.pjh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Reservation;
import com.oracle.S20220602.lbh.service.Paging;
import com.oracle.S20220602.pjh.service.ReservationService;

;

@Controller
public class ReservationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService rs;
	
	
	 @GetMapping("/reservationList")
	 public String reservationList(Reservation reser, String currentPage, Model model, Item item, HttpServletRequest request) {
		 System.out.println("ReservationController list Start..");
		 int total = rs.total();
		 System.out.println("ReservationController total - >"+ total);
		 
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setSessionId(id);
		System.out.println("ReservationController reservationList id->"+id);
		 
		 List<Item> reserItemList = rs.reserSelect(item);
		 
		 
//		 for(Item rItem : reserItemList) {
//			 System.out.println("ReservationController rItem.getItemtitle()->"+ rItem.getItemtitle());
//			 System.out.println("ReservationController rItem.getContent()->"+ rItem.getContent());
//			 System.out.println("ReservationController rItem.getItemcost()->"+ rItem.getItemcost());
//		 }
		
		 System.out.println("ReservationController reservItemList.size()"+ reserItemList.size());
		 
		 model.addAttribute("reservationList", reserItemList);
		 
		 model.addAttribute("total",total);
		 
		 return "reservationList";
	 }

	@GetMapping("/reservationDetail")
	public String reservatoinDetail(int itemno, Model model) {
		System.out.println("ReservationController Detail Start");
		Reservation reserItem=null;
		reserItem = rs.reservationDetail(itemno);
		System.out.println("ReservationDetail itemno");
		model.addAttribute("reseritem", reserItem);
		
		return "reservationDetail";
	}
	//reservation등록
		@GetMapping("/reservation")
		public String Reservation(Reservation reser, Model model, HttpServletRequest request ) {
			System.out.println("Reservation 등록Start...");
			int itemno = 2;
			//getItemno를 
			reser.setItemno(itemno);
			
//			HttpSession session = request.getSession();
//			String id = (String) session.getAttribute("id");
			String id = "kanghj";
			reser.setSessionId(id);
			
			int result = rs.reservation(reser);
			model.addAttribute("result", result);
			
			System.out.println("itemno  "+ reser.getItemno());
			System.out.println("id  "+ reser.getId());
			System.out.println("Resdate  "+ reser.getResdate());
			System.out.println("Restime  "+ reser.getRestime());
			System.out.println("Resloc  "+ reser.getResloc());
			System.out.println("Dealcontent  "+ reser.getDealcontent());
			System.out.println("Score  "+ reser.getScore());
			System.out.println("Bcd  "+ reser.getBcd());
			System.out.println("Mcd  "+ reser.getMcd()) ;
			
			return "reservation";
			
		}
	//reservation 수정form 문
		@GetMapping(value="reservationUpdateForm")
		public String updateForm(Model model, Reservation reser) {
			System.out.println("ReservationController UpdateStart...");
			System.out.println("resr.getItemno() -> " + reser.getItemno());
			reser = rs.reservationDetail(reser.getItemno());
			model.addAttribute("reser", reser);
			
			return "reservationUpdateForm";
		}
		
	//reservation update	
		@PostMapping(value="reservationUpdate")
		public String boardUpdate(Reservation reser, Model model, HttpServletRequest request) {
			System.out.println("ReservationController UpdateStart...");
			
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			reser.setSessionId(id);
			
			int itemno = reser.getItemno();
			int result = rs.reservationUpdate(reser);
			model.addAttribute("result", result);
			model.addAttribute("itemno", itemno);
			System.out.println("Itemno->" +reser.getItemno());
			
			
			return "reservationUpdatePro";
		}
		@GetMapping(value="reservationDelete")
		public String reservationDelete(Reservation reser, Model model) {
			System.out.println("ReservationController reserDelete Start...");
			int result =rs.reservationDelete(reser);	
			model.addAttribute("result", result);

			return  "reservationDeletePro";
		}
	

}

