package com.oracle.S20220602.common.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warning {
	//Warning
	private int reportno;
	private String id;
	private String warnid;
	private int itemno;
	private int boardno;
	private String reportcontent;
	private String reportimg;
	private Date reportdate;
	private String reportstatus;
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
	 
	 //조회용 버퍼
	 private String content;
	
}
