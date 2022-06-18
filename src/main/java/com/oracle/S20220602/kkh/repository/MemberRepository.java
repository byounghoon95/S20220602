package com.oracle.S20220602.kkh.repository;


import java.util.List;


import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;

public interface MemberRepository {
	Member memberLogin(String id);

	int register(Member member);

	int idCheck(Member member);

	List<Common> selectLocList();

	Member memberSelect(Member member);

	Member emailChk(Member member);

	void updateTempPw(Member member);

	Member memberSelectOne(Member member);
}
