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
 * The Class CheckerReservation checks the validity of a reservation.
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
	
	/**
	 * This method instantiates the ArrayList check and fills it with the codes resulting from 
	 * the check on the fields of a reservation.
	 * 
	 * @return the ArrayList check containing the codes resulting from the check on the fields of a reservation.
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
	 * This method checks the validity of the customer's fields calling the check method 
	 * from CheckerCustomer class.
	 *
	 * @return the int containing the code that indicates the status of the customer. 
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
	 * This method checks the validity of the fields of a room calling the check method
	 * from CheckerRoom class.
	 *
	 * @return the int containing the code that indicates the status of the room.
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
	 * This method checks the validity of the start date.
	 *
	 * @return the int containing the code that indicates if the string startDate is empty, invalid or valid.
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
	 * This method checks the validity of the end date.
	 *
	 * @return the int containing the code that indicates if the string endDate is empty, invalid or valid.
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