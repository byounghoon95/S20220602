package com.oracle.S20220602.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Notice;
import com.oracle.S20220602.kkh.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;
	@Autowired
	public NoticeServiceImpl(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}
	
	@Override
	public List<Notice> noticeSelect(Notice notice) {
		System.out.println("NoticeServiceImpl listnotice...");
		List<Notice> listNotice = null;
		listNotice = noticeRepository.noticeSelect(notice);
		return listNotice;
	}
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("NoticeServiceImpl total start");
		total = noticeRepository.total();
		return total;
	}

	@Override
	public Notice noticeView(int boardno) {
		System.out.println("NoticeServiceImpl noticeView Start");
		Notice notice = null;
		notice = noticeRepository.noticeView(boardno);
		return notice;
	}

}
