package com.oracle.S20220602.ksh.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;

public interface A_MemberListRepository {
	int total();
	List<Member> listMember(Member member);
	Member detail(String id);
	int update(Member member);
	List<Member> A_Mkeyword(Member member);
	int totalKeyword(Member member);
	int delete(Member member);
	List<Common> StatusList(Common common);
	
	
}
