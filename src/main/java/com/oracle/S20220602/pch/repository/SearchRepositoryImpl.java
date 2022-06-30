package com.oracle.S20220602.pch.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Board;
import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.common.domain.Item;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

	@Autowired
	private SqlSession		session;
	
	@Override
	public int total() {
		int tot = 0;
		System.out.println("SearchDaoImpl Start total..." );
		try {
			// Naming Rule     --->  Map ID
			tot = session.selectOne("PchBoardTotal");
			System.out.println("SearchDaoImpl total tot->"+tot );
		} catch (Exception e) {
			System.out.println("SearchDaoImpl total Exception->"+e.getMessage());
		}
		return tot;
	}


	@Override
	public List<Item> listItemKeyword(Item item) {
		List<Item> listItemKeyword = null;
		System.out.println("SearchDaoImpl listItemKeyword Start ...");
		System.out.println("SearchDaoImpl listItemKeyword keyword->"+item.getKeyword());
		System.out.println("SearchDaoImpl listItemKeyword cartegori->"+item.getCartegori());
		System.out.println("SearchDaoImpl listItemKeyword area->"+item.getArea());
		System.out.println("SearchDaoImpl listItemKeyword value->"+item.getValue());
		if (item.getCartegori()== null) item.setCartegori("%");
		if (item.getArea()== null)      item.setArea("%");
		if(item.getKeyword() == null)   item.setKeyword("%");
		if(item.getValue() == null)   	item.setValue("%");
		
		try {
			if (item.getGubun() == 1) {
				listItemKeyword = session.selectList("PchItemListKeyword1", item);
			} else {
				// Naming Rule     --->       Map ID        parameter
				listItemKeyword = session.selectList("PchItemListKeyword2", item);
			}
			
			System.out.println("SearchDaoImpl listItemKeyword itemList.size()->"+listItemKeyword.size());
		} catch (Exception e) {
			System.out.println("SearchDaoImpl listItemKeyword Exception->"+e.getMessage());
		}
		return listItemKeyword;
	}
	

	@Override
	public int totalItemKeyword(Item item) {
		int tot = 0;
		System.out.println("SearchDaoImpl totalKeyword Start..." );
		System.out.println("SearchDaoImpl totalKeyword item.getGubun()-->"+item.getGubun() );
		if (item.getCartegori()== null) item.setCartegori("%");
		if (item.getArea()== null)      item.setArea("%");
		if (item.getKeyword() == null)  item.setKeyword("%");
		try {
			if (item.getGubun() == 1) {
				// Naming Rule     --->       Map ID        parameter
				tot = session.selectOne("PchTotalItemKeyword1", item);
			} else {
				// Naming Rule     --->       Map ID        parameter
				tot = session.selectOne("PchTotalItemKeyword2", item);
			}
			System.out.println("SearchDaoImpl totalItemKeyword tot->"+tot );
		} catch (Exception e) {
			System.out.println("SearchDaoImpl totalItemKeyword Exception->"+e.getMessage());
		}
		return tot;
	}

	@Override
	public List<Common> listCommon(Common common) {
		List<Common> listCommon = null;
		System.out.println("SearchDaoImpl listCommon start...");
		try {
			listCommon = session.selectList("PchCommonlist",common);
			System.out.println("SearchDaoImpl listCommon listMember.size() -> " + listCommon.size());
		} catch (Exception e) {
			System.out.println("SearchDaoImpl listCommon Exception->"+e.getMessage());
		}
		return listCommon;
	}


	@Override
	public List<Common> listCartegori(Common common) {
		List<Common> listCartegori = null;
		System.out.println("SearchDaoImpl listCartegori start...");
		try {
			listCartegori = session.selectList("PchCartegorilist",common);
			System.out.println("SearchDaoImpl listCartegori listMember.size() -> " + listCartegori.size());
		} catch (Exception e) {
			System.out.println("SearchDaoImpl listCartegori Exception->"+e.getMessage());
		}
		return listCartegori;
	}



}














