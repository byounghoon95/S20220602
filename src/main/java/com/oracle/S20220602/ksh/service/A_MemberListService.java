package com.oracle.S20220602.ksh.service;

import java.util.List;

import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.common.domain.Common;

public interface A_MemberListService {
	int total();
	List<Member> listMember(Member member);
	Member detail(String id);
	int update(Member member);
	List<Member> A_Mkeyword(Member member);
	int totalKeyword(Member member);
	int delete(Member member);
	List<Common> StatusList(Common common);
	
	
	
}
