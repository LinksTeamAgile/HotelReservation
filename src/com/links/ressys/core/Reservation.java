package com.links.ressys.core;

import java.util.Date;

public abstract class Reservation{
	
	public abstract Customer getCustomer();

	public abstract void setCustomer(Customer customer);

	public abstract Room[] getRooms();

	public abstract void setRooms(Room[] rooms);

	public abstract int getReservationId();

	public abstract void setReservationId(int reservationId);

	public abstract Date getStartDate();

	public abstract void setStartDate(Date startDate);

	public abstract Date getEndDate();

	public abstract void setEndDate(Date endDate);
}
