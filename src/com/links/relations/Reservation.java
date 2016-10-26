package com.links.relations;

import java.util.Arrays;
import java.util.Date;

import com.links.entities.*;

public class Reservation {

	private Customer customer;
	private Room[] rooms;
	private int reservationId;
	private Date startDate;
	private Date endDate;

	public Reservation(Customer customer, Room[] rooms, int reservationId, Date startDate, Date endDate) {
		super();
		this.customer = customer;
		this.rooms = rooms;
		this.reservationId = reservationId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
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
		return "Reservation [rooms=" + Arrays.toString(rooms) + ", reservationId=" + reservationId + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

}
