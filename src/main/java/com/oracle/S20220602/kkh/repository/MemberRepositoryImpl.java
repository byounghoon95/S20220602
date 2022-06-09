package com.oracle.S20220602.kkh.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Member;
@Repository
public class MemberRepositoryImpl implements MemberRepository {
	
	@Autowired
	private SqlSession		session;
	
	@Override
	public Member memberLogin(String id) {
		Member member = null;
		System.out.println("MemberRepositoryImpl memberLogin start");
		try {
			member = session.selectOne("kkhGetIdPass",id);
			System.out.println("BoardRepositoryImpl id -> " + member.getId());
			System.out.println("BoardRepositoryImpl pw -> " + member.getPw());
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl memberLogin exception-> " + e.getMessage());
		}
		return member;
	}
}
