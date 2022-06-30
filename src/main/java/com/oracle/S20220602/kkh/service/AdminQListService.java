package com.oracle.S20220602.kkh.service;

import java.util.List;

import com.oracle.S20220602.common.domain.AdminQList;

public interface AdminQListService {

	int total();

	List<AdminQList> adminQListSelect(AdminQList adminqlist);

	int adminQListWrite(AdminQList adminqlist);

	AdminQList adminQListDetail(int boardno);

	int adminQListUpdate(AdminQList adminqlist);

	int adminQListDelete(AdminQList adminqlist);

}
