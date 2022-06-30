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
		member.setId(id);
		model.addAttribute("id", id);
		
		String memberLocName = ms.memberLocNameSelect(id);
		member = ms.memberMypage(member);
		model.addAttribute("member", member);
		model.addAttribute("memberLocName", memberLocName);
		return "mypage";
	}
	
	// 프로필 수정폼
	@PostMapping("/mypagePrfUpdate")
	public String mypagePrfUpdate(HttpServletRequest request, Model model, Member member) {
		System.out.println("MypageController mypagePrfUpdate Start...");
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		member = ms.memberMypage(id);
		model.addAttribute("member", member);
		
		//지역 리스트
		List<Common> selectLoc = ms.selectLocList();
		model.addAttribute("locList", selectLoc);
		
		return "mypagePrfUpdate";
	}
	
	@PostMapping("/mypagePrfUpdatePro")
	public String mypagePrfUpdatePro(HttpServletRequest request, Model model, Member member, MultipartFile file) throws IOException, Exception {
		System.out.println("MypageController mypagePrfUpdatePro Start...");
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		member.setId(id);
		
		//이미지 파일 첨부
		String uploadPath = request.getSession().getServletContext().getRealPath("/itemImgs/");
	    System.out.println("MypageController mypagePrfUpdatePro uploadForm POST Start");
	    String savedName = "";
	    String filename = file.getOriginalFilename();
	    System.out.println("MypageController mypagePrfUpdatePro file.getOriginalFilename()1->"+file.getOriginalFilename());
	    if(file.getSize() != 0) {
	    	System.out.println("MypageController mypagePrfUpdatePro file.getOriginalFilename()2->"+file.getOriginalFilename());
	        savedName = uploadFile(filename, file.getBytes(), uploadPath);
	        member.setUserImg(filename);
	        System.out.println("업데이트 된 사진--> " + member.getUserImg());
	    }
	    else {
	       savedName = member.getUserImg();
	    }
	    
	    System.out.println("MypageController mypagePrfUpdatePro savedName : "+savedName);
		
		int result = ms.mypagePrfUpdate(member); 
		
		model.addAttribute("result", result);
		model.addAttribute("member", member);
		model.addAttribute("savedName", savedName);
		return "forward:mypage";
	}
	  
	
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
	      //savedName = uid.toString()+"_"+originalFilename;
	      savedName = originalFilename;
	      logger.info("savedName -> " + savedName);
	      target = new File(uploadPath, savedName);
	      FileCopyUtils.copy(fileData, target);
	      return savedName;
	   }
	
	  // 프로필 사진 삭제
//	  @RequestMapping(value = "uploadFileDelete", method = RequestMethod.GET)
//      public String uploadFileDelete( HttpServletRequest request, Model model) throws Exception{
//         String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
//         String deleteFile = uploadPath + "e50d6470-7e0a-49f6-908c-edf88210c621_bonobono.png";
//         System.out.println("uploadFileDelete POST Start");
//         int delResult = upFileDelete(deleteFile);
//         model.addAttribute("deleteFile", deleteFile);
//         if(delResult == 1)   model.addAttribute("delResult", "1");
//         else               model.addAttribute("delResult", "0");
//        // model.addAttribute("delResult", delResult);
//         return "forward:mypagePrfUpdate";
//      }
//	  
//      private int upFileDelete(String deleteFileName) throws Exception{
//         int result = 0;
//            logger.info("upFileDelete result->"+deleteFileName);
//            File file = new File(deleteFileName);
//            if(file.exists()) {//파일이 존재할시
//               if(file.delete()) {//삭제가 성공하면 파일삭제 성공
//                  System.out.println("파일삭제 성공");
//                  result = 1;
//               }
//               else { //삭제가 실패하면 파일삭제 실패
//                  System.out.println("파일삭제 실패");
//                  result = 0;
//               }
//            }
//            else { //파일이 존재하지않으면,
//               System.out.println("파일이 존재하지 않습니다.");
//               result = -1;
//            }
//            return result;
//      } 
	  
	  
	  
	
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
	
	// 구매내역
	@GetMapping("/mypageDeal")
	public String mypageDeal(Model model, HttpServletRequest request, Item item) {
		System.out.println("MypageController mypageDeal Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		
		List<Item> mypageBuyList = ms.mypageBuyList(item);
		System.out.println("MypageController mypageDeal mypageBuyList.size()->"+mypageBuyList.size());
		model.addAttribute("mypageBuyList", mypageBuyList);
		
		return "mypageDeal";
	}
	//판매내역
	@GetMapping("/mypageDealSell")
	public String mypageDealSell(Model model, HttpServletRequest request, Item item) {
		System.out.println("MypageController mypageDeal Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		
		List<Item> mypageSellList = ms.mypageSellList(item);
		System.out.println("MypageController mypageDeal mypageSellList.size()->"+mypageSellList.size());
		model.addAttribute("mypageSellList", mypageSellList);
		
		List<Item> mypageSellList2 = ms.mypageSellList2(item);
		System.out.println("MypageController mypageDeal mypageSellList.size()->"+mypageSellList2.size());
		model.addAttribute("mypageSellList2", mypageSellList2);
		
		
		return "mypageDealSell";
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
//		String id = "kimjh";
		String id = member.getId();
		
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
		
		String id = board.getId();
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
			
			String id = item.getId();
			item.setId(id);
			
			List<Item> mypageOtherSellList = ms.mypageOtherSellList(item);
			System.out.println("MypageController mypageDeal mypageOtherSellList.size()->"+mypageOtherSellList.size());
			model.addAttribute("mypageOtherSellList", mypageOtherSellList);
			
			return "mypageOtherDeal";
		}
		
		// 남의 후기
		@GetMapping("/mypageOtherComment")
		public String mypageOtherComment(Model model, HttpServletRequest request, Reservation reservation) {
			System.out.println("MypageController mypageOtherComment Start...");
			
			String id = reservation.getId();
			reservation.setSessionId(id);
			
			List<Reservation> mypageOtherCommentList = ms.mypageCommentSelect(reservation);
			model.addAttribute("mypageOtherCommentList", mypageOtherCommentList);
			
			return "mypageOtherComment";
		}
	
	
}
