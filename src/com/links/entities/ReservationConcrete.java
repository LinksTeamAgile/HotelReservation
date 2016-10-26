package hotelReservation;

import java.time.LocalDate;

public class ReservationConcrete extends Reservation {

	public ReservationConcrete(int reservationId, String customer, RoomConcrete[] rooms, LocalDate startDate,
			LocalDate endDate) {
		super(reservationId, customer, rooms, startDate, endDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		System.out.println(super.toString());

	}

}
