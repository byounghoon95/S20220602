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
		String selectWarnid = null;
		System.out.println("ItemRepositoryImpl  reportReg Start...");
		try {
			if(warning.getItemno() != 0 ) {
				selectWarnid = session.selectOne("kjhSelectWarnidItem",warning);
			}else if(warning.getBoardno() != 0 ) {
				selectWarnid = session.selectOne("kjhSelectWarnidBoard",warning);
			}else {
				selectWarnid = warning.getWarnid();
			}
			warning.setWarnid(selectWarnid);
			System.out.println("ItemRepositoryImpl  reportReg Warnid->"+warning.getWarnid());
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
		try {
			wishCheck = session.selectOne("kjhWishCheck", item);
			System.out.println("ItemRepositoryImpl wishCheck->"+wishCheck);
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
	public int itemDelete(Item item, Warning warning) {
		System.out.println("ItemRepositoryImpl itemDelete Start");
		int result = 0;
		int result3 = 0;
		int warnRowCnt = 0;
		try {
			result = session.delete("kjhitemDelete", item);
			System.out.println("warning boardno->"+warning.getBoardno());
			System.out.println("warning itemno->"+ warning.getItemno());
			warnRowCnt = session.selectOne("kjhWarnRowCntItem", warning);
			System.out.println("ItemRepositoryImpl itemDelete result-->"+result);
			System.out.println("ItemRepositoryImpl itemDelete warnRowCnt-->"+warnRowCnt);
			// warning의 itemno가 유일하다는 전제에 수행
			if (result>0) {
				if (warnRowCnt>0) { //Warning 테이블에 삭제하려는  itemno가 존재할때만 WarningUpdate진행
					result3 = session.update("kjhWarningUpdate", item.getItemno());
					System.out.println("ItemRepositoryImpl itemDelete WarningUpdate result3-->"+result3);
					result = result3;
				}
			}
			
		}catch (Exception e) {
			System.out.println("ItemRepositoryImpl itemDelete Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public void changeHeart(Item item) {
		System.out.println("ItemRepositoryImpl changeHeart Start");
		int wishCheck = session.selectOne("kjhWishCheck", item);
		System.out.println("wishCheck -> " + wishCheck);
		try {
			if (wishCheck == 1) {
				session.delete("kjhHeartDelete", item);
			}else {
				session.insert("kjhHeartInsert", item);
			}
		}catch (Exception e) {
			System.out.println("ItemRepositoryImpl changeHeart Exception -> " + e.getMessage());
		}
	}

	@Override
	public String resStat(Item item) {
		System.out.println("ItemRepositoryImpl resStat Start....");
		String resstat = null;
		try {
			resstat = session.selectOne("kjhResStat", item);
			System.out.println("ItemRepositoryImpl resStat  resstat->" + resstat);
		}catch(Exception e){
			System.out.println("ItemRepositoryImpl resStat Exception->"+e.getMessage());
		}
		return resstat;
	}


}
