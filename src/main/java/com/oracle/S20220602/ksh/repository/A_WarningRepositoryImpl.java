package com.oracle.S20220602.ksh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Warning;

@Repository
public class A_WarningRepositoryImpl implements A_WarningRepository{
	
	@Autowired
	private SqlSession session; // 마이바티스
	
	@Override
	public int total() {
		int tot = 0;
		System.out.println("A_WarningRepositoryImpl Start total...");
		try {
			// Naming Rule  --->    Map ID
			tot = session.selectOne("kshWarningTotal"); // 한줄로 왔을때 :selectOne ,여러줄로오면:selectList
			System.out.println("A_WarningRepositoryImpl total tot->" + tot);
		} catch (Exception e) {
			System.out.println("A_WarningRepositoryImpl toal Exception->" + e.getMessage());
		}

		return tot;
	}

	@Override
	public List<Warning> listWarning(Warning warning) {
		List<Warning> warningList = null;
		System.out.println("A_WarningRepositoryImpl listMember Start ...");
		try {
			// Naming Rule                    Map ID           Parameter(파라메터에 여러개를 집어 넣을 떈 dto)
			warningList = session.selectList("kshWarningList", warning);
			System.out.println("A_WarningRepositoryImpl.size() -->"+warningList.size());
		} catch (Exception e) {
			System.out.println("A_WarningRepositoryImpl listMember Exception->" + e.getMessage());
		}
		return warningList;
	}

	@Override
	public Warning detail(int warno) {
		System.out.println("A_WarningRepositoryImpl  Warning detail Start...");
		Warning warning = new Warning();
		try {
			// 프라이머리키인 warno로 가져오기 떄문에 selectOne                  
			warning = session.selectOne("kshWarningDetail", warno);
			 System.out.println("A_WarningRepositoryImpll getName -->"+warning.getWarnid());
		} catch (Exception e) {
			System.out.println("A_WarningRepositoryImpl detail Exception->" + e.getMessage());
		}
		
		return warning;
	}

	/*
	 * @Override public Warning warnCatNameSelect(Warning warning) {
	 * System.out.println("A_WarningRepositoryImpl  warnCatNameSelect Start...");
	 * Warning warnCatName = null;
	 *  try { warnCatName =
	 * session.selectOne("kshWarnCatName",warning);
	 * System.out.println("ItemServiceImpl warnCatName->"+warnCatName.getWarnid());
	 * System.out.println("ItemServiceImpl warnCatName->"+warnCatName.getItemno());
	 * System.out.println("ItemServiceImpl warnCatName->"+warnCatName.getBoardno());
	 * if(warnCatName.getWarnid() != null) { warning.setWarnCatName("회원신고"); } else
	 * if(warnCatName.getItemno() != 0) { warning.setWarnCatName("상품신고"); } else
	 * if(warnCatName.getBoardno() != 0) { warning.setWarnCatName("게시물신고"); }
	 * System.out.println("ItemServiceImpl warnCatName->"+warning.getWarnCatName());
	 * 
	 * }catch(Exception e){
	 * System.out.println("A_WarningRepositoryImpl wishCheck Exception->"+e.
	 * getMessage()); }
	 * 
	 * return warning; }
	 */

	@Override
	public int wsupdate(Warning warning) {
		System.out.println("A_WarningRepositoryImpl wsupdate Start");
		int result = 0;
		try {
			System.out.println("warning.getWarstatus -> " + warning.getWarstatus());
			result = session.update("kshWarState", warning);
		}catch (Exception e) {
			System.out.println("A_WarningRepositoryImpl  wsupdate Exception -> " + e.getMessage());
		}
		return result;
	}



}
