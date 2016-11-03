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
	public ArrayList<Integer> check() {

		ArrayList<Integer> check = new ArrayList<Integer>();
		if (isNull()) {
			check.add(RoomCode.EMPTY_MAXGUESTS.getCode());
			check.add(RoomCode.EMPTY_SERVICES.getCode());
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

	private int checkMaxGuests() {
		if (room.getMaxGuests() > 0)
			return RoomCode.SUCCESS_ROOM.getCode();
		else
			return RoomCode.WRONG_MAXGUESTS.getCode();
	}

	private int checkServices() {
		if (room.getServices() != null)
			return RoomCode.SUCCESS_ROOM.getCode();
		else
			return RoomCode.EMPTY_SERVICES.getCode();
	}

}
