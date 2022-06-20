package com.oracle.S20220602.kjh.service;

import java.util.List;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Warning;

public interface ItemService {

	int itemReg(Item item);

	List<Common> itemCategorySelect();

	List<Common> reportCategorySelect();

	String memberLocNameSelect(String id);

	String warnNicknameSelect(Warning warning);

	int reportReg(Warning warning);

	Item itemDetail(Item item);

	String locName(Item item);

	List<Item> sellerItemList(Item item);

	int wishCheck(Item item);

	int itemUpdate(Item item);

	int itemDelete(Item item);

	

}
