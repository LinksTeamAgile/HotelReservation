package com.links.checker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hotelReservation.Checkable;
import hotelReservation.Customer;
import hotelReservation.Reservation;
import hotelReservation.Room;

public class CheckRoom implements Checker{

	private Room room;
	
	public CheckRoom(Room r){
		this.room = r;
	}
	@Override
	public ArrayList<Integer> check() {
		
		ArrayList<Integer> check = new ArrayList();
		
		check.add(checkMaxGuests());
	    check.add(checkServices());
	    
	    return check;	
	}
	
	private int checkMaxGuests(){
		if(room.getMaxGuests()>0)
			return 100;
		else
			return 311;
	}
	private int checkServices(){
		if(room.getServices()!=null)
			return 100;
		else
			return 321;
	}
	
}
