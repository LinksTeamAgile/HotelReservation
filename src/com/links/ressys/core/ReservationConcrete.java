package com.links.ressys.core;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class ReservationConcrete.
 */
public class ReservationConcrete extends Reservation {

	/** The customer. */
	private Customer customer;
	
	/** The rooms. */
	private Room[] rooms;
	
	/** The start date. */
	private LocalDate startDate;
	
	/** The end date. */
	private LocalDate endDate;
	
	/** The reservation id. */
	private int reservationId = 0;

	/**
	 * Instantiates a new reservation concrete.
	 *
	 * @param customer the customer
	 * @param rooms the rooms
	 * @param reservationId the reservation id
	 * @param localDateTime the local date time
	 * @param localDateTime2 the local date time 2
	 */
	public ReservationConcrete(Customer customer, Room[] rooms, int reservationId, LocalDate localDateTime, LocalDate localDateTime2) {
		super();
		this.customer = customer;
		this.rooms = rooms;
		this.reservationId = reservationId;
		this.startDate = localDateTime;
		this.endDate = localDateTime2;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#getCustomer()
	 */
	public Customer getCustomer() {
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#setCustomer(com.links.ressys.core.Customer)
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#getRooms()
	 */
	public Room[] getRooms() {
		return rooms;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#setRooms(com.links.ressys.core.Room[])
	 */
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#getReservationId()
	 */
	public int getReservationId() {
		return reservationId;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#setReservationId(int)
	 */
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#getStartDate()
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#setStartDate(java.time.LocalDate)
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#getEndDate()
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Reservation#setEndDate(java.time.LocalDate)
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String r = "";
		for(int i = 0; i <rooms.length; i++)
			r +="\n\t" + rooms[i].toString();
		return "Reservation:\n\tCustomer = "+customer.getName()+" "+customer.getSurname()+"\n\tID Room = " + rooms[0].getRoomId() + "\n\tReservation Id = " + reservationId + "\n\tStart Date = "
				+ startDate + "\n\tEnd Date = " + endDate + "\n\n\tRoom reserved:\n" + r;
	}

}
