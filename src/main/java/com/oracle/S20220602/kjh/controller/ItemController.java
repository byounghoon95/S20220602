package com.oracle.S20220602.kjh.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Warning;
import com.oracle.S20220602.kjh.service.ItemService;


@Controller
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired // 서비스
	private ItemService is;
	
	//내 물건 팔기 클릭 후 상품 등록 페이지로 이동
	@GetMapping("/itemRegForm")
	public String itemRegForm(HttpServletRequest request, String id, Model model) {
		System.out.println("ItemController itemRegForm Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
				
		List<Common> itemCategoryList = is.itemCategorySelect();
		String memberLocName = is.memberLocNameSelect(id);
		model.addAttribute("itemCategoryList",itemCategoryList);
		model.addAttribute("memberLocName",memberLocName);
		model.addAttribute("id",id);
		
		return "itemRegForm";
	}
	
	//상품 등록
	@PostMapping("/itemReg")
	public String itemReg(Item item, Model model, HttpServletRequest request, MultipartFile file1,
			MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5 ) throws Exception{
		System.out.println("ItemController itemReg Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		model.addAttribute("id", id);
		
		//사진 업로드
		System.out.println("ItemController itemReg imgUpload Start...");
		String uploadPath = request.getSession().getServletContext().getRealPath("/itemImgs/");
		logger.info("originalName: "+file1.getOriginalFilename());
		logger.info("originalName: "+file2.getOriginalFilename());
		logger.info("size: "+file1.getSize());
		logger.info("size: "+file2.getSize());
		logger.info("contentType: "+file1.getContentType());
		logger.info("contentType: "+file2.getContentType());
		logger.info("uploadPath: "+uploadPath);
		
		//file input시 입력된 값만 UUID 지정해주기 
		List<MultipartFile> itemimglist = new ArrayList<MultipartFile>();
		itemimglist.add(file1);
		itemimglist.add(file2);
		itemimglist.add(file3);
		itemimglist.add(file4);
		itemimglist.add(file5);
		List<String> UUIDlist = new ArrayList<String>();
		for (int i = 0; i < itemimglist.size(); i++) {
			if(!itemimglist.get(i).getOriginalFilename().equals("")) {
				UUIDlist.add(uploadFile(itemimglist.get(i).getOriginalFilename(), itemimglist.get(i).getBytes(),uploadPath));
			}else if(itemimglist.get(i).getOriginalFilename().equals("")) {
				UUIDlist.add(""); //input된 file값이 없을 시, DB null이 되도록 처리.
			}
		}
	    item.setItemimg1(UUIDlist.get(0));
	    item.setItemimg2(UUIDlist.get(1));
	    item.setItemimg3(UUIDlist.get(2));
	    item.setItemimg4(UUIDlist.get(3));
	    item.setItemimg5(UUIDlist.get(4));
	    
	    //textarea로 받은값 개행처리
	    String itemcontent = request.getParameter("itemcontent").replaceAll("\r\n", "<br/>");
	    item.setItemcontent(itemcontent);
	    System.out.println(itemcontent);
	    //상품 등록
		int result = is.itemReg(item);
		model.addAttribute("result",result);
		return "itemRegPro";
	}
	
	//사진 업로드 UUID 
	public String uploadFile(String originalFilename, byte[] fileData, String uploadPath) throws Exception {

	      UUID uid = UUID.randomUUID();
	      // requestPath = requestPath + "/resources/image";
	      System.out.println("uploadPath -> "+ uploadPath);
	      // directory 생성
	      File fileDirectory = new File(uploadPath);
	      if(!fileDirectory.exists()) {
	         fileDirectory.mkdir();
	         System.out.println("업로드용 폴더 생성함 : "+ uploadPath);
	      }
	      System.out.println("originalFilename -> "+originalFilename);
	      String savedName = "";
	      savedName = uid.toString()+"_"+originalFilename;
	      File target = null;
	      target = new File(uploadPath, savedName);
	      logger.info("savedName -> " + savedName);
	      FileCopyUtils.copy(fileData, target);
	      return savedName;
	   }
	
	//상품 상세페이지
	@GetMapping("/itemDetail")
	public String itemDetail(HttpServletRequest request, Item item, Model model) {
		System.out.println("ItemController itemDetail Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setSessionId(id);
		model.addAttribute("id", id);
		
		System.out.println("ItemController itemDetail itemno->"+ item.getItemno());
		System.out.println("ItemController itemDetail sessionId->"+ id);
		
		
		//판매자의 지역
		String locname =is.locName(item);
		//판매자의 다른 판매 내역 리스트
		List<Item> sellerItemList = is.sellerItemList(item);
		//해당 상품의 상세 정보
		Item itemDetail= is.itemDetail(item);
		//해당 상품의 이미지 리스트
		List<String> imgList = new ArrayList<String>();
		imgList.add(itemDetail.getItemimg1());
		imgList.add(itemDetail.getItemimg2());
		imgList.add(itemDetail.getItemimg3());
		imgList.add(itemDetail.getItemimg4());
		imgList.add(itemDetail.getItemimg5());
		for(int i = 0; i < imgList.size(); i++) {
			System.out.println("imgList -> " + imgList.get(i));
		}
		System.out.println("imgList -> " + imgList.size());
		//로그인 아이디의 관심담기 여부 확인			관심담기 이미o->1 , 관심담기 x -> 0
		int wishCheck = is.wishCheck(item);
		//판매 현황
		String resstat = is.resStat(item);
		System.out.println("ItemController itemDetail resstat->"+ resstat);
		
		model.addAttribute("imgList", imgList);
		model.addAttribute("itemDetail", itemDetail);
		model.addAttribute("locname",locname);
		model.addAttribute("sellerItemList",sellerItemList);
		model.addAttribute("wishCheck",wishCheck);
		model.addAttribute("resstat",resstat);
		return "itemDetail";
	}
	
	//채팅하기 클릭시 채팅창으로 이동
	@GetMapping("/chat")
	public String chat(HttpServletRequest request, Item item, Model model) {
		System.out.println("ItemController chat Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		
		System.out.println("ItemController chat itemno->"+ item.getItemno());
		//해당 상품의 상세 정보
		Item itemDetail= is.itemDetail(item);
		model.addAttribute("itemDetail", itemDetail);
		return "chat";
	}
	
	//상품 수정페이지
	@GetMapping("/itemUpdateForm")
	public String itemUpdateForm(HttpServletRequest request, Item item, String id, Model model) {
		System.out.println("ItemController itemUpdateForm Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		id = (String) session.getAttribute("id");
		item.setId(id);
		model.addAttribute("id", id);
		
		System.out.println("ItemController itemUpdateForm itemno->"+ item.getItemno());
		//해당 상품의 기존 정보
		Item itemDetail= is.itemDetail(item);
		List<Common> itemCategoryList = is.itemCategorySelect();
		String memberLocName = is.memberLocNameSelect(id);
		
		model.addAttribute("itemDetail", itemDetail);
		model.addAttribute("itemCategoryList",itemCategoryList);
		model.addAttribute("memberLocName",memberLocName);
		return "itemUpdateForm";
	}
	
	//상품 수정 완료 페이지
	@PostMapping("/itemUpdate")
	public String itemUpdate(Item item, Model model, HttpServletRequest request, MultipartFile itemimg1)
			//MultipartFile itemimg2, MultipartFile itemimg3, MultipartFile itemimg4, MultipartFile itemimg5)
			throws Exception{
		System.out.println("ItemController itemUpdate Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		model.addAttribute("id", id);
		
		int result = is.itemUpdate(item);
		model.addAttribute("result",result);
		return "itemUpdatePro";
	}
	
	//상품 삭제 확인 페이지
	@GetMapping("/itemDeletePro")
	public String itemDeletePro(Item item, Warning warning, Model model, HttpServletRequest request)throws Exception{
		System.out.println("ItemController itemDeletePro Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setId(id);
		model.addAttribute("id", id);
		
		int result = is.itemDelete(item, warning);
		
		model.addAttribute("result",result);
		return "itemDeletePro";
	}
	
	//신고하기 클릭 시 신고하기 등록 페이지로 이동
	   @GetMapping("/warningForm")
	   public String reportForm(HttpServletRequest request, Warning warning, Model model) {
	      System.out.println("ItemController reportForm Start...");
	      
	      String result = null;
	      
	      // 세션에서 id 가져오기
	      HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("id");
	      warning.setId(id);
	      model.addAttribute("id", id);
	      
	      if(id != null) {
	    	  
	      System.out.println("warning.getId()->"+warning.getId());
	      System.out.println("warning.getWarnid()->"+warning.getWarnid());
	      System.out.println("warning.getItemno()->"+warning.getItemno());
	      System.out.println("warning.getBoardno()->"+warning.getBoardno());
	      //신고카테고리
	      List<Common> reportCategoryList = is.reportCategorySelect();
	      //신고받는 닉네임
	      String warnNickname = is.warnNicknameSelect(warning);
	      
	      model.addAttribute("reportCategoryList",reportCategoryList);
	      model.addAttribute("warnNickname",warnNickname);   
	      model.addAttribute("warning",warning);
	      
	      result = "warningForm";
	      
	      } else {
	    	  result = "redirect:login";
	      }
	    	  
    	  return result;
	   }
	   
	   //신고 등록
	   @PostMapping("/warningReg")
	   public String reportReg(Warning warning, Model model, HttpServletRequest request)
	         throws Exception{
	      System.out.println("ItemController warningReg Start...");
	      
	      // 세션에서 id 가져오기
	      HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("id");
	      warning.setId(id);
	      model.addAttribute("id", id);
	      
	      System.out.println("warning.getId()->"+warning.getId());
	      System.out.println("warning.getWarnid()->"+warning.getWarnid());
	      System.out.println("warning.getItemno()->"+warning.getItemno());
	      System.out.println("warning.getBoardno()->"+warning.getBoardno());
	      
	      warning.setWarnid(warning.getId());
	      
	      int smcd = 0;
	      
	      if(warning.getItemno() != 0) {
	         smcd = 801;
	      } else if(warning.getBoardno() != 0 ){
	         smcd = 802;
	      } else {
	         smcd = 803;
	      }
	      warning.setSmcd(smcd);
	      
	      int result = is.reportReg(warning);
	      
	      model.addAttribute("result",result);
	      return "warningPro";
	   }
	   @PostMapping("/changeHeart")
	   @ResponseBody
	   public int changeHeart(Item item) {
	      System.out.println("ItemController changeHeart Start...");
	      is.changeHeart(item);
	      
	      int wishCheck = is.wishCheck(item);
	      
	      return wishCheck;
	   }
	
	  //승혜
		@GetMapping("/A_itemDetail")
		public String itemDetail2(HttpServletRequest request, Item item, Model model) {
			System.out.println("ItemController itemDetail Start...");
			
			// 세션에서 id 가져오기
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			item.setId(id);
			model.addAttribute("id", id);
			
			System.out.println("ItemController itemDetail itemno->"+ item.getItemno());
			System.out.println("ItemController itemDetail sessionId->"+ item.getSessionId());
			
			
			//판매자의 지역
			String locname =is.locName(item);
			//판매자의 다른 판매 내역 리스트
			List<Item> sellerItemList = is.sellerItemList(item);
			//해당 상품의 상세 정보
			Item itemDetail= is.itemDetail(item);
			//해당 상품의 이미지 리스트
			List<String> imgList = new ArrayList<String>();
			imgList.add(itemDetail.getItemimg1());
			imgList.add(itemDetail.getItemimg2());
			imgList.add(itemDetail.getItemimg3());
			imgList.add(itemDetail.getItemimg4());
			imgList.add(itemDetail.getItemimg5());
			for(int i = 0; i < imgList.size(); i++) {
				System.out.println("imgList -> " + imgList.get(i));
			}
			System.out.println("imgList -> " + imgList.size());
			//로그인 아이디의 관심담기 여부 확인			관심담기 이미o->1 , 관심담기 x -> 0
			int wishCheck = is.wishCheck(item);
			
			model.addAttribute("imgList", imgList);
			model.addAttribute("itemDetail", itemDetail);
			model.addAttribute("locname",locname);
			model.addAttribute("item", item);
			model.addAttribute("sellerItemList",sellerItemList);
			model.addAttribute("wishCheck",wishCheck);
			return "A_itemDetail";
		}
		
		
		//상품 삭제 확인 페이지
		@GetMapping("/A_itemDeletePro")
		public String A_itemDeletePro(Item item, Warning warning, Model model, HttpServletRequest request)throws Exception{
			System.out.println("ItemController itemDeletePro Start...");
			
			// 세션에서 id 가져오기
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			item.setId(id);
			model.addAttribute("id", id);
			
			int result = is.itemDelete(item, warning);
			
			model.addAttribute("result",result);
			return "redirect:adminWarList";
		}
	
	
}