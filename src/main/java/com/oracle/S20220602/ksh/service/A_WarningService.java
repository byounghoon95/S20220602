package com.oracle.S20220602.ksh.service;




import java.util.List;

import com.oracle.S20220602.common.domain.Warning;

public interface A_WarningService {

	int total();

	List<Warning> listWarning(Warning warning);

	Warning detail(int warno);

	/* Warning warnCatNameSelect(Warning warning); */

	int wsupdate(Warning warning);

	



}
