package com.oracle.S20220602.kkh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Member;
import com.oracle.S20220602.kkh.repository.MemberRepository;
@Service
public class MemberServiceImpl implements MemberService {

	
	private final MemberRepository memberRepository;
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public Member memberLogin(String id) {
		System.out.println("MemberServiceImpl memberLogin start");
		Member member = memberRepository.memberLogin(id);
		
		return member;
	}

	@Override
	public int register(Member member) {
		System.out.println("MemberServiceImpl register start");
		int result = memberRepository.register(member);
		return result;
	}
}
