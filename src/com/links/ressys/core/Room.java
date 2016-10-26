package com.links.ressys.core;

public abstract class Room{
	
	public abstract int getRoomId();

	public abstract void setRoomId(int roomId);

	public abstract boolean isServiceable();

	public abstract void setServiceable(boolean isServiceable);

	public abstract boolean isAvailable();

	public abstract void setAvailable(boolean isAvailable);

	public abstract int getMaxGuests();

	public abstract void setMaxGuests(int maxGuests);

	public abstract String[] getServices();

	public abstract void setServices(String[] services);
}
