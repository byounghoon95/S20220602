package com.oracle.S20220602.common.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice {
		private int boardno;
		private String id;
		private String boardtitle;
		private String boardcontent;
		private Date boarddate;
		private int bcd;
		private int mcd;
		//fk 임시 버퍼
		private String nickname;
		private String name;
		private String pw;
		private String email;
		private String phone;
		private int locno;
		private String userImg;
		private Date joindate;
		private int participation;
		private int warningcnt;
		
		// 조회용
		private String search;   	private String keyword;
		private String pageNum;  
		private int start; 		 	private int end;
}
