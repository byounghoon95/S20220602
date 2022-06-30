package com.oracle.S20220602.common.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	 //Item
	 private int itemno;
	 private String id;
	 private String itemtitle;
	 private int itemcost;
	 private String itemcontent;
	 private Date itemdate;
	 private int itemview;
	 private int itemwish;
	 private String itemwarnstatus;
	 private String itemimg1;
	 private String itemimg2;
	 private String itemimg3;
	 private String itemimg4;
	 private String itemimg5;
	 private int bcd;
	 private int mcd;
	 
	 //MEMBER 버퍼
	 private String nickname;
	 private String name;
	 private String pw;
	 private String email;
	 private String phone;
	 private int locno;
	 private String userimg;
	 private Date joindate;
	 private int participation;
	 private int warningcnt;
	 
	 //COMMON 버퍼(카테고리 조회)
	 private String content;
	 
	//조회용
	private String search;   	private String keyword;
	private String pageNum;  
	private int start; 		 	private int end;
	
	// 거래테이블 조인
	private String dealcontent;
	private String resloc;
	
	// 세션아이디
	private String sessionId;
 
}