package com.oracle.S20220602.khj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.common.domain.Reservation;
import com.oracle.S20220602.khj.service.MypageService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageService ms;
	
	// 마이페이지
//	@GetMapping("/mypage")
	@RequestMapping(value = "/mypage")
	public String mypage(Model model, HttpServletRequest request, Member member) {
		System.out.println("MypageController mypage Start...");
		String id = null;
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		
		String memberLocName = ms.memberLocNameSelect(id);
		member = ms.memberMypage(id);
		model.addAttribute("member", member);
		model.addAttribute("memberLocName", memberLocName);
		return "mypage";
	}
	

	
	// 프로필 수정폼 이미지x 버전
//	@GetMapping("/mypagePrfUpdate")
//	public String mypagePrfUpdate(HttpServletRequest request, Model model, Member member) {
//		System.out.println("MypageController mypagePrfUpdate Start...");
//		// 세션에서 id 가져오기
//		HttpSession session = request.getSession();
//		String id = (String) session.getAttribute("id");
//		member = ms.memberMypage(id);
//		model.addAttribute("member", member);
//		
//		//지역 리스트
//		List<Common> selectLoc = ms.selectLocList();
//		model.addAttribute("locList", selectLoc);
//		
//		return "mypagePrfUpdate";
//	}
//	
//	@PostMapping("/mypagePrfUpdatePro")
//	public String mypagePrfUpdatePro(HttpServletRequest request, Model model, Member member) {
//		System.out.println("MypageController mypagePrfUpdatePro Start...");
//		// 세션에서 id 가져오기
//		HttpSession session = request.getSession();
//		String id = (String) session.getAttribute("id");
//		member.setId(id);
//		
//		int result = ms.mypagePrfUpdate(member); 
//		model.addAttribute("result", result);
//		
////		member = ms.mypagePrfUpdate(id);
//		model.addAttribute("member", member);
//		return "forward:mypage";
//	}
	
	
	
	
	// 프로필 수정 이미지 포함
	
	  @GetMapping("/mypagePrfUpdate") public String
	  mypagePrfUpdate(HttpServletRequest request, Model model, Member member,
	  MultipartFile file1) throws IOException, Exception {
	  System.out.println("MypageController mypagePrfUpdate Start..."); 
	  
	  // 세션에서 id 가져오기 
	  HttpSession session = request.getSession(); 
	  String id = (String) session.getAttribute("id"); 
	  member = ms.memberMypage(id);
	  model.addAttribute("member", member); 
	  
	  // 지역명 리스트
	  List<Common> selectLoc = ms.selectLocList();
	  model.addAttribute("locList", selectLoc);
	  
	  // 프로필 사진 업로드
	  String uploadPath = request.getSession().getServletContext().getRealPath("/itemImgs/");
      
      System.out.println("uploadForm POST Start");
      String savedName1 = uploadFile(file1.getOriginalFilename(), file1.getBytes(),uploadPath); //실질적으로 뿌려주는 것
      //                           적어준 파일명 그대로 가져감     파일의 내용(바이트단위로)을 어레이로 리턴해줌
      
      logger.info("savedName1: "+ savedName1);
      model.addAttribute("savedName1", savedName1);
      return "mypagePrfUpdate";
	  }
	  
	  
//	  @PostMapping("createOpenChat")
//	   public ModelAndView createOpenChat(Chatting chatting, HttpServletRequest request, MultipartFile file) throws Exception {
//	      System.out.println("ChattingController createOpenChat Start... ");
//	      ModelAndView mv = new ModelAndView();
//	      String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
////	      logger.info(file.getOriginalFilename());
//	      
//	      System.out.println(file.getOriginalFilename());
//	      System.out.println(file.getBytes());
//	      System.out.println("createOpenChat upload POST Start");
//	      String user_id = request.getSession().getAttribute("sessionId").toString();
//	      String savedName = "";
//	      System.out.println("createOpenChat file.getOriginalFilename()->"+file.getOriginalFilename());
//	      if(!file.getOriginalFilename().isEmpty()) {
//	          savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
//	      }
//	      else {
//	         savedName = "defaultChatImg.png";
//	      }
//	      System.out.println("savedName : "+savedName);
//	      chatting.setPic_change(savedName);
//	      chatting.setUser_id(user_id);
//	      cs.insert(chatting);
//	      cs.insertparticipant(chatting);
////	      mv.addObject("savedName", savedName);
//	      mv.setViewName("redirect:chat");
//	      return mv;
//	   }
	  
	  
	  
	  public String uploadFile(String originalFilename, byte[] fileData, String uploadPath) throws Exception {

	      UUID uid = UUID.randomUUID();
	      // requestPath = requestPath + "/resources/image";
	      System.out.println("uploadPath -> "+ uploadPath);
	      // directory 생성
	      File fileDirectory = new File(uploadPath);
	      if(!fileDirectory.exists()) {
	         fileDirectory.mkdir();
	         System.out.println("업로드용 폴더 생상함 : "+ uploadPath);
	      }
	      System.out.println("originalFilename -> "+originalFilename);
	      String savedName = "";
	      File target = null;
	      savedName = uid.toString()+"_"+originalFilename;
	      logger.info("savedName -> " + savedName);
	      target = new File(uploadPath, savedName);
	      FileCopyUtils.copy(fileData, target);
	      return savedName;
	   }
	  
	  
	
	@PostMapping("/mypagePrfUpdatePro")
	public String mypagePrfUpdatePro(HttpServletRequest request, Model model, Member member) {
		System.out.println("MypageController mypagePrfUpdatePro Start...");
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		member.setId(id);
		
		int result = ms.mypagePrfUpdate(member); 
		model.addAttribute("result", result);
		
//		member = ms.mypagePrfUpdate(id);
		model.addAttribute("member", member);
		return "forward:mypage";
	}
	
	
	
	
	// 내가 작성한 글 
	@GetMapping("/mypageBoard")
	public String mypageBoard(Model model, HttpServletRequest request, Board board) {
		System.out.println("MypageController mypageBoard Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		board.setId(id);
		
		List<Board> mypageBoardList = ms.mypageBoardSelect(board);
		
		System.out.println("MypageController mypageBoardList boardList.size()->"+mypageBoardList.size());
		
		model.addAttribute("mypageBoardList", mypageBoardList);
		
		return "mypageBoard";
	}
	
	// 관심상품
	@GetMapping("/mypageWish")
	public String mypageWish(Model model, HttpServletRequest request, Item item) {
		System.out.println("MypageController mypageWish Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		
		List<Item> mypageWishList = ms.mypageWishList(item);
		System.out.println("MypageController mypageWish mypageWishList.size()-> "+mypageWishList.size());
		
//		데이터를 잘 가져왔는지 확인하는 방법
//		for(Item item2 : mypageWishList ) {
//			System.out.println("item2.getItemno()->"+item2.getItemno());
//			System.out.println("item2.getId()->"+item2.getId());
//		}
		model.addAttribute("mypageWishList", mypageWishList);
		
		return "mypageWish";
	}
	
	// 구매/판매내역
	@GetMapping("/mypageDeal")
	public String mypageDeal(Model model, HttpServletRequest request, Item item) {
		System.out.println("MypageController mypageDeal Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		
		List<Item> mypageBuyList = ms.mypageBuyList(item);
		List<Item> mypageSellList = ms.mypageSellList(item);
		System.out.println("MypageController mypageDeal mypageBuyList.size()->"+mypageBuyList.size());
		System.out.println("MypageController mypageDeal mypageSellList.size()->"+mypageSellList.size());
		model.addAttribute("mypageBuyList", mypageBuyList);
		model.addAttribute("mypageSellList", mypageSellList);
		
		return "mypageDeal";
	}
	
	// 가계부
	@GetMapping("/mypageBank")
	public String mypageBank(Model model, HttpServletRequest request, Item item) {
		System.out.println("MypageController mypageBank Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		
		int totalSellCount =  ms.totalSellCount(item);
		int totalSellCost =  ms.totalSellCost(item);
		model.addAttribute("totalSellCount", totalSellCount);
		model.addAttribute("totalSellCost", totalSellCost);
		
		return "mypageBank";
	}
	
	// 받은 후기
	@GetMapping("/mypageComment")
	public String mypageComment(Model model, HttpServletRequest request, Reservation reservation) {
		System.out.println("MypageController mypageComment Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		reservation.setSessionId(id);
		
		List<Reservation> mypageCommentList = ms.mypageCommentSelect(reservation);
		model.addAttribute("mypageCommentList", mypageCommentList);
		
		return "mypageComment";
	}
	
	
	@GetMapping("/mypageOther")
	public String mypageOther(Model model, HttpServletRequest request, Member member) {
		System.out.println("MypageController mypage Start...");
		String id = "kimjh";
		
		model.addAttribute("id", id);
		
		String memberLocName = ms.memberLocNameSelect(id);
		member = ms.memberMypage(id);
		model.addAttribute("member", member);
		model.addAttribute("memberLocName", memberLocName);
		return "mypageOther";
	}
	
	
	
	// 남의 글 보기
	@GetMapping("/mypageOtherBoard")
	public String mypageOtherBoard(Model model, Board board) {
		
		System.out.println("MypageController mypageBoard Start...");
		
		String id = "kimjh";
		board.setId(id);
		
		List<Board> mypageBoardList = ms.mypageBoardSelect(board);
		System.out.println("MypageController mypageBoardList boardList.size()->"+mypageBoardList.size());
		
		model.addAttribute("mypageBoardList", mypageBoardList);
		
		return "mypageOtherBoard";
	}
	
	
	// 남의 판매내역
		@GetMapping("/mypageOtherDeal")
		public String mypageDeal(Model model, Item item) {
			System.out.println("MypageController mypageOtherDeal Start...");
			
			String id = "kimjh";
			item.setId(id);
			
			List<Item> mypageSellList = ms.mypageSellList(item);
			System.out.println("MypageController mypageDeal mypageSellList.size()->"+mypageSellList.size());
			model.addAttribute("mypageSellList", mypageSellList);
			
			return "mypageOtherDeal";
		}
		
		// 남의 후기
		@GetMapping("/mypageOtherComment")
		public String mypageOtherComment(Model model, HttpServletRequest request, Reservation reservation) {
			System.out.println("MypageController mypageOtherComment Start...");
			
			String id = "parkch";
			reservation.setSessionId(id);
			
			List<Reservation> mypageOtherCommentList = ms.mypageCommentSelect(reservation);
			model.addAttribute("mypageOtherCommentList", mypageOtherCommentList);
			
			return "mypageOtherComment";
		}
	
	
}
