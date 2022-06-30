package com.oracle.S20220602.pjh.repository;

import java.util.List;

import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Reservation;

public interface ReservationRepository {

	int reservation(Reservation reser);
	
	Reservation reservationForm(int itemno);

	int total();

	List<Item> reserItemSelect(Item item);

	Reservation reservationDetail(int itemno);

	int reservationUpdate(Reservation reser);

	int reservationDelete(Reservation reser);

	int dealComment(Reservation reser);

	int dealCompl(Reservation reser);

	Reservation dealCommentDetail(int itemno);

	Reservation dealcs(int itemno);

	Reservation dealCommentGetDetail(int itemno);

	

	
	
	

}
