package com.links.ressys.core;

import java.util.Arrays;

public class RoomConcrete extends Room{

	private static int roomId;
	private boolean isServiceable;
	private boolean isAvailable;
	private int maxGuests;
	private String[] services;
	
	@SuppressWarnings("static-access")
	public RoomConcrete(boolean isServiceable, boolean isAvailable, int maxGuests, String[] services) {
		this.roomId++;
		this.isServiceable = isServiceable;
		this.isAvailable = isAvailable;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
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
		return "Room " + roomId + ": Is Serviceable = " + isServiceable + ", Is Available = " + isAvailable
				+ ", Max Guests = " + maxGuests + ", Services = " + Arrays.toString(services) + "\n";
	}

}
