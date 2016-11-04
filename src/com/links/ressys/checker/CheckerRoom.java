package com.links.ressys.checker;

import java.util.ArrayList;

import com.links.ressys.core.Room;
import com.links.ressys.statuscodes.RoomCode;

public class CheckerRoom implements Checker {

	private Room room;

	public CheckerRoom(Room r) {
		this.room = r;
	}

	@Override
	public ArrayList<Enum> check() {

		ArrayList<Enum> check = new ArrayList<Enum>();
		if (isNull()) {
			check.add(RoomCode.EMPTY_MAXGUESTS);
			check.add(RoomCode.EMPTY_SERVICES);
			return check;
		} else {
			check.add(checkMaxGuests());
			check.add(checkServices());

			return check;
		}
	}

	private boolean isNull() {
		if (room == null)
			return true;
		else
			return false;
	}

	private Enum checkMaxGuests() {
		if (room.getMaxGuests() > 0){
			return RoomCode.SUCCESS_ROOM;
		} else {
			return RoomCode.WRONG_MAXGUESTS;
		}
	}

	private Enum checkServices() {
		if (room.getServices() != null){
			return RoomCode.SUCCESS_ROOM;
		} else if (isServicesFormatRight() == true){
			return RoomCode.SUCCESS_ROOM;
		} else {
			return RoomCode.WRONG_SERVICES;
		}
	}

	private boolean isServicesFormatRight(){
		boolean check = false;
		
		for(String s : room.getServices()){
			if(s.matches("[a-zA-Z]+")){
				check = true;	
			} 
		}
		return check;
	}

}
