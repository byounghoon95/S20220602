package com.oracle.S20220602.kkh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.QList;

@Repository
public class QListRepositoryImpl implements QListRepository {

	@Autowired
	private SqlSession session;
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("QListRepositoryImpl total start..");
		try {
			total = session.selectOne("kkhQListCount");
			System.out.println("QListRepositoryImpl total -> " + total);
		} catch (Exception e) {
			System.out.println("QListRepositoryImpl total() Exception->"+e.getMessage());
		}
		return total;
	}

	@Override
	public List<QList> qlistSelect(QList qlist) {
		List<QList> listQList = null;
		System.out.println("QListRepositoryImpl qlistSelect Start");
		try {
			listQList = session.selectList("kkhListQList",qlist);
			System.out.println("QListRepositoryImpl qlistSelect listQList.size() -> " + listQList.size());
		} catch (Exception e) {
			System.out.println("QListRepositoryImpl qlistSelect Exception->"+e.getMessage());
		}
		return listQList;
	}

	@Override
	public QList qlistDetail(int boardno) {
		System.out.println("QListRepositoryImpl qlistDetail Start");
		QList qlist = null;
		try {
			qlist = session.selectOne("kkhQListDetail",boardno);
		}catch (Exception e) {
			System.out.println("QListRepositoryImpl qlistDetail Exception -> " + e.getMessage());
		}
		return qlist;
	}


}
