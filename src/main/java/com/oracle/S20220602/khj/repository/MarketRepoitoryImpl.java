package com.oracle.S20220602.khj.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Item;

@Repository
public class MarketRepoitoryImpl implements MarketRepository {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Item> marketBestSelect(Item item) {
		List<Item> marketBestSelect = null;
		System.out.println("MypageRepositoryImpl marketBestSelect start...");
		try {
			marketBestSelect = session.selectList("khjmarketBestList",item);
			System.out.println("MypageRepositoryImpl marketBestSelect marketBestSelect.size() -> " + marketBestSelect.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl marketBestSelect Exception->"+e.getMessage());
		}
		return marketBestSelect;
	}

	@Override
	public List<Item> marketAllSelect(Item item) {
		List<Item> marketAllSelect = null;
		System.out.println("MypageRepositoryImpl marketAllSelect start...");
		try {
			marketAllSelect = session.selectList("khjmarketAllList",item);
			System.out.println("MypageRepositoryImpl marketAllSelect marketAllSelect.size() -> " + marketAllSelect.size());
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl marketAllSelect Exception->"+e.getMessage());
		}
		return marketAllSelect;
	}

	@Override
	public int total() {
		int total = 0;
		System.out.println("MypageRepositoryImpl total start...");
		try {
			total = session.selectOne("khjMarketCount");
			System.out.println("MypageRepositoryImpl total -> " + total);
		} catch (Exception e) {
			System.out.println("MypageRepositoryImpl total() Exception->"+e.getMessage());
		}
		return total;
	}

}
