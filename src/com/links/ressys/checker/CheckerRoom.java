package com.links.ressys.checker;

import java.util.ArrayList;

import com.links.ressys.core.Room;
import com.links.ressys.statuscodes.RoomCode;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckerRoom.
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
	@Override
	public ArrayList<Integer> check() {
		
		ArrayList<Integer> check = new ArrayList<Integer>();
		
		check.add(checkMaxGuests());
	    check.add(checkServices());
	    
	    return check;	
	}
	
	/**
	 * Check max guests.
	 *
	 * @return the int
	 */
	private int checkMaxGuests(){
		if(room.getMaxGuests()>0)
			return RoomCode.SUCCESS_ROOM.getCode();
		else
			return RoomCode.WRONG_MAXGUESTS.getCode();
	}
	
	/**
	 * Check services.
	 *
	 * @return the int
	 */
	private int checkServices(){
		if(room.getServices()!=null)
			return RoomCode.SUCCESS_ROOM.getCode();
		else
			return RoomCode.EMPTY_SERVICES.getCode();
	}
	
}
