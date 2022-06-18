package com.oracle.S20220602.kkh.service;

import java.util.List;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;

public interface MemberService {
	Member memberLogin(String id);
	int register(Member member);
	int idCheck(Member member);
	List<Common> selectLocList();
	Member memberSelect(Member member);
	Member EmailChk(Member member);
	void updateTempPw(Member dbmember);
	Member memberSelectOne(Member member);
	
}
