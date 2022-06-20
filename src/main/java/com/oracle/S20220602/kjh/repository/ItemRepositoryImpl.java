package com.oracle.S20220602.kjh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Warning;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
	@Autowired
	private SqlSession session;

	@Override
	public int itemReg(Item item) {
		int result = 0;
		System.out.println("ItemRepositoryImpl itemReg Start...");
		try {
			result = session.insert("kjhItemReg",item);
		}catch (Exception e) {
			System.out.println("ItemRepositoryImpl itemReg Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public List<Common> itemCategorySelect() {
		System.out.println("ItemRepositoryImpl itemCategorySelect Start....");
		List<Common> itemCategoryList = null;
		try {
			itemCategoryList = session.selectList("kjhItemCategoryList");
			System.out.println("ItemRepositoryImpl itemCategorySelect  itemCatecoryList.size()->"+itemCategoryList.size());
			
			  for(Common itemCategroy : itemCategoryList) 
			  { System.out.println("ItemRepositoryImpl itemCategorySelect  itemCategroy.getMcd()->" + itemCategroy.getMcd() );
			    System.out.println("ItemRepositoryImpl itemCategorySelect  itemCategroy.getContent()->" + itemCategroy.getContent() );
			  }
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl itemCategorySelect Exception->"+e.getMessage());
		}
		return itemCategoryList;
	}

	@Override
	public List<Common> reportCategorySelect() {
		System.out.println("ItemRepositoryImpl reportCategorySelect Start....");
		List<Common> reportCategoryList = null;
		try {
			reportCategoryList = session.selectList("kjhReportCategoryList");
			System.out.println("ItemRepositoryImpl reportCategorySelect  reportCatecoryList.size()->"+reportCategoryList.size());
			
			  for(Common reportCategroy : reportCategoryList) 
			  { System.out.println("ItemRepositoryImpl reportCategorySelect  reportCategroy.getMcd()->" + reportCategroy.getMcd() );
			    System.out.println("ItemRepositoryImpl reportCategorySelect  reportCategroy.getContent()->" + reportCategroy.getContent() );
			  }
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl reportCategroySelect Exception->"+e.getMessage());
		}
		return reportCategoryList;
	}

	@Override
	public String memberLocNameSelect(String id) {
		System.out.println("ItemRepositoryImpl memberLocNameSelect Start....");
		String memberLocName = null;
		try {
			memberLocName = session.selectOne("kjhMemberLocName", id);
			System.out.println("ItemRepositoryImpl memberLocNameSelect  memberLocName->" + memberLocName );
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl memberLocNameSelect Exception->"+e.getMessage());
		}
		return memberLocName;
	}

	@Override
	public String warnNicknameSelect(Warning warning) {
		System.out.println("ItemRepositoryImpl warnNicknameSelect Start....");
		String warnNickname = null;
		try {
			warnNickname = session.selectOne("kjhWarnNickname", warning);
			System.out.println("ItemRepositoryImpl warnNicknameSelect  warnNickname->" + warnNickname );
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl warnNicknameSelect Exception->"+e.getMessage());
		}
		return warnNickname;
	}

	@Override
	public int reportReg(Warning warning) {
		int result = 0;
		System.out.println("ItemRepositoryImpl  reportReg Start...");
		try {
			result = session.insert("kjhReportReg",warning);
		}catch (Exception e) {
			System.out.println("ItemRepositoryImpl reportReg Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public Item itemDetailSelect(Item item) {
		System.out.println("ItemRepositoryImpl itemDetailSelect Start....");
		
		Item itemDetail = null;
		try {
			itemDetail = session.selectOne("kjhItemDetail", item);
			System.out.println("ItemRepositoryImpl itemDetailSelect  item->" + itemDetail.getNickname());
			System.out.println("ItemRepositoryImpl itemDetailSelect  item->" + itemDetail.getContent());
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl itemDetailSelect Exception->"+e.getMessage());
		}
		return itemDetail;
	}

	@Override
	public String locName(Item item) {
		System.out.println("ItemRepositoryImpl locName Start....");
		String locname = null;
		try {
			locname = session.selectOne("kjhLocName", item);
			System.out.println("ItemRepositoryImpl locName  locname->" + locname);
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl locName Exception->"+e.getMessage());
		}
		return locname;
	}

	@Override
	public List<Item> sellerItemListSelect(Item item) {
		System.out.println("ItemRepositoryImpl  sellerItemListSelect Start....");
		List<Item> sellerItemList = null;
		try {
			sellerItemList = session.selectList("kjhSellerItemList", item);
			System.out.println("ItemRepositoryImpl sellerItemListSelect  sellerItemList.size()->"+sellerItemList.size());
			
			  for(Item sellerItem : sellerItemList) 
			  { System.out.println("ItemRepositoryImpl sellerItemListSelect  sellerItem.getMcd()->" + sellerItem.getItemtitle() );
			    System.out.println("ItemRepositoryImpl sellerItemListSelect  sellerItem.getContent()->" + sellerItem.getItemcostfilter() );
			    System.out.println("ItemRepositoryImpl sellerItemListSelect  sellerItem.getContent()->" + sellerItem.getLocname() );
			    System.out.println("ItemRepositoryImpl sellerItemListSelect  sellerItem.getContent()->" + sellerItem.getItemwish() );
			    System.out.println("ItemRepositoryImpl sellerItemListSelect  sellerItem.getContent()->" + sellerItem.getItemview() );
			    
			  }
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl sellerItemListSelect Exception->"+e.getMessage());
		}
		return sellerItemList;
	}

	@Override
	public int wishCheck(Item item) {
		System.out.println("ItemRepositoryImpl  wishCheck Start....");
		int wishCheck = 0;
		boolean wishCheckTF = false;
		try {
			wishCheckTF = session.selectOne("kjhWishCheck", item);
			System.out.println("ItemRepositoryImpl wishCheck->"+wishCheckTF);
			if (wishCheckTF == false) {
				wishCheck = 0;
			} else	wishCheck = 1;
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl wishCheck Exception->"+e.getMessage());
		}
		return wishCheck;
	}

	@Override
	public int itemUpdate(Item item) {
		int result = 0;
		System.out.println("ItemRepositoryImpl  itemUpdate Start...");
		try {
			System.out.println("itemno -> " + item.getItemno());
			result = session.update("kjhItemUpdate",item);
		}catch (Exception e) {
			System.out.println("ItemRepositoryImpl itemUpdate Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int itemDelete(Item item) {
		System.out.println("ItemRepositoryImpl itemDelete Start");
		int result = 0;
		try {
			result = session.delete("kjhitemDelete", item);
		}catch (Exception e) {
			System.out.println("ItemRepositoryImpl itemDelete Exception -> " + e.getMessage());
		}
		return result;
	}


}
