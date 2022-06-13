package com.oracle.S20220602.kkh.service;


import com.oracle.S20220602.common.domain.Member;

public interface MemberService {
	Member memberLogin(String id);
	int register(Member member);
	
}
