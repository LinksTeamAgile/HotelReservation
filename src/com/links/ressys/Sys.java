package com.links.ressys;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import com.links.ressys.checker.CheckerCustomer;
import com.links.ressys.checker.CheckerRoom;
import com.links.ressys.core.Customer;
import com.links.ressys.core.CustomerConcrete;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.ReservationConcrete;
import com.links.ressys.core.Room;

import com.links.ressys.core.RoomConcrete;
import com.links.ressys.database.DBConnection;

public class Sys {
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	
	public Sys(){
		String[] services = { "fridge", "phon", "television" };
		Room roomCrt1 = new RoomConcrete(false, false, 1,services);
		roomList.add(roomCrt1);
		Customer customerCrt1 = new CustomerConcrete("DFGHFT90U0H8919", "Mario", "Rossi", "3245965943", "mariorossi@gmail.com", 49237550475965433L);
		customerList.add(customerCrt1);
		RoomConcrete[] roomArrayCrt1 = {(RoomConcrete) roomCrt1};
		Reservation reservationCrt1= new ReservationConcrete((CustomerConcrete) customerCrt1, (RoomConcrete[]) roomArrayCrt1, 1, LocalDateTime.of(2010, 10, 3, 10, 4), LocalDateTime.of(2010, 10, 3, 10, 4));
		reservationList.add(reservationCrt1);
	}
	
	
	public int createRoom(int maxGuests, String[] services) {
		RoomConcrete room = new RoomConcrete(true, true, maxGuests, services);
		CheckerRoom checker = new CheckerRoom(room);
		ArrayList<Integer> errors = checker.check();
		boolean success = true;
		for(Integer i : errors) {
			if(i != 100)
				success = false;
			else
				;
		}
		if(success == true) {
			System.out.println("Room inserted");
			return 100;
		} else 
			return errors.get(0);
	}
	
	public int createCustomer(String taxCode, String name, String surname, String cellPhoneNumber, String mailAddress,
			int cardNumber){
		CustomerConcrete customer = new CustomerConcrete(taxCode, name, surname, cellPhoneNumber, mailAddress, cardNumber);
		CheckerCustomer checker = new CheckerCustomer(customer);
		ArrayList<Integer> errors = checker.check();
		boolean success = true;
		for(Integer i : errors) {
			if(i != 100)
				success = false;
			else
				;
		}
		if(success == true) {
			System.out.println("Customer created");
			return 100;
		} else 
			return errors.get(0);
	}
	
	public void showRoom() {
		roomList.forEach(r -> System.out.println(r));
			/*try {
				new DBConnection().getRooms().stream().forEach(r -> System.out.println(r));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	}
	
	public void showCustomer() {
		customerList.forEach(r -> System.out.println(r));
	}
	
	public void showReservation() {
		reservationList.forEach(r -> System.out.println(r));
	}
}