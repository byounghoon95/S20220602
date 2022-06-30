package com.oracle.S20220602.kkh.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.Notice;

public interface NoticeRepository {
	List<Notice> noticeSelect(Notice notice);
	int total();
	Notice noticeView(int boardno);
	
}
