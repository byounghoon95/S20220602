package com.oracle.S20220602.khj.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.Item;

public interface MarketRepository {

	List<Item> marketBestSelect(Item item);
	List<Item> marketAllSelect(Item item);
	int total();

}
