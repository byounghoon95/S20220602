package com.oracle.S20220602.kkh.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.AdminNotice;

public interface AdminNoticeRepository {
	int total();
	List<AdminNotice> adminNoticeSelect(AdminNotice adminnotice);
	int adminNoticeWrite(AdminNotice adminnotice);
	AdminNotice adminNoticeDetail(int boardno);
	int adminNoticeUpdate(AdminNotice adminnotice);
	int adminNoticeDelete(AdminNotice adminnotice);
	
}
