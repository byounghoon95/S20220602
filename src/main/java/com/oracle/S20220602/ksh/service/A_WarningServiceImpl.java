package com.oracle.S20220602.ksh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Warning;
import com.oracle.S20220602.ksh.repository.A_WarningRepository;


@Service
public class A_WarningServiceImpl implements A_WarningService{
	@Autowired
	private A_WarningRepository wr; //Repository와 연결
	
	@Override
	public int total() {
		System.out.println("A_WarningListServiceImpl Start total..");
		int totCnt = wr.total();
		System.out.println("A_WarningListServiceImpl total totCnt->"+totCnt);
		return totCnt;
	}

	@Override
	public List<Warning> listWarning(Warning warning) {
		List<Warning> warningList = null;
		System.out.println("A_WarningListServiceImpl listWarning Start..");
		warningList = wr.listWarning(warning);
		System.out.println("A_WarningListServiceImpl listWarning WarningList.size() ->" + warningList.size());
		return warningList;
	}

	@Override
	public Warning detail(int warno) {
		System.out.println("A_WarningListServiceImpl detail start...");
		Warning warning = null;
		warning = wr.detail(warno);
		return warning;
	}

	/*
	 * @Override 
	 * public Warning warnCatNameSelect(Warning warning) {
	 * System.out.println("A_WarningListServiceImpl warnCatName Start..");
	 *  Warning warnCatName = null; 
	 *  warnCatName = wr.warnCatNameSelect(warning);
	 * System.out.println("A_WarningListServiceImpl warnCatName ->" + warnCatName);
	 * return warnCatName; 
	 * }
	 */

	@Override
	public int wsupdate(Warning warning) {
		System.out.println("A_WarningListServiceImpl wsupdate Start");
		int result = 0;
		result = wr.wsupdate(warning);
		return result;
	}


	
}
