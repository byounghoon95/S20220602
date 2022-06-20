package com.oracle.S20220602.pjh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.S20220602.common.domain.Item;
import com.oracle.S20220602.common.domain.Reservation;
//bean 들어가야지 ...
@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

	@Autowired
	private SqlSession		session;
	
	//예약 하기 insert
	@Override
	public int reservation(Reservation reser) {
		int result1=0;
		int result3=0;
		System.out.println("ReservationRepositoryImpl reservation Start...");
		System.out.println("ReservationRepositoryImpl reservation id->"+reser.getSessionId());
		try {
			result1 = session.insert("pjhReservation", reser);
			if (result1>0) {
				result3 = session.update("pjhResCondition", reser);
			}
			System.out.println("ReservationRepositoryImpl reservation result1->" + result1);
			System.out.println("ReservationRepositoryImpl reservation getItemno->" + reser.getItemno());
			System.out.println("ReservationRepositoryImpl reservation result3->" + result3);
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl reservation Exception ->" +e.getMessage());
		}
		return result1;
	}
	
	//ReservationList
	@Override
	public int total() {
		int total = 0;
		System.out.println("ReservationRepositoryImpl total start..");
		try {
			total = session.selectOne("pjhReservItemCount");
			System.out.println("ReservationRepositoryImpl total->"+ total);
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl total() Exception->"+e.getMessage());
		}
		return total;
	}
	//예약내역전체조회

	@Override
	public List<Item> reserItemSelect(Item item) {
		List<Item> reservItemList = null;
		System.out.println("ReservationRepositortImpl itemReserItemList Start..");
		try {
			reservItemList = session.selectList("pjhReservationList", item);
			System.out.println("ReservationRepositoryImpl reservItemSelect reservItemSelect.size()->" +reservItemList.size());
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl reservItemSelect Exception->" + e.getMessage());
		}
		return reservItemList;
	}

	@Override
	public Reservation reservationDetail(int itemno) {
		System.out.println("ReservationRepositoryImpl reservationDetail Start..");
		Reservation reserItem =null;
		try {
			reserItem = session.selectOne("pjhReservationDetail", itemno);
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl exception -> " + e.getMessage());
		}
		return reserItem;
	}

	@Override
	public int reservationUpdate(Reservation reser) {
		System.out.println("ReservationRepositoryImpl reservationUpdate start..");
		int result =0;
		try {
			System.out.println("reseritemno->" + reser.getItemno());
			result = session.update("pjhreservationUpdate", reser);
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl exception -> " + e.getMessage());
		}

		return result;
	}

	@Override
	public int reservationDelete(Reservation reser) {
		System.out.println("ReservationRepository reservationDelete Start..");
		int result = 0;
		try {
			
			
			result = session.update("pjhreservationDelete", reser);
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl exception->"+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public int dealComment(Reservation reser) {
		System.out.println("ReservationRepository dealComment Start");
		
		int result1 = 0;
		int result2 = 0;
		try {
			if (reser.getSmcd() ==601) {
			result1 = session.update("pjhdealComment1", reser);
			}
			if(reser.getSmcd() ==602) {
			result2 = session.update("pjhdealComment2", reser);	
			}
				
			
			System.out.println("itmeno->" + reser.getItemno());
			System.out.println("id->" + reser.getId());	
		} catch (Exception e) {
			System.out.println("reservationRepositoryImpl exception" + e.getMessage());
		}
		
		return result1;
	}

	@Override
	public int dealCompl(Reservation reser) {
		System.out.println("ReservationRepository dealCompl Start");
		int result = 0;
		try {
			result =session.update("pjhdealCompl", reser);
		} catch (Exception e) {
			System.out.println("reservationRepositoryImpl exception" + e.getMessage());
		}
		
		return result;
	}

	@Override
	public Reservation dealCommentDetail(int itemno) {
		System.out.println("ReservationRepositoryImpl dealCommentDetail Start..");
		Reservation reserItem =null;
		try {
			reserItem = session.selectOne("pjhdealCommentDetail", itemno);
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl exception -> " + e.getMessage());
		}
		return reserItem;
	}

	@Override
	public Reservation dealcs(int itemno) {
		System.out.println("ReservationRepositoryImpl dealcs start");
		Reservation dealcommentsend = null;
		try {
			dealcommentsend = session.selectOne("pjhdealcs", itemno);
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl exception  ->" +e.getMessage());
		}
		
		
		return dealcommentsend;
	}

	@Override
	public Reservation dealCommentGetDetail(int itemno) {
		System.out.println("ReservaiontRepositoryImpl daelCommentDetail Start .");
		Reservation reserItem = null;
		try {
			reserItem = session.selectOne("pjhdealCommentGetDetail", itemno);
		} catch (Exception e) {
			System.out.println("ReservationRepositoryImpl Exception->" + e.getMessage());
			
		}
		return reserItem;
	}
}
