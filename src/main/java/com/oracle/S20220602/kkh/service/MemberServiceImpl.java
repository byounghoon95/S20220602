package com.oracle.S20220602.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Common;
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

	@Override
	public int idCheck(Member member) {
		int result = 0;
		System.out.println("MemberServiceImpl idCehck start");
		result = memberRepository.idCheck(member);
		
		return result;
	}

	@Override
	public List<Common> selectLocList() {
		System.out.println("MemberServiceImpl selectLocList start");
		List<Common> selectLocList = memberRepository.selectLocList();
		return selectLocList;
	}

	@Override
	public Member memberSelect(Member member) {
		System.out.println("MemberServiceImpl memberSelect start");
		System.out.println("MemberServiceImpl memberSelect name -> " + member.getName());
		System.out.println("MemberServiceImpl memberSelect email -> " + member.getEmail());
		Member dbmember = memberRepository.memberSelect(member);
		
		return dbmember;
	}

	@Override
	public Member EmailChk(Member member) {
		System.out.println("MemberServiceImpl EmailChk start");
		Member dbmember = memberRepository.emailChk(member);
		return dbmember;
	}

	@Override
	public void updateTempPw(Member member) {
		System.out.println("MemberServiceImpl updateTempPw start");
		memberRepository.updateTempPw(member);
		
	}

	@Override
	public Member memberSelectOne(Member member) {
		System.out.println("MemberServiceImpl memberSelectOne start");
		Member dbmember = memberRepository.memberSelectOne(member);
		return dbmember;
	}
}
