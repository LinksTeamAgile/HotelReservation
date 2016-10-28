package com.links.ressys.core;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ReservationConcrete extends Reservation{

	private CustomerConcrete customer;
	private RoomConcrete[] rooms;
	private int reservationId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public ReservationConcrete(CustomerConcrete customer, RoomConcrete[] rooms, int reservationId, LocalDateTime localDateTime, LocalDateTime localDateTime2) {
		super();
		this.customer = customer;
		this.rooms = rooms;
		this.reservationId = reservationId;
		this.startDate = localDateTime;
		this.endDate = localDateTime2;
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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation:\n\tID Room = " + rooms[0].getRoomId() + "\n\tReservation Id = " + reservationId + "\n\tStart Date = "
				+ startDate + "\n\tEnd Date = " + endDate + "\n";
	}

}
