package com.oracle.S20220602.pch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.pch.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	private		SearchRepository	sr;
	
	@Override
	public int total() {
		System.out.println("SearchServiceImpl Start total...");
		int totCnt = sr.total();
		System.out.println("SearchServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}

	@Override
	public int totalItemKeyword(Item item) {
		System.out.println("SearchServiceImpl totalItemKeyword1 Start..." );
		int totCnt = sr.totalItemKeyword(item);
		System.out.println("SearchServiceImpl totalItemKeyword1 totCnt->"+totCnt );
		return totCnt;
	}

	@Override
	public List<Item> listItemKeyword(Item item) {
		List<Item> listItem = null;
		System.out.println("SearchServiceImpl listItemKeyword1 Start...");
		listItem = sr.listItemKeyword(item);
		System.out.println("SearchServiceImpl listItemKeyword1 boardList.size()->" + listItem.size());
		return listItem;
	}

	@Override
	public List<Common> listCommon(Common common) {
		System.out.println("SearchServiceImpl listCommon ...");
		List<Common> listCommon = null;
		listCommon = sr.listCommon(common);
		return listCommon;
	}

	@Override
	public List<Common> listCartegori(Common common) {
		System.out.println("SearchServiceImpl listCartegori ...");
		List<Common> listCartegori = null;
		listCartegori = sr.listCartegori(common);
		return listCartegori;
	}


}













