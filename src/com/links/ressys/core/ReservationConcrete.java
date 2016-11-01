package com.links.ressys.core;

import java.time.LocalDate;

public class ReservationConcrete extends Reservation {

	private Customer customer;
	private Room[] rooms;
	private LocalDate startDate;
	private LocalDate endDate;
	private static int reservationId = 0;

	public ReservationConcrete(Customer customer, Room[] rooms, LocalDate localDateTime, LocalDate localDateTime2) {
		super();
		this.customer = customer;
		this.rooms = rooms;
		this.startDate = localDateTime;
		this.endDate = localDateTime2;
		reservationId++;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation:\n\tID Room = " + rooms[0].getRoomId() + "\n\tReservation Id = " + reservationId + "\n\tStart Date = "
				+ startDate + "\n\tEnd Date = " + endDate + "\n";
	}

}
