package com.oracle.S20220602.kkh.repository;

import java.util.List;
import org.springframework.ui.Model;
import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;

public interface MemberRepository {
	Member memberLogin(String id);

	int register(Member member);

	int idCheck(Member member);

	List<Common> selectLocList();

	Member memberSelect(Member member);

//	Member adminLogin(String id);
	
}
