package com.links.ressys.core;

import java.util.Arrays;
import java.util.Date;

public class ReservationConcrete extends Reservation{

	private CustomerConcrete customer;
	private RoomConcrete[] rooms;
	private int reservationId;
	private Date startDate;
	private Date endDate;

	public ReservationConcrete(CustomerConcrete customer, RoomConcrete[] rooms, int reservationId, Date startDate, Date endDate) {
		super();
		this.customer = customer;
		this.rooms = rooms;
		this.reservationId = reservationId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CustomerConcrete getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerConcrete customer) {
		this.customer = customer;
	}

	public RoomConcrete[] getRooms() {
		return rooms;
	}

	public void setRooms(RoomConcrete[] rooms) {
		this.rooms = rooms;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation: Rooms = " + Arrays.toString(rooms) + ", Reservation Id = " + reservationId + ", Start Date = "
				+ startDate + ", End Date = " + endDate + "\n";
	}

}
