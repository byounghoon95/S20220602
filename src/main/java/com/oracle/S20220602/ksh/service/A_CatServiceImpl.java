package com.oracle.S20220602.ksh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Common;
import com.oracle.S20220602.ksh.repository.A_CatRepository;

@Service
public class A_CatServiceImpl implements A_CatService {
	@Autowired
	private A_CatRepository cr; //Repository와 연결
	
	@Override
	public List<Common> listAcat(Common common) {
		List<Common> catList = null;
		System.out.println("A_CatServiceImpl listAcat Start..");
		catList = cr.listAcat(common);
		System.out.println("A_CatServiceImpl listAcat catList.size() ->" + catList.size());
		return catList;
	}

	

	@Override
	public Common commBcdSelect(int i) {
		System.out.println("A_CatServiceImpl commBcd start...");
		Common commBcd = null;
		commBcd = cr.commBcdSelect(i);
		return commBcd;
	}

	@Override
	public int adminCatWrite(Common common) {
		System.out.println("A_CatServiceImpl adminCatWrite start...");
		int result = 0;
		result = cr.adminCatWrite(common);
		
		return result;
	}
	
	
	  @Override 
	  public List<Common> CatList(Common common) {
	  System.out.println("A_CatServiceImpl CatList Start....");
	  List<Common>adminCatList= null;
	  adminCatList = cr.CatList(common); 
	  for(Common adminCategoryList : adminCatList)
	  {System.out.println("A_CatServiceImpl CatList adminCatList.getMcd()->" +adminCategoryList.getMcd() );
	  System.out.println("A_CatServiceImpl CatList adminCatList.getContent())->" +adminCategoryList.getContent() ); 
	  }
	  return adminCatList; 
	  }

	@Override
	public int total_1900() {
		System.out.println("A_CatServiceImpl Start total..");
		int totCnt = cr.total_1900();
		System.out.println("A_CatServiceImpl total totCnt->"+totCnt);
		return totCnt;
	}

}
