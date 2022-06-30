package com.oracle.S20220602.khj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.khj.repository.MarketRepository;

@Service
public class MarketServiceimpl implements MarketService {
	
	private final MarketRepository marketRepository;
	@Autowired
	public MarketServiceimpl(MarketRepository marketRepository) {
		this.marketRepository = marketRepository;
	}

	@Override
	public List<Item> marketBestList(Item item) {
		System.out.println("MypageServiceImpl mypageWishList ...");
		List<Item> marketBestSelect = null;
		marketBestSelect = marketRepository.marketBestSelect(item);
		return marketBestSelect;
	}

	@Override
	public List<Item> marketAllList(Item item) {
		System.out.println("MypageServiceImpl marketAllList ...");
		List<Item> marketAllSelect = null;
		marketAllSelect = marketRepository.marketAllSelect(item);
		return marketAllSelect;
	}

	@Override
	public int total() {
		int total = 0;
		System.out.println("MypageServiceImpl total start");
		total = marketRepository.total();
		return total;
	}

}
