package com.links.ressys.checker;

import java.util.ArrayList;

import com.links.ressys.core.Room;
import com.links.ressys.statuscodes.RoomCode;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckerRoom checks the validity of the maximum number of guests and the services of a room.
 */
public class CheckerRoom implements Checker{

	/** The room. */
	private Room room;
	
	/**
	 * Instantiates a new checker room.
	 *
	 * @param r the r
	 */
	public CheckerRoom(Room r){
		this.room = r;
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.checker.Checker#check()
	 */
	
	/**
	 * This method instantiates the ArrayList check and fills it with the codes resulting from 
	 * the check on the fields of a room.
	 * 
	 * @return the ArrayList check containing the codes resulting from the check on the fields of a customer.
	 */
	@Override
	public ArrayList<Integer> check() {
		
		ArrayList<Integer> check = new ArrayList<Integer>();
		
		check.add(checkMaxGuests());
	    check.add(checkServices());
	    
	    return check;	
	}
	
	/**
	 * This method checks the validity of the maximum number of guests of a room.
	 *
	 * @return the int containing the code that indicates if the string maxGuests is empty, wrong or valid.
	 */
	private int checkMaxGuests(){
		if(room.getMaxGuests()>0)
			return RoomCode.SUCCESS_ROOM.getCode();
		else
			return RoomCode.WRONG_MAXGUESTS.getCode();
	}
	
	/**
	 * This method checks the validity of the services of a room.
	 *
	 * @return the int containing the code that indicates if the array of strings services is empty, wrong or valid.
	 */
	private int checkServices(){
		if(room.getServices()!=null)
			return RoomCode.SUCCESS_ROOM.getCode();
		else
			return RoomCode.EMPTY_SERVICES.getCode();
	}
	
}
