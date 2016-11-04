package com.links.ressys.checker;

import java.time.LocalDate;
import java.util.ArrayList;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.Room;
import com.links.ressys.statuscodes.CustomerCode;
import com.links.ressys.statuscodes.ReservationCode;
import com.links.ressys.statuscodes.RoomCode;

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
		CheckerCustomer custchecker = new CheckerCustomer(res.getCustomer());
		ArrayList<Integer> errorList = custchecker.check();
		for (Integer i:errorList)
			if(!i.equals(CustomerCode.SUCCESS_CUSTOMER.getCode()))
				return i;
		return ReservationCode.SUCCESS_RESERVATION.getCode();
	}	
		
	
	private int checkRooms(){ 
		Room[] roomArray = res.getRooms();
		
		for(Room r:roomArray){
			CheckerRoom custrooms = new CheckerRoom(r);
			ArrayList<Integer> errorListRooms = custrooms.check();
			for (Integer i:errorListRooms)
				if(!i.equals(RoomCode.SUCCESS_ROOM.getCode()))
					return i;
		}
			return ReservationCode.SUCCESS_RESERVATION.getCode();
	}
	
	private int checkStartDate(){
		if(res.getStartDate() == null){
			return ReservationCode.EMPTY_STARTDATE.getCode();
		} else if(res.getStartDate().isBefore(LocalDate.now())){
			return ReservationCode.WRONG_STARTDATE.getCode();
		} else {
			return ReservationCode.SUCCESS_RESERVATION.getCode();
		}
	}
	
	private int checkEndDate(){
		if(res.getEndDate() == null){
			return ReservationCode.EMPTY_ENDDATE.getCode();
		} else if(!res.getEndDate().isAfter(res.getStartDate()) || !res.getEndDate().isAfter(LocalDate.now().plusDays(1))){
			return ReservationCode.WRONG_ENDDATE.getCode();
		} else {
			return ReservationCode.SUCCESS_RESERVATION.getCode();
		}
	}
	
}