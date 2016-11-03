package com.links.ressys.checker;

import java.time.LocalDate;
import java.util.ArrayList;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.Room;
import com.links.ressys.statuscodes.CustomerCode;
import com.links.ressys.statuscodes.ReservationCode;
import com.links.ressys.statuscodes.RoomCode;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckerReservation.
 */
public class CheckerReservation implements Checker{

	/** The res. */
	private Reservation res;

	
	/**
	 * Instantiates a new checker reservation.
	 *
	 * @param r the r
	 */
	public CheckerReservation(Reservation r){
		this.res = r;
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.checker.Checker#check()
	 */
	@Override
	public ArrayList<Integer> check() {
		ArrayList<Integer> check = new ArrayList<Integer>();
		check.add(checkCustomer());
	    check.add(checkRooms());
	    check.add(checkStartDate());
	    check.add(checkEndDate());
	    return check;	
	}
	
	/**
	 * Check customer.
	 *
	 * @return the int
	 */
	private int checkCustomer(){
		CheckerCustomer custchecker = new CheckerCustomer(res.getCustomer());
		ArrayList<Integer> errorList = custchecker.check();
		for (Integer i:errorList)
			if(!i.equals(CustomerCode.SUCCESS_CUSTOMER.getCode()))
				return i;
		return ReservationCode.SUCCESS_RESERVATION.getCode();
	}	
		
	
	/**
	 * Check rooms.
	 *
	 * @return the int
	 */
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
	
	/**
	 * Check start date.
	 *
	 * @return the int
	 */
	private int checkStartDate(){
		if(res.getStartDate()==null)
			return ReservationCode.EMPTY_STARTDATE.getCode();
		else if(res.getStartDate().isBefore(LocalDate.now()))
			return ReservationCode.INVALID_DATE.getCode();
		else
			return ReservationCode.SUCCESS_RESERVATION.getCode();
	}
	
	/**
	 * Check end date.
	 *
	 * @return the int
	 */
	private int checkEndDate(){
		if(res.getEndDate()==null)
			return ReservationCode.EMPTY_ENDDATE.getCode();
		else if(res.getEndDate().isAfter(res.getStartDate()) || !res.getEndDate().isAfter(LocalDate.now().plusDays(1)))
			return ReservationCode.INVALID_DATE.getCode();
		else
			return ReservationCode.SUCCESS_RESERVATION.getCode();
	}
	
}