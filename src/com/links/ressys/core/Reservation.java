package com.links.ressys.core;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Reservation{
	
	public abstract CustomerConcrete getCustomer();

	public abstract void setCustomer(CustomerConcrete customer);

	public abstract RoomConcrete[] getRooms();

	public abstract void setRooms(RoomConcrete[] rooms);

	public abstract int getReservationId();

	public abstract void setReservationId(int reservationId);

	public abstract LocalDateTime getStartDate();

	public abstract void setStartDate(LocalDateTime startDate);

	public abstract LocalDateTime getEndDate();

	public abstract void setEndDate(LocalDateTime endDate);
}
