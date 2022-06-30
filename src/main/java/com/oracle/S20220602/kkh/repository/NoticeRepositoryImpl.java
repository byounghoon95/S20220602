package com.oracle.S20220602.kkh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Notice;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<Notice> noticeSelect(Notice notice) {
		List<Notice> listNotice = null;
		System.out.println("NoticeRepositoryImpl noticeSelect start...");
		try {
			listNotice = session.selectList("kkhListNotice",notice);
			System.out.println("NoticeRepositoryImpl noticeSelect listNotice.size() -> " + listNotice.size());
		} catch (Exception e) {
			System.out.println("NoticeRepositoryImpl noticeSelect Exception->"+e.getMessage());
		}
		return listNotice;
	}

	@Override
	public int total() {
		int total = 0;
		System.out.println("NoticeRepositoryImpl total start...");
		try {
			total = session.selectOne("kkhNoticeCount");
			System.out.println("NoticeRepositoryImpl total -> " + total);
		} catch (Exception e) {
			System.out.println("NoticeRepositoryImpl total() Exception->"+e.getMessage());
		}
		return total;
	}
	
	@Override
	public Notice noticeView(int boardno) {
		System.out.println("NoticeRepositoryImpl noticeView Start");
		Notice notice = null;
		try {
			notice = session.selectOne("kkhNoticeView",boardno);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardDetail Exception -> " + e.getMessage());
		}
		return notice;
	}
}
