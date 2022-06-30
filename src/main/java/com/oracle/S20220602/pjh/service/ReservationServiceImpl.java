package com.oracle.S20220602.pjh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Reservation;
import com.oracle.S20220602.pjh.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private final ReservationRepository reservationRepository;
	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationRepository) {
		this.reservationRepository  = reservationRepository;
	}
	//insert
	@Override
	public int reservation(Reservation reser) {
		int result =0;
		System.out.println("ReservationServiceImpl Start..");
		result = reservationRepository.reservation(reser);
		
		return result;
	}
	@Override
	public int total() {
		int total = 0;
		System.out.println("ReservationServiceImpl total start..");
		total = reservationRepository.total();
		
		return total;
	}

	@Override
	public List<Item> reserSelect(Item item) {
		System.out.println("ReservationServiceImpl reservItemList");
		List<Item> reserItemList = null;
		reserItemList = reservationRepository.reserItemSelect(item);
		return reserItemList;
	}
	@Override
	public Reservation reservationDetail(int itemno) {
		System.out.println("ReservationServiceImpl reservationDetail");
		Reservation reserItem = null ;
		reserItem = reservationRepository.reservationDetail(itemno);
		return reserItem;
	}
	@Override
	public int reservationUpdate(Reservation reser) {
		System.out.println("ReservationServiceImpl reservationUpdate");
		int result =0;
		result = reservationRepository.reservationUpdate(reser);
		return result;
	}
	@Override
	public int reservationDelete(Reservation reser) {
		System.out.println("ReservationServiceImpl reservationDelet Start");
		int result =0;
		result = reservationRepository.reservationDelete(reser);
		
		return result;
	}


}
