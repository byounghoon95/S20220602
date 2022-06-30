package com.oracle.S20220602.ksh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Common;


@Repository
public class A_CatRepositoryImpl implements A_CatRepository {
	
	@Autowired
	private SqlSession session; // 마이바티스
	
	@Override
	public List<Common> listAcat(Common common) {
		List<Common> catList = null;
		System.out.println("A_CatRepositoryImpl listMember Start ...");
		try {
			// Naming Rule                    Map ID           Parameter(파라메터에 여러개를 집어 넣을 떈 dto)
			catList = session.selectList("kshCatList", common);
			System.out.println("A_CatRepositoryImpl.size() -->"+catList.size());
		} catch (Exception e) {
			System.out.println("A_CatRepositoryImpl listMember Exception->" + e.getMessage());
		}
		return catList;
	}

	@Override
	public Common commBcdSelect(int i) {
		System.out.println("A_CatRepositoryImpl commBcdSelect Start ...");
		Common commBcd = null;
		try {
			commBcd= session.selectOne("kshCommonBcd",i);
			
		} catch (Exception e) {
			System.out.println("A_CatRepositoryImpl commBcdSelect Exception->" + e.getMessage());
			
		}
		return commBcd;
	}

	@Override
	public int adminCatWrite(Common common) {
		int result = 0;
		System.out.println("A_CatRepositoryImpl adminCatWrite Start");
		try {
			result = session.insert("kshAdminCatWrite",common);
			System.out.println("A_CatRepositoryImpl result -> " + result);

		}catch (Exception e) {
			System.out.println("A_CatRepositoryImpl adminCatWrite Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Common> CatList(Common common) {
		  System.out.println("A_CatRepositoryImpl adminCatList Start....");
	      List<Common> adminCatList = null;
	      try {
	    	  adminCatList = session.selectList("kshAdminCatList");
	         System.out.println("A_CatRepositoryImpl adminCatList.size()->"+adminCatList.size());
	         
	           for(Common adminCategoryList : adminCatList) 
	           { System.out.println("A_CatRepositoryImpl adminCatList   adminCategoryList.getMcd()->" + adminCategoryList.getMcd() );
	             System.out.println("A_CatRepositoryImpl adminCatList adminCategoryList.getContent())->" + adminCategoryList.getContent() );
	           }
	      }catch(Exception e){
	         System.out.println("A_CatRepositoryImpl CatList Exception->"+e.getMessage());
	      }
	      
	      return adminCatList;
	}

	@Override
	public int total_1900() {
		int tot = 0;
		System.out.println("A_CatRepositoryImpl Start total...");
		try {
			// Naming Rule  --->    Map ID
			tot = session.selectOne("kshCatTotal"); 
			System.out.println("A_CatRepositoryImpl total tot->" + tot);
		} catch (Exception e) {
			System.out.println("A_CatRepositoryImpl toal Exception->" + e.getMessage());
		}

		return tot;
	}
	
}
