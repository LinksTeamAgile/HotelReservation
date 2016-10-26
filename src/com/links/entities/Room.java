package hotelReservation;

import java.util.Arrays;

public abstract class Room {
	private int roomId;
	private boolean isServiceable;
	private int maxGuests;
	private String[] services;

	public Room(int roomId, boolean isServiceable, int maxGuests, String[] services) {
		this.roomId = roomId;
		this.isServiceable = isServiceable;
		this.maxGuests = maxGuests;
		this.services = services;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public boolean isServiceable() {
		return isServiceable;
	}

	public void setServiceable(boolean isServiceable) {
		this.isServiceable = isServiceable;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public String[] getServices() {
		return services;
	}

	public void setServices(String[] services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Room information: [roomId = " + roomId + ", " + "isServiceable = " + isServiceable + ", "
				+ "maxGuests = " + maxGuests + ", " + "services = " + Arrays.toString(services) + "]";
	}

	abstract public void print();
}
