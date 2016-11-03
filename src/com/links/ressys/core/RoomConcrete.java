package com.links.ressys.core;

import java.util.Arrays;

public class RoomConcrete extends Room{

	private int roomId;
	private boolean isServiceable;
	private boolean isAvailable;
	private int maxGuests;
	private String[] services;
	private double priceRoom;
	
	public RoomConcrete(int roomId, boolean isServiceable, boolean isAvailable, int maxGuests, String[] services, double priceRoom) {
		this.roomId = roomId;
		this.isServiceable = isServiceable;
		this.isAvailable = isAvailable;
		this.maxGuests = maxGuests;
		this.services = services;
		this.priceRoom = priceRoom;
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
		return "Room " + roomId + ":\n\tIs Serviceable = " + isServiceable + "\n\tIs Available = " + isAvailable
				+ "\n\tMax Guests = " + maxGuests + "\n\tServices = " + Arrays.toString(services) + "\n";
	}

	public double getPriceRoom() {
		return priceRoom;
	}

	public void setPriceRoom(double priceRoom) {
		this.priceRoom = priceRoom;
	}

}
