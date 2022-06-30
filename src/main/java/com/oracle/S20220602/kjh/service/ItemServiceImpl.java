package com.oracle.S20220602.kjh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Warning;
import com.oracle.S20220602.kjh.repository.ItemRepository;


@Service
public class ItemServiceImpl implements ItemService {
	
	private final ItemRepository itemRepository;

	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public int itemReg(Item item) {
		int result=0;
		System.out.println("ItemServiceImpl itemReg Start....");
		result = itemRepository.itemReg(item);
		return result;
	}

	@Override
	public List<Common> itemCategorySelect() {
		System.out.println("ItemServiceImpl itemCategorySelect Start....");
		List<Common> itemCategoryList = null;
		itemCategoryList = itemRepository.itemCategorySelect();
		return itemCategoryList;
	}

	@Override
	public List<Common> reportCategorySelect() {
		System.out.println("ItemServiceImpl reportCategorySelect Start....");
		List<Common> reportCategoryList = null;
		reportCategoryList = itemRepository.reportCategorySelect();
		return reportCategoryList;
	}

	@Override
	public String memberLocNameSelect(String id) {
		System.out.println("ItemServiceImpl memberLocNameSelect Start....");
		String memberLocName = null;
		memberLocName = itemRepository.memberLocNameSelect(id);
		return memberLocName;
	}

	@Override
	public String warnNicknameSelect(Warning warning) {
		System.out.println("ItemServiceImpl warnNicknameSelect Start....");
		String warnNickname = null;
		warnNickname = itemRepository.warnNicknameSelect(warning);
		return warnNickname;
	}

	@Override
	public int reportReg(Warning warning) {
		int result=0;
		System.out.println("ItemServiceImpl reportReg Start....");
		result = itemRepository.reportReg(warning);
		return result;
	}

	@Override
	public Item itemDetail(Item item) {
		System.out.println("ItemServiceImpl  itemDetail Start....");
		Item itemDetail = null;
		itemDetail = itemRepository.itemDetailSelect(item);
		return itemDetail;
	}

	@Override
	public String locName(Item item) {
		System.out.println("ItemServiceImpl  locName Start....");
		String locname = null;
		locname = itemRepository.locName(item);
		return locname;
	}

	@Override
	public List<Item> sellerItemList(Item item) {
		System.out.println("ItemServiceImpl sellerItemList Start....");
		List<Item> sellerItemList = null;
		sellerItemList = itemRepository.sellerItemListSelect(item);
		return sellerItemList;
	}

	@Override
	public int wishCheck(Item item) {
		System.out.println("ItemServiceImpl wishCheck Start....");
		int wishCheck = 0;
		wishCheck = itemRepository.wishCheck(item);
		System.out.println("ItemServiceImpl wishCheck->"+wishCheck);
		return wishCheck;
	}

	@Override
	public int itemUpdate(Item item) {
		System.out.println("ItemServiceImpl itemUpdate Start....");
		int result = 0;
		result = itemRepository.itemUpdate(item);
		return result;
	}

	@Override
	public int itemDelete(Item item, Warning warning) {
		System.out.println("ItemServiceImpl itemDelete Start");
		int result = 0;
		result = itemRepository.itemDelete(item, warning);
		return result;
	}

	@Override
	public void changeHeart(Item item) {
		System.out.println("ItemServiceImpl changeHeart Start");
		itemRepository.changeHeart(item);
		
	}

	@Override
	public String resStat(Item item) {
		System.out.println("ItemServiceImpl  resStat Start....");
		String resstat = null;
		resstat = itemRepository.resStat(item);
		return resstat;
	}
	
	
}
