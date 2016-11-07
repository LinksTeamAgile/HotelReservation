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
	public ArrayList<Enum> check() {
		ArrayList<Enum> check = new ArrayList<Enum>();
		check.add(checkCustomer());
	    check.add(checkRooms());
	    check.add(checkStartDate());
	    check.add(checkEndDate());
	    return check;	
	}
	
	private Enum checkCustomer(){
		CheckerCustomer custchecker = new CheckerCustomer(res.getCustomer());
		ArrayList<Enum> errorList = custchecker.check();
		for (Enum i:errorList)
			if(!i.equals(CustomerCode.SUCCESS_CUSTOMER))
				return i;
		return ReservationCode.SUCCESS_RESERVATION;
	}	
		
	
	private Enum checkRooms(){ 
		Room[] roomArray = res.getRooms();
		
		for(Room r:roomArray){
			CheckerRoom custrooms = new CheckerRoom(r);
			ArrayList<Enum> errorListRooms = custrooms.check();
			for (Enum i:errorListRooms)
				if(!i.equals(RoomCode.SUCCESS_ROOM))
					return i;
		}
			return ReservationCode.SUCCESS_RESERVATION;
	}
	
	private Enum checkStartDate(){
		if(res.getStartDate() == null){
			return ReservationCode.EMPTY_STARTDATE;
		} else if(res.getStartDate().isBefore(LocalDate.now())){
			return ReservationCode.WRONG_STARTDATE;
		} else {
			return ReservationCode.SUCCESS_RESERVATION;
		}
	}
	
	private Enum checkEndDate(){
		if(res.getEndDate() == null){
			return ReservationCode.EMPTY_ENDDATE;
		} else if(!res.getEndDate().isAfter(res.getStartDate()) || !res.getEndDate().isAfter(LocalDate.now().plusDays(1))){
			return ReservationCode.WRONG_ENDDATE;
		} else {
			return ReservationCode.SUCCESS_RESERVATION;
		}
	}
	
}