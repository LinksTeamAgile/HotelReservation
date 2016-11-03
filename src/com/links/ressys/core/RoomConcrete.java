package com.links.ressys.core;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomConcrete.
 */
public class RoomConcrete extends Room{

	/** The room id. */
	private int roomId;
	
	/** The is serviceable. */
	private boolean isServiceable;
	
	/** The is available. */
	private boolean isAvailable;
	
	/** The max guests. */
	private int maxGuests;
	
	/** The services. */
	private String[] services;
	
	/**
	 * Instantiates a new room concrete.
	 *
	 * @param roomId the room id
	 * @param isServiceable the is serviceable
	 * @param isAvailable the is available
	 * @param maxGuests the max guests
	 * @param services the services
	 */
	public RoomConcrete(int roomId, boolean isServiceable, boolean isAvailable, int maxGuests, String[] services) {
		this.roomId = roomId;
		this.isServiceable = isServiceable;
		this.isAvailable = isAvailable;
		this.maxGuests = maxGuests;
		this.services = services;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#getRoomId()
	 */
	public int getRoomId() {
		return roomId;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#setRoomId(int)
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#isServiceable()
	 */
	public boolean isServiceable() {
		return isServiceable;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#setServiceable(boolean)
	 */
	public void setServiceable(boolean isServiceable) {
		this.isServiceable = isServiceable;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#isAvailable()
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#setAvailable(boolean)
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#getMaxGuests()
	 */
	public int getMaxGuests() {
		return maxGuests;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#setMaxGuests(int)
	 */
	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#getServices()
	 */
	public String[] getServices() {
		return services;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Room#setServices(java.lang.String[])
	 */
	public void setServices(String[] services) {
		this.services = services;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room " + roomId + ":\n\tIs Serviceable = " + isServiceable + "\n\tIs Available = " + isAvailable
				+ "\n\tMax Guests = " + maxGuests + "\n\tServices = " + Arrays.toString(services) + "\n";
	}

}
