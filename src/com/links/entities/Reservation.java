package hotelReservation;

import java.util.Arrays;
import java.time.LocalDate;

public abstract class Reservation {
	private String customer;
	private RoomConcrete[] rooms;
	private int reservationId;
	private LocalDate startDate;
	private LocalDate endDate;

	public Reservation(int reservationId, String customer, RoomConcrete[] rooms, LocalDate startDate,
			LocalDate endDate) {
		this.reservationId = reservationId;
		this.customer = customer;
		this.rooms = rooms;
		this.reservationId = reservationId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
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
		return "Reservation information: \n" + "reservatedRoom = " + Arrays.toString(rooms) + "\n" +
				"reservationId = " + reservationId + " \nstartDate = " +
				startDate + "\nendDate = " + endDate + "\n";
	}

	abstract public void print();

}
