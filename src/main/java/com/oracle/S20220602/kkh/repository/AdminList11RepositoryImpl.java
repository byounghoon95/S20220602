package com.oracle.S20220602.kkh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.AdminList11;

@Repository
public class AdminList11RepositoryImpl implements AdminList11Repository {

	@Autowired
	private SqlSession session;

	@Override
	public int total() {
		int total = 0;
		System.out.println("AdminList11RepositoryImpl total start");
		try {
			total = session.selectOne("kkhAdminList11Count");
			System.out.println("AdminList11RepositoryImpl total -> " + total);
		} catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl total() Exception->"+e.getMessage());
		}
		return total;
	}

	@Override
	public List<AdminList11> adminList11Select(AdminList11 adminList11) {
		List<AdminList11> listAdminList11 = null;
		System.out.println("AdminList11RepositoryImpl adminList11Select Start");
		try {
			listAdminList11 = session.selectList("kkhAdminList11List",adminList11);
			System.out.println("AdminList11RepositoryImpl adminList11Select listAdminList11.size() -> " + listAdminList11.size());
		} catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl adminList11Select Exception->"+e.getMessage());
		}
		return listAdminList11;
	}

	@Override
	public AdminList11 adminList11Detail(int inqno) {
		System.out.println("AdminList11RepositoryImpl adminList11Detail Start");
		AdminList11 adminList11 = null;
		try {
			adminList11 = session.selectOne("kkhAdminList11Detail",inqno);
		} catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl adminList11Detail Exception->"+e.getMessage());
		}
		return adminList11;
	}

	@Override
	public int adminList11Delete(AdminList11 adminList11) {
		System.out.println("AdminList11RepositoryImpl adminList11Delete Start");
		int result = 0;
		try {
			result = session.update("kkhAdminList11Delete", adminList11);
		}catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl adminList11Delete Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int adminList11Reply(AdminList11 adminList11) {
		System.out.println("AdminList11RepositoryImpl adminList11Reply Start");
		int result = 0;
		replyShape(adminList11);
		try {
			System.out.println("adminList11.getRef()->"+adminList11.getRef());
			System.out.println("adminList11.getRef_level()->"+adminList11.getRef_level());
			System.out.println("adminList11.getRef_step()->"+adminList11.getRef_step());
			System.out.println("adminList11.getInqtitle()->"+adminList11.getInqtitle());
			if (adminList11.getInqtitle() == null) {
				System.out.println("adminList11.getInqtitle() is NULL");
			}
			result = session.insert("kkhAminList11ReplyWrite",adminList11);
		}catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl adminList11Reply Exception -> " + e.getMessage());
		}
		System.out.println("adminList11Reply adminList11Reply result->"+result);
		return result;
	}

	private int replyShape(AdminList11 adminList11) {
		System.out.println("AdminList11RepositoryImpl replyShape Start");
		int result = 0;
		try {
			result = session.update("kkhAdminList11ReplyShape", adminList11);
		}catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl replyShape Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public List<AdminList11> adminList11ReplyList(int ref) {
		System.out.println("AdminList11RepositoryImpl adminList11ReplyList Start");
		List<AdminList11> adminList11ReplyList = null;
		try {
			adminList11ReplyList = session.selectList("kkhAdminList11ReplyList",ref);
		}catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl adminList11ReplyList Exception -> " + e.getMessage());
		}
		return adminList11ReplyList;
	}

	@Override
	public AdminList11 adminList11ReplyOne(int inqno) {
		System.out.println("AdminList11RepositoryImpl adminList11ReplyOne Start");
		AdminList11 adminList11 = null;
		try {
			adminList11 = session.selectOne("kkhAdminList11ReplyOne",inqno);
		}catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl adminList11ReplyOne Exception -> " + e.getMessage());
		}
		
		return adminList11;
	}

	@Override
	public int adminList11ReplyCnt(int inqno) {
		System.out.println("AdminList11RepositoryImpl adminList11ReplyCnt Start");
		int cnt = 0;
		try {
			cnt = session.selectOne("kkhAdminList11Replycnt",inqno);
			session.selectOne("kkhadminList11Update",inqno);
		}catch (Exception e) {
			System.out.println("AdminList11RepositoryImpl adminList11ReplyCnt Exception -> " + e.getMessage());
		}
		return cnt;
	}



}
