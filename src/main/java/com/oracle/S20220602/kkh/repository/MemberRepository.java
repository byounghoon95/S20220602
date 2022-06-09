package com.oracle.S20220602.kkh.repository;


import com.oracle.S20220602.common.domain.Member;

public interface MemberRepository {
	Member memberLogin(String id);
	
}
