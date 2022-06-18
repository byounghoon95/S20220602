package com.oracle.S20220602.common.domain;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
	//Reservation
	private int itemno;
	private String id;
	private String resdate;
	private String restime;
	private String resloc;
	private String dealcontent;
	private int score;
	private int bcd;
	private int mcd;
	private int sbcd;
	private int smcd;
	//item
	private String itemtitle;
	private int itemcost;
	private int itemview;
	private int itemwish;
	private String itemimg1;
	
	//common
	private String content;
	
	//session id
	private String sessionId;
	
	//후기에 가져올 닉네임
	private String nickname;
	
	private String search;   	private String keyword;
	private String pageNum;  
	private int start; 		 	private int end;
}
