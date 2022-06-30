package com.oracle.S20220602.kkh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.List11;

@Repository
public class List11RepositoryImpl implements List11Repository {

	@Autowired
	private SqlSession session;

	@Override
	public int total() {
		int total = 0;
		System.out.println("List11Repository total start..");
		try {
			total = session.selectOne("kkhList11Count");
			System.out.println("List11Repository total -> " + total);
		} catch (Exception e) {
			System.out.println("List11Repository total() Exception->"+e.getMessage());
		}
		return total;
	}

	@Override
	public List<List11> List11Select(List11 list11) {
		List<List11> Listlist11 = null;
		System.out.println("List11RepositoryImpl List11Select start");
		try {
			Listlist11 = session.selectList("kkhList11List",list11);
			System.out.println("List11RepositoryImpl List11Select Listlist11.size() -> " + Listlist11.size());
		} catch (Exception e) {
			System.out.println("List11RepositoryImpl List11Select Exception->"+e.getMessage());
		}
		return Listlist11;
	}

	@Override
	public List11 list11Detail(int inqno) {
		System.out.println("List11RepositoryImpl list11Detail start");
		List11 list11 = null;
		try {
			list11 = session.selectOne("kkhList11Detail",inqno);
		} catch (Exception e) {
			System.out.println("List11RepositoryImpl List11Detail Exception->"+e.getMessage());
		}
		return list11;
	}

	@Override
	public int list11Write(List11 list11) {
		int result = 0;
		System.out.println("list11RepositoryImpl list11Write Start");
		try {
			result = session.insert("kkhList11Write",list11);
		}catch (Exception e) {
			System.out.println("list11RepositoryImpl list11Write Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int list11Update(List11 list11) {
		System.out.println("list11RepositoryImpl list11Update Start");
		int result = 0;
		try {
			result = session.insert("kkhList11Update",list11);
		}catch (Exception e) {
			System.out.println("list11RepositoryImpl list11Update Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int list11Delete(List11 list11) {
		System.out.println("list11RepositoryImpl list11Delete Start");
		int result = 0;
		try {
			result = session.update("kkhList11Delete", list11);
		}catch (Exception e) {
			System.out.println("list11RepositoryImpl list11Delete Exception -> " + e.getMessage());
		}
		System.out.println("result"+result);
		return result;
	}

	@Override
	public int list11ReplyCnt(int inqno) {
		System.out.println("list11RepositoryImpl list11RepltCnt Start");
		int cnt = 0;
		try {
			cnt = session.selectOne("kkhList11Replycnt",inqno);
		}catch (Exception e) {
			System.out.println("list11RepositoryImpl list11RepltCnt Exception -> " + e.getMessage());
		}
		return cnt;
	}

	@Override
	public List<List11> list11ReplyList(int ref) {
		System.out.println("list11RepositoryImpl list11ReplyList Start");
		List<List11> list11ReplyList = null;
		try {
			list11ReplyList = session.selectList("kkhList11ReplyList",ref);
		}catch (Exception e) {
			System.out.println("list11RepositoryImpl list11ReplyList Exception -> " + e.getMessage());
		}
		return list11ReplyList;
	}
	
}
