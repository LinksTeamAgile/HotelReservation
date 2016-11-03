package com.links.ressys.core;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Reservation.
 */
public abstract class Reservation{
	
	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public abstract Customer getCustomer();

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public abstract void setCustomer(Customer customer);

	/**
	 * Gets the rooms.
	 *
	 * @return the rooms
	 */
	public abstract Room[] getRooms();

	/**
	 * Sets the rooms.
	 *
	 * @param rooms the new rooms
	 */
	public abstract void setRooms(Room[] rooms);

	/**
	 * Gets the reservation id.
	 *
	 * @return the reservation id
	 */
	public abstract int getReservationId();

	/**
	 * Sets the reservation id.
	 *
	 * @param reservationId the new reservation id
	 */
	public abstract void setReservationId(int reservationId);

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public abstract LocalDate getStartDate();

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public abstract void setStartDate(LocalDate startDate);

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public abstract LocalDate getEndDate();

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public abstract void setEndDate(LocalDate endDate);
}
