package com.oracle.S20220602.kkh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.AdminQList;
import com.oracle.S20220602.kkh.service.AdminQListService;

@Repository
public class AdminQListRepositoryImpl implements AdminQListRepository {

	@Autowired
	private SqlSession session;
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("AdminQListRepositoryImpl total start...");
		try {
			total = session.selectOne("kkhAdminQListCount");
			System.out.println("AdminQListRepositoryImpl total -> " + total);
		} catch (Exception e) {
			System.out.println("AdminQListRepositoryImpl total() Exception->"+e.getMessage());
		}
		return total;
	}

	@Override
	public List<AdminQList> adminQListSelect(AdminQList adminqlist) {
		List<AdminQList> listAdminQList = null;
		System.out.println("AdminQListRepositoryImpl adminqlistSelect Start");
		try {
			listAdminQList = session.selectList("kkhListAdminQList",adminqlist);
			System.out.println("AdminQListRepositoryImpl adminqlistSelect listAdminQList.size() -> " + listAdminQList.size());
		} catch (Exception e) {
			System.out.println("AdminQListRepositoryImpl adminqlistSelect Exception->"+e.getMessage());
		}
		return listAdminQList;
	}

	@Override
	public int adminQListWrite(AdminQList adminqlist) {
		int result = 0;
		System.out.println("AdminQListRepositoryImpl adminQListWrite start");
		try {
			result = session.insert("kkhAdminQListWrite",adminqlist);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl adminQListWrite Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public AdminQList adminQListDetail(int boardno) {
		System.out.println("AdminQListRepositoryImpl adminQListDetail start");
		AdminQList adminqlist = null;
		try {
			adminqlist = session.selectOne("kkhAdminQListDetail",boardno);
		}catch (Exception e) {
			System.out.println("AdminQListRepositoryImpl adminQListDetail Exception -> " + e.getMessage());
		}
		return adminqlist;
	}

	@Override
	public int adminQListUpdate(AdminQList adminqlist) {
		System.out.println("AdminQListRepositoryImpl adminQListUpdate start");
		int result = 0;
		try {
			System.out.println("boardno -> " + adminqlist.getBoardno());
			result = session.update("kkhAdminQListUpdate", adminqlist);
		}catch (Exception e) {
			System.out.println("AdminQListRepositoryImpl adminQListUpdate Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int adminQListDelete(AdminQList adminqlist) {
		System.out.println("AdminQListRepositoryImpl adminQListUpdate start");
		int result = 0;
		try {
			result = session.update("kkhAdminQListDelete", adminqlist);
		}catch (Exception e) {
			System.out.println("AdminQListRepositoryImpl adminQListUpdate Exception -> " + e.getMessage());
		}
		return result;
	}


}
