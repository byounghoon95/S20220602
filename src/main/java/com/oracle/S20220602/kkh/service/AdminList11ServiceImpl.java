package com.oracle.S20220602.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.AdminList11;
import com.oracle.S20220602.kkh.repository.AdminList11Repository;

@Service
public class AdminList11ServiceImpl implements AdminList11Service {

	private final AdminList11Repository adminList11Repository;
	@Autowired
	public AdminList11ServiceImpl(AdminList11Repository adminList11Repository) {
		this.adminList11Repository = adminList11Repository;
	}
	@Override
	public int total() {
		int total = 0;
		System.out.println("AdminList11ServiceImpl total start");
		total = adminList11Repository.total();
		return total;
	}
	@Override
	public List<AdminList11> adminList11Select(AdminList11 adminList11) {
		System.out.println("AdminList11ServiceImpl adminList11");
		List<AdminList11> listAdminList11 = null;
		listAdminList11 = adminList11Repository.adminList11Select(adminList11);

		return listAdminList11;
	}
	@Override
	public AdminList11 adminList11Detail(int inqno) {
		System.out.println("AdminList11ServiceImpl adminList11Detail Start");
		AdminList11 adminList11 = null;
		adminList11 = adminList11Repository.adminList11Detail(inqno);
		return adminList11;
	}
	@Override
	public int adminList11Delete(AdminList11 adminList11) {
		System.out.println("AdminList11ServiceInpl adminList11Delete Start");
		int result = 0;
		result = adminList11Repository.adminList11Delete(adminList11);
		
		return result;
	}
	@Override
	public int adminList11Reply(AdminList11 adminList11) {
		System.out.println("AdminList11ServiceInpl adminList11Reply Start");
		int result = 0;
		result = adminList11Repository.adminList11Reply(adminList11);
		return result;
	}
	
	@Override
	public List<AdminList11> adminList11ReplyList(int ref) {
		System.out.println("AdminList11ServiceImpl adminList11Reply start");
		List<AdminList11> adminList11ReplyList = null;
		adminList11ReplyList = adminList11Repository.adminList11ReplyList(ref);
		return adminList11ReplyList;
	}
	
	@Override
	public AdminList11 adminList11ReplyOne(int inqno) {
		System.out.println("AdminList11ServiceImpl adminList11ReplyOne start");
		AdminList11 adminList11 = adminList11Repository.adminList11ReplyOne(inqno);
		return adminList11;
	}
	
	@Override
	public int adminList11ReplyCnt(int inqno) {
		System.out.println("AdminList11Service adminList11ReplyCnt Start");
		int cnt = adminList11Repository.adminList11ReplyCnt(inqno);
		return cnt;
	}

}
