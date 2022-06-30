package com.oracle.S20220602.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.List11;
import com.oracle.S20220602.kkh.repository.List11Repository;

@Service
public class List11ServiceImpl implements List11Serveice {

	private final List11Repository list11Repository;
	
	@Autowired
	public List11ServiceImpl(List11Repository list11Repository) {
		this.list11Repository = list11Repository;
	}
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("List11ServiceImpl total start");
		total = list11Repository.total();
		return total;
	}

	@Override
	public List<List11> List11Select(List11 list11) {
		System.out.println("List11ServiceImpl list11 start");
		List<List11> list11list = null;
		list11list = list11Repository.List11Select(list11);
		return list11list;
	}

	@Override
	public List11 list11Detail(int inqno) {
		System.out.println("List11ServiceImpl list11Detail Start");
		List11 list11 = null;
		list11 = list11Repository.list11Detail(inqno);
		return list11;
	}

	@Override
	public int list11Write(List11 list11) {
		int result = 0;
		System.out.println("list11ServiceImpl listWrite Start");
		result = list11Repository.list11Write(list11);
		return result;
	}

	@Override
	public int list11Update(List11 list11) {
		System.out.println("list11ServiceImpl list11Update Start");
		int result = 0;
		result = list11Repository.list11Update(list11);
		
		return result;
	}

	@Override
	public int list11Delete(List11 list11) {
		System.out.println("List11ServiceImpl list11Delete Start");
		int result = 0;
		result = list11Repository.list11Delete(list11);
		return result;
	}

	@Override
	public int list11ReplyCnt(int inqno) {
		System.out.println("List11ServiceImpl list11ReplyCnt Start");
		int cnt = list11Repository.list11ReplyCnt(inqno);
		return cnt;
	}
 
	@Override
	public List<List11> List11ReplyList(int ref) {
		System.out.println("List11ServiceImpl List11ReplyList Start");
		List<List11> list11ReplyList = null;
		list11ReplyList = list11Repository.list11ReplyList(ref); 
		return list11ReplyList;
	}
	
	
}
