package com.oracle.S20220602.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.QList;
import com.oracle.S20220602.kkh.repository.QListRepository;

@Service
public class QListServiceImpl implements QListService {
	
	private final QListRepository qlistRepository;
	@Autowired
	public QListServiceImpl(QListRepository qlistRepository) {
		this.qlistRepository = qlistRepository;
	}
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("QListServiceImpl total start");
		total = qlistRepository.total();
		return total;
	}

	@Override
	public List<QList> qlistSelect(QList qlist) {
		System.out.println("QListServiceImpl listqlist");
		List<QList> listQList = null;
		listQList = qlistRepository.qlistSelect(qlist);
		return listQList;
	}

	@Override
	public QList qlistDetail(int boardno) {
		System.out.println("QListServiceImpl qlistDetail Start");
		QList qlist = null;
		qlist = qlistRepository.qlistDetail(boardno);

		return qlist;
	}

	

}
