package com.oracle.S20220602.khj.service;

import java.util.List;

import com.oracle.S20220602.common.domain.Item;

public interface MarketService {

	List<Item> marketBestList(Item item);
	List<Item> marketAllList(Item item);
	int total();
	
}
