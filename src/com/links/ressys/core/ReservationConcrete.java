package com.links.ressys.core;

import java.time.LocalDate;

public class ReservationConcrete extends Reservation {

	private Customer customer;
	private Room[] rooms;
	private LocalDate startDate;
	private LocalDate endDate;
	private int reservationId = 0;
	private double cost = 0;

	public ReservationConcrete(Customer customer, Room[] rooms, int reservationId, LocalDate localDateTime, LocalDate localDateTime2, double cost) {
		super();
		this.customer = customer;
		this.rooms = rooms;
		this.reservationId = reservationId;
		this.startDate = localDateTime;
		this.endDate = localDateTime2;
		this.setCost(cost);
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
		String r = "";
		for(int i = 0; i <rooms.length; i++)
			if(rooms[i] != null){
				r +="\n\t" + rooms[i].toString();
			}
		return "Reservation:\n\tCustomer = "+customer.getName()+" "+customer.getSurname()+" \n\tReservation Id = " + reservationId + "\n\tStart Date = "
				+ startDate + "\n\tEnd Date = " + endDate + "\n\n\tRoom reserved:\n" + r;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
