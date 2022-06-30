package com.oracle.S20220602.kkh.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.QList;

public interface QListRepository {

	int total();

	List<QList> qlistSelect(QList qlist);

	QList qlistDetail(int boardno);

}
