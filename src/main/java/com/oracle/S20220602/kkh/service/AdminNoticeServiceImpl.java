package com.oracle.S20220602.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.AdminNotice;
import com.oracle.S20220602.common.domain.Notice;
import com.oracle.S20220602.kkh.repository.AdminNoticeRepository;

@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {

	private final AdminNoticeRepository adnoticeRepository;
	@Autowired
	public AdminNoticeServiceImpl(AdminNoticeRepository adnoticeRepository) {
		this.adnoticeRepository = adnoticeRepository;
	}

	@Override
	public List<AdminNotice> adminNoticeSelect(AdminNotice adminnotice) {
		System.out.println("adminNoticeServiceImpl listnotice...");
		List<AdminNotice> listAdminNotice = null;
		listAdminNotice = adnoticeRepository.adminNoticeSelect(adminnotice);
		return listAdminNotice;
	}
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("NoticeServiceImpl total start");
		total = adnoticeRepository.total();
		return total;
	}

	@Override
	public int adminNoticeWrite(AdminNotice adminnotice) {
		int result = 0;
		System.out.println("NoticeServiceImpl adminNoticeWrite Start");
		result = adnoticeRepository.adminNoticeWrite(adminnotice);
		
		return result;
	}

	@Override
	public AdminNotice adminNoticeDetail(int boardno) {
		System.out.println("NoticeServiceImpl adminNoticeDetail start");
		AdminNotice adminnotice = null;
		adminnotice = adnoticeRepository.adminNoticeDetail(boardno);
		
		return adminnotice;
	}

	@Override
	public int adminNoticeUpdate(AdminNotice adminnotice) {
		System.out.println("NoticeServiceImpl adminNoticeUpdate start");
		int result = 0;
		result = adnoticeRepository.adminNoticeUpdate(adminnotice);
		
		return result;
	}

	@Override
	public int adminNoticeDelete(AdminNotice adminnotice) {
		System.out.println("AdminNoticeServiceImpl adminNoticeDelete Start");
		int result = 0;
		result = adnoticeRepository.adminNoticeDelete(adminnotice);
		
		return result;
	}



}
