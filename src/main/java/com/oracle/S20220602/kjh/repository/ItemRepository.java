package com.oracle.S20220602.kjh.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Warning;

public interface ItemRepository {

	int itemReg(Item item);

	List<Common> itemCategorySelect();

	List<Common> reportCategorySelect();

	String memberLocNameSelect(String id);

	String warnNicknameSelect(Warning warning);

	int reportReg(Warning warning);

	Item itemDetailSelect(Item item);

	String locName(Item item);

	List<Item> sellerItemListSelect(Item item);

	int wishCheck(Item item);

	int itemUpdate(Item item);

	int itemDelete(Item item);


	

}
