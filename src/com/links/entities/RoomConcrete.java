package hotelReservation;

public class RoomConcrete extends Room {

	public RoomConcrete(int roomId, boolean isServiceable, int maxGuests, String[] services) {
		super(roomId, isServiceable, maxGuests, services);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		System.out.println(super.toString());
	}

}
