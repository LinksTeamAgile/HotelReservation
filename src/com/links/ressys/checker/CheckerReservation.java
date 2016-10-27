package com.links.ressys.checker;

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
		if(res.getStartDate()!=null)
			return 100;
		else
			return ReservationCode.EMPTY_STARTDATE.getCode();
	}
	
	private int checkEndDate(){
		if(res.getEndDate()!=null)
			return 100;
		else
			return ReservationCode.EMPTY_ENDDATE.getCode();
	}
	
}
