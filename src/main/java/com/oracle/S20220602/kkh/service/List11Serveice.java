package com.oracle.S20220602.kkh.service;

import java.util.List;

import com.oracle.S20220602.common.domain.List11;

public interface List11Serveice {

	int total();

	List<List11> List11Select(List11 list11);

	List11 list11Detail(int inqno);

	int list11Write(List11 list11);

	int list11Update(List11 list11);

	int list11Delete(List11 list11);

	int list11ReplyCnt(int inqno);

	List<List11> List11ReplyList(int ref);


}
