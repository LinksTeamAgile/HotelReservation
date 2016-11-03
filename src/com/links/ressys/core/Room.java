package com.links.ressys.core;

// TODO: Auto-generated Javadoc
/**
 * The Class Room.
 */
public abstract class Room{
	
	/**
	 * Gets the room id.
	 *
	 * @return the room id
	 */
	public abstract int getRoomId();

	/**
	 * Sets the room id.
	 *
	 * @param roomId the new room id
	 */
	public abstract void setRoomId(int roomId);

	/**
	 * Checks if is serviceable.
	 *
	 * @return true, if is serviceable
	 */
	public abstract boolean isServiceable();

	/**
	 * Sets the serviceable.
	 *
	 * @param isServiceable the new serviceable
	 */
	public abstract void setServiceable(boolean isServiceable);

	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	public abstract boolean isAvailable();

	/**
	 * Sets the available.
	 *
	 * @param isAvailable the new available
	 */
	public abstract void setAvailable(boolean isAvailable);

	/**
	 * Gets the max guests.
	 *
	 * @return the max guests
	 */
	public abstract int getMaxGuests();

	/**
	 * Sets the max guests.
	 *
	 * @param maxGuests the new max guests
	 */
	public abstract void setMaxGuests(int maxGuests);

	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public abstract String[] getServices();

	/**
	 * Sets the services.
	 *
	 * @param services the new services
	 */
	public abstract void setServices(String[] services);
}
