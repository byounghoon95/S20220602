package com.oracle.S20220602.kkh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.AdminNotice;
import com.oracle.S20220602.common.domain.Notice;

@Repository
public class AdminNoticeRepositoryImpl implements AdminNoticeRepository {

	@Autowired
	private SqlSession session;
	

	@Override
	public List<AdminNotice> adminNoticeSelect(AdminNotice adminnotice) {
		List<AdminNotice> listAdminNotice = null;
		System.out.println("AdminNoticeRepositoryImpl adminnoticeSelect start..");
		try {
			listAdminNotice = session.selectList("kkhListAdminNotice",adminnotice);
			System.out.println("AdminNoticeRepositoryImpl adminnoticeSelect listAdminNotice.size() -> " + listAdminNotice.size());
		} catch (Exception e) {
			System.out.println("AdminNoticeRepositoryImpl adminnoticeSelect Exception->"+e.getMessage());
		}
		return listAdminNotice;
	}
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("NoticeRepositoryImpl total start...");
		try {
			total = session.selectOne("kkhAdminNoticeCount");
			System.out.println("NoticeRepositoryImpl total -> " + total);
		} catch (Exception e) {
			System.out.println("NoticeRepositoryImpl total() Exception->"+e.getMessage());
		}
		return total;
	}

	@Override
	public int adminNoticeWrite(AdminNotice adminnotice) {
		int result = 0;
		System.out.println("AdminNoticeRepositoryImpl adminNoticeWrite Start");
		try {
			result = session.insert("kkhAdminNoticeWrite",adminnotice);
		}catch (Exception e) {
			System.out.println("AdminNoticeRepositoryImpl adminNoticeWrite Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public AdminNotice adminNoticeDetail(int boardno) {
		System.out.println("AdminNoticeRepositoryImpl adminNoticeDetail Start");
		AdminNotice adminnotice = null;
		try {
			adminnotice = session.selectOne("kkhAdminNoticeDetail",boardno);
		}catch (Exception e) {
			System.out.println("AdminNoticeRepositoryImpl adminNoticeDetail Exception -> " + e.getMessage());
		}
		return adminnotice;
	}

	@Override
	public int adminNoticeUpdate(AdminNotice adminnotice) {
		System.out.println("AdminNoticeRepositoryImpl adminNoticeUpdate start");
		int result = 0;
		try {
			System.out.println("boardno -> " + adminnotice.getBoardno());
			result = session.update("kkhAdminNoticeUpdate", adminnotice);
		}catch (Exception e) {
			System.out.println("AdminNoticeRepositoryImpl adminNoticeUpdate Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int adminNoticeDelete(AdminNotice adminnotice) {
		System.out.println("AdminNoticeRepositoryImpl adminNoticeDelete start");
		int result = 0;
		try {
			result = session.update("kkhAdminNoticeDelete", adminnotice);
		}catch (Exception e) {
			System.out.println("AdminNoticeRepositoryImpl adminNoticeDelete Exception -> " + e.getMessage());
		}
		return result;
	}

}
