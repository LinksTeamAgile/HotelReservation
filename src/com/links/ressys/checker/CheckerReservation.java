package com.links.ressys.checker;

import java.util.ArrayList;
import com.links.ressys.core.Reservation;

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
			return 401;
	}
	
	private int checkRooms(){
		if(res.getRooms()!=null)
			return 100;
		else
			return 411;
	}
	
	private int checkStartDate(){
		if(res.getStartDate()!=null)
			return 100;
		else
			return 421;
	}
	
	private int checkEndDate(){
		if(res.getEndDate()!=null)
			return 100;
		else
			return 431;
	}
	
}
