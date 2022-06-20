package com.oracle.S20220602.pch.service;

import java.util.List;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;

public interface SearchService {
	int				total();
	List<Common> 	listCommon(Common common);
	List<Common> 	listCartegori(Common common);
	int 			totalItemKeyword(Item item);
	List<Item> 		listItemKeyword(Item item);
}
