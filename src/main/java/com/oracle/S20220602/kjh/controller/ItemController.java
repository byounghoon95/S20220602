package com.oracle.S20220602.kjh.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.S20220602.common.domain.Board;
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
	public String itemRegForm(String id, Model model) {
		System.out.println("ItemController itemRegForm Start...");
		List<Common> itemCategoryList = is.itemCategorySelect();
		String memberLocName = is.memberLocNameSelect(id);
		model.addAttribute("itemCategoryList",itemCategoryList);
		model.addAttribute("memberLocName",memberLocName);
		model.addAttribute("id",id);
		
		return "itemRegForm";
	}
	
	//중고물품 등록 // 사진 업로드
	@PostMapping("/itemReg")
	public String itemReg(Item item, Model model, HttpServletRequest request, MultipartFile itemimg1)
			//MultipartFile itemimg2, MultipartFile itemimg3, MultipartFile itemimg4, MultipartFile itemimg5)
			throws Exception{
		System.out.println("ItemController itemReg Start...");
		//사진 업로드
		/*
		 * String uploadPath =
		 * request.getSession().getServletContext().getRealPath("/upload/");
		 * System.out.println("ItemController itemReg uploadItemImg Start");
		 * logger.info("originalName: "+itemimg1.getOriginalFilename());
		 * logger.info("size: "+itemimg1.getSize());
		 * logger.info("contentType: "+itemimg1.getContentType());
		 * logger.info("uploadPath: "+uploadPath); String savedImgName1 =
		 * uploadItemImg(itemimg1.getOriginalFilename(),
		 * itemimg1.getBytes(),uploadPath);
		 *//*
		 * String savedImgName2 = uploadItemImg(itemimg2.getOriginalFilename(),
		 * itemimg2.getBytes(),uploadPath); String savedImgName3 =
		 * uploadItemImg(itemimg3.getOriginalFilename(),
		 * itemimg3.getBytes(),uploadPath); String savedImgName4 =
		 * uploadItemImg(itemimg4.getOriginalFilename(),
		 * itemimg4.getBytes(),uploadPath); String savedImgName5 =
		 * uploadItemImg(itemimg5.getOriginalFilename(),
		 * itemimg5.getBytes(),uploadPath);
		 */
		/*
		 * logger.info("savedImgName1: "+ savedImgName1);
		 * model.addAttribute("savedImgName1", savedImgName1);
		 */
		/*
		 * model.addAttribute("savedImgName2", savedImgName2);
		 * model.addAttribute("savedImgName3", savedImgName3);
		 * model.addAttribute("savedImgName4", savedImgName4);
		 * model.addAttribute("savedImgName5", savedImgName5);
		 */
		
		
		int result = is.itemReg(item);
		model.addAttribute("result",result);
		return "itemRegPro";
	}
	
	/*
	 * private String uploadItemImg(String originalName, byte[] fileData, String
	 * uploadPath) throws Exception{ UUID uid = UUID.randomUUID();
	 * System.out.println("uploadPath->"+uploadPath); // Directory 생성 File
	 * fileDirectory = new File(uploadPath); if(!fileDirectory.exists()) {
	 * fileDirectory.mkdirs(); System.out.println("업로드용 폴더 생성 : " + uploadPath); }
	 * String savedImgName1 = uid.toString() + "_" + originalName;
	 * 
	 * 
	 * logger.info("savedImgName1: " + savedImgName1); File target = new
	 * File(uploadPath, savedImgName1); FileCopyUtils.copy(fileData, target); return
	 * savedImgName1; }
	 */
	//상품 상세페이지
	@GetMapping("/itemDetail")
	public String itemDetail(Item item, Model model) {
		System.out.println("ItemController itemDetail Start...");
		System.out.println("ItemController itemDetail itemno->"+ item.getItemno());
		//해당 상품의 상세 정보
		Item itemDetail= is.itemDetail(item);
		//판매자의 지역
		String locname =is.locName(item);
		//판매자의 다른 판매 내역 리스트
		List<Item> sellerItemList = is.sellerItemList(item);
		//사용자의 관심담기 여부 확인
		int wishCheck = is.wishCheck(item);//관심담기 이미o->1 , 관심담기 x -> 0
		model.addAttribute("itemDetail", itemDetail);
		model.addAttribute("locname",locname);
		model.addAttribute("item", item);
		model.addAttribute("sellerItemList",sellerItemList);
		model.addAttribute("wishCheck",wishCheck);
		return "itemDetail";
	}
	
	//상품 수정페이지
	@GetMapping("/itemUpdateForm")
	public String itemUpdateForm(Item item, String id, Model model) {
		System.out.println("ItemController itemUpdateForm Start...");
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
		int result = is.itemUpdate(item);
		model.addAttribute("result",result);
		return "itemUpdatePro";
	}
	
	//상품 삭제 확인 페이지
	@GetMapping("/itemDeletePro")
	public String itemDeletePro(Item item, Model model, HttpServletRequest request)throws Exception{
		System.out.println("ItemController itemDeletePro Start...");
		int result = is.itemDelete(item);
		model.addAttribute("result",result);
		return "itemDeletePro";
	}
		
	/*
	 * @DeleteMapping("/itemDetail/{itemno}") public void
	 * itemDelete(@PathVariable("itemno") Item item) throws Exception{
	 * logger.info("itemDelete itemno: "+ item.getItemno()); is.itemDelete(item); }
	 */
	
	/*
	 * @GetMapping(value="itemDelete") public String itemDelete(Item item, Model
	 * model) { System.out.println("ItemController itemDelete Start..."); int result
	 * = is.itemDelete(item); model.addAttribute("result", result); return
	 * "itemDeletePro"; }
	 */
	//신고하기 클릭 시 신고하기 등록 페이지로 이동
	@GetMapping("/reportForm")
	public String reportForm(Warning warning, Model model) {
		System.out.println("ItemController reportForm Start...");
		System.out.println("ItemController reportReg Start...");
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
		
		return "reportForm";
	}
	
	//신고 등록
	@PostMapping("/reportReg")
	public String reportReg(Warning warning, Model model)
			throws Exception{
		System.out.println("ItemController reportReg Start...");
		System.out.println("warning.getId()->"+warning.getId());
		System.out.println("warning.getWarnid()->"+warning.getWarnid());
		System.out.println("warning.getItemno()->"+warning.getItemno());
		System.out.println("warning.getBoardno()->"+warning.getBoardno());
		int result = is.reportReg(warning);
		
		model.addAttribute("result",result);
		return "reportPro";
	}
	
	
	
	
}