package com.oracle.S20220602.kkh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	
	@Autowired
	private SqlSession		session;
	
	@Override
	public Member memberLogin(String id) {
		Member member = null;
		System.out.println("MemberRepositoryImpl memberLogin start");
		System.out.println("MemberRepositoryImpl memberLogin id -> " + id);
		
		try {
			member = session.selectOne("kkhGetIdPass",id);
			System.out.println("MemberRepositoryImpl id -> " + member.getId());
			System.out.println("MemberRepositoryImpl pw -> " + member.getPw());
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl memberLogin exception-> " + e.getMessage());
		}
		return member;
	}

	@Override
	public int register(Member member) {
		int result = 0;
		System.out.println("MemberRepositoryImpl register start");
		try {
			result = session.insert("kkhregister",member);
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl register exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int idCheck(Member member) {
		int result = 0;
		System.out.println("MemberRepositoryImpl idCheck start");
		try {
			result = session.selectOne("kkhidCheck",member);
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl idCheck exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Common> selectLocList() {
		
		List<Common> selectLocList = null;
				
		System.out.println("MemberRepositoryImpl selectLocList start");
		try {
			selectLocList = session.selectList("kkhselectLocList");
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl selectLocList exception -> " + e.getMessage());
		}
		return selectLocList;
	}

	@Override
	public Member memberSelect(Member member) {
		System.out.println("MemberRepositoryImpl memberSelect start");
		Member dbmember = null;
		Member nullmember = new Member();
		int chk = 0;
		
		int cnt = session.selectOne("kkhmemberSelectCnt",member);
		System.out.println("cnt -> " + cnt);
		try {
			if (cnt == 1) {
				chk = 1;
				dbmember = session.selectOne("kkhmemberSelect",member);
				dbmember.setChk(chk);
			}else {
				dbmember = nullmember;
				dbmember.setChk(chk);
			}
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl memberSelect exception -> " + e.getMessage());
		}
		return dbmember;
	}

	@Override
	public Member emailChk(Member member) {
		System.out.println("MemberRepositoryImpl emailChk start");
		Member dbmember = null;
		Member nullmember = new Member();
		int chk = 0;
		
		int cnt = session.selectOne("kkhemailChkCnt",member);
		System.out.println("cnt -> " + cnt);
		try {
			if (cnt == 1) {
				chk = 1;
				dbmember = session.selectOne("kkhemailChk",member);
				dbmember.setChk(chk);
			}else {
				dbmember = nullmember;
				dbmember.setChk(chk);
			}
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl memberSelect exception -> " + e.getMessage());
		}
		return dbmember;
	}

	@Override
	public void updateTempPw(Member member) {
		System.out.println("MemberRepositoryImpl updateTempPw start");
		session.update("kkhupdateTempPw",member);
	}

	@Override
	public Member memberSelectOne(Member member) {
		Member dbmember = null;
		System.out.println("MemberRepositoryImpl memberSelectOne start");
		try {
			dbmember = session.selectOne("kkhmemberSelectOne", member);
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl memberSelectOne exception-> " + e.getMessage());
		}
		return dbmember;
	}

	@Override
	public void memberPwUpdate(Member member) {
		System.out.println("MemberRepositoryImpl memberPwUpdate start");
		
		try {
			session.update("kkhmemberPwUpdate", member);
		}catch (Exception e) {
			System.out.println("MemberRepositoryImpl memberPwUpdate exception-> " + e.getMessage());
		}
	}
}
