package com.links.ressys.core;

import java.util.Date;

public abstract class Reservation{
	
	public abstract CustomerConcrete getCustomer();

	public abstract void setCustomer(CustomerConcrete customer);

	public abstract RoomConcrete[] getRooms();

	public abstract void setRooms(RoomConcrete[] rooms);

	public abstract int getReservationId();

	public abstract void setReservationId(int reservationId);

	public abstract Date getStartDate();

	public abstract void setStartDate(Date startDate);

	public abstract Date getEndDate();

	public abstract void setEndDate(Date endDate);
}
