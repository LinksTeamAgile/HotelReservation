package com.links.ressys.checker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.links.ressys.core.Reservation;
import com.links.ressys.statuscodes.ReservationCode;

public class CheckerReservation implements Checker{

	private Reservation res;
	
	public CheckerReservation(Reservation r){
		this.res = r;
	}
	
	@Override
	public ArrayList<Integer> check() {
		ArrayList<Integer> check = new ArrayList<Integer>();
		check.add(checkCustomer());
	    check.add(checkRooms());
	    check.add(checkStartDate());
	    check.add(checkEndDate());
	    return check;	
	}
	
	private int checkCustomer(){
		if(res.getCustomer()!=null)
			return 100;
		else
			return ReservationCode.EMPTY_CUSTOMER.getCode();
	}
	
	private int checkRooms(){
		if(res.getRooms()!=null)
			return 100;
		else
			return ReservationCode.EMPTY_ROOMS.getCode();
	}
	
	private int checkStartDate(){
		if(res.getStartDate()==null)
			return ReservationCode.EMPTY_STARTDATE.getCode();
		else if(res.getStartDate().isBefore(LocalDate.now()))
			return ReservationCode.INVALID_DATE.getCode();
		else
			return ReservationCode.SUCCESS_RESERVATION.getCode();
	}
	
	private int checkEndDate(){
		if(res.getEndDate()==null)
			return ReservationCode.EMPTY_ENDDATE.getCode();
		else if(res.getEndDate().isAfter(res.getStartDate()) || res.getEndDate().isAfter(LocalDate.now().plusDays(1)))
			return ReservationCode.INVALID_DATE.getCode();
		else
			return ReservationCode.SUCCESS_RESERVATION.getCode();
	}
	
}
