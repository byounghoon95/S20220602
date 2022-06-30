package com.oracle.S20220602.common.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminList11 {
		private int inqno;
		private String id;
		private String inqtitle;
		private String inqcontent;
		private Date inqdate;
		private String inqstatus;
		private int ref;
		private int ref_step;
		private int ref_level;
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
		private int replycnt;
		
		// 조회용
		private String search;   	private String keyword;
		private String pageNum;  
		private int start; 		 	private int end;

		//session id
		private String sessionId;
}
