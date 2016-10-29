package com.links.ressys.core;

import java.time.LocalDate;

public abstract class Reservation{
	
	public abstract Customer getCustomer();

	public abstract void setCustomer(Customer customer);

	public abstract Room[] getRooms();

	public abstract void setRooms(Room[] rooms);

	public abstract int getReservationId();

	public abstract void setReservationId(int reservationId);

	public abstract LocalDate getStartDate();

	public abstract void setStartDate(LocalDate startDate);

	public abstract LocalDate getEndDate();

	public abstract void setEndDate(LocalDate endDate);
}
