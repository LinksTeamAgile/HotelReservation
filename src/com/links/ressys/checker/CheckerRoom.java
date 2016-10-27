package com.links.ressys.checker;

import java.util.ArrayList;

import com.links.ressys.core.Room;
import com.links.ressys.statuscodes.RoomCode;

public class CheckerRoom implements Checker{

	private Room room;
	
	public CheckerRoom(Room r){
		this.room = r;
	}
	
	@Override
	public ArrayList<Integer> check() {
		
		ArrayList<Integer> check = new ArrayList<Integer>();
		
		check.add(checkMaxGuests());
	    check.add(checkServices());
	    
	    return check;	
	}
	
	private int checkMaxGuests(){
		if(room.getMaxGuests()>0)
			return 100;
		else
			return RoomCode.WRONG_MAXGUESTS.getCode();
	}
	
	private int checkServices(){
		if(room.getServices()!=null)
			return 100;
		else
			return RoomCode.EMPTY_SERVICES.getCode();
	}
	
}
