package com.oracle.S20220602.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.AdminQList;
import com.oracle.S20220602.kkh.repository.AdminQListRepository;

@Service
public class AdminQListServiceImpl implements AdminQListService {

	private final AdminQListRepository adminQListRepository;
	@Autowired
	public AdminQListServiceImpl(AdminQListRepository adminQListRepository) {
		this.adminQListRepository = adminQListRepository;
	}
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("AdminQListServiceImpl total start");
		total = adminQListRepository.total();
		return total;
	}


	@Override
	public List<AdminQList> adminQListSelect(AdminQList adminqlist) {
		System.out.println("AdminQListServiceImpl qList..");
		List<AdminQList> listAdminQList = null;
		listAdminQList = adminQListRepository.adminQListSelect(adminqlist);
		
		return listAdminQList;
	}

	@Override
	public int adminQListWrite(AdminQList adminqlist) {
		int result = 0;
		System.out.println("AdminQListServiceImpl adminQListWrite start");
		result = adminQListRepository.adminQListWrite(adminqlist);
		return result;
	}

	@Override
	public AdminQList adminQListDetail(int boardno) {
		System.out.println("AdminQListServiceImpl adminQListDetail Start");
		AdminQList adminqlist = null;
		adminqlist = adminQListRepository.adminQListDetail(boardno);
		
		return adminqlist;
	}

	@Override
	public int adminQListUpdate(AdminQList adminqlist) {
		System.out.println("AdminQListServiceImpl adminQListUpdate Start");
		int result = 0;
		result = adminQListRepository.adminQListUpdate(adminqlist);
		
		return result;
	}

	@Override
	public int adminQListDelete(AdminQList adminqlist) {
		System.out.println("AdminQListServiceImpl adminQListDelete Start");
		int result = 0;
		result = adminQListRepository.adminQListDelete(adminqlist);
	
		return result;
	}

}
