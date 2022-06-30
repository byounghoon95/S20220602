package com.oracle.S20220602.kkh.service;

import java.util.List;

import com.oracle.S20220602.common.domain.AdminNotice;
import com.oracle.S20220602.common.domain.Notice;

public interface AdminNoticeService {


	int total();

	List<AdminNotice> adminNoticeSelect(AdminNotice adminnotice);

	int adminNoticeWrite(AdminNotice adminnotice);

	AdminNotice adminNoticeDetail(int boardno);

	int adminNoticeUpdate(AdminNotice adminnotice);

	int adminNoticeDelete(AdminNotice adminnotice);

}
