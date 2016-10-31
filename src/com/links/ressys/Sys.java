package com.links.ressys;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import com.links.ressys.checker.Checker;
import com.links.ressys.checker.CheckerCustomer;
import com.links.ressys.checker.CheckerReservation;
import com.links.ressys.checker.CheckerRoom;
import com.links.ressys.core.Customer;
import com.links.ressys.core.CustomerConcrete;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.ReservationConcrete;
import com.links.ressys.core.Room;

import com.links.ressys.core.RoomConcrete;
import com.links.ressys.database.DBConnection;
import com.links.ressys.database.SQLiteDBC;

public class Sys {
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	private DBConnection db;
	
	public Sys(DBConnection db){
		this.db = db;
				
		String[] services = { "fridge", "phon", "television" };
		Room roomCrt1 = new RoomConcrete(1, false, false, 1,services);
		roomList.add(roomCrt1);
		Customer customerCrt1 = new CustomerConcrete("DFGHFT90U0H8919", "Mario", "Rossi", "3245965943", "mariorossi@gmail.com", "49237550475965433");
		customerList.add(customerCrt1);
		Room[] roomArrayCrt1 = {roomCrt1};
		Reservation reservationCrt1= new ReservationConcrete(customerCrt1, roomArrayCrt1, 1, LocalDate.of(2014, Month.FEBRUARY, 11), LocalDate.of(2014, Month.FEBRUARY, 23));
		reservationList.add(reservationCrt1);
	}
	
	public int getMaxId(String item) throws Exception {
		SQLiteDBC db = new SQLiteDBC();
		int id;
		if(item.compareTo("room") == 0) {
			id = db.getMaxRoomId() + 1;
		} else if(item.compareTo("customer") == 0) {
			id = db.getMaxCustomerId() + 1;
		} else if (item.compareTo("reservation") == 0) {
			id = db.getMaxReservationId() + 1;
		} else
			throw new Exception("Item string must be room/customer/reservation");
		return id;
	}
	
	private int checkErrors(ArrayList<Integer> errors, String item) {
		boolean success = true;
		for(Integer i : errors) {
			if(i != 100)
				success = false;
			else
				;
		}
		if(success == true) {
			System.out.println(item + " inserted");
			return 100;
		} else 
			return errors.get(0);
	}
	
	public int createRoom(int maxGuests, String[] services) throws Exception {
		String item = "room";
		int id = getMaxId(item);
		Room room = new RoomConcrete(id, true, true, maxGuests, services);
		Checker checker = new CheckerRoom(room);
		ArrayList<Integer> errors = checker.check();
		return checkErrors(errors, item);
	}

	public int createCustomer(String taxCode, String name, String surname, String cellPhoneNumber, String mailAddress,
			String cardNumber){
		String item = "customer";
		Customer customer = new CustomerConcrete(taxCode, name, surname, cellPhoneNumber, mailAddress, cardNumber);
		Checker checker = new CheckerCustomer(customer);
		ArrayList<Integer> errors = checker.check();
		return checkErrors(errors, item);
	}
	
	public int createReservation(Customer customer, Room[] rooms, LocalDate startDate, LocalDate endDate) throws Exception{
		String item = "reservation";
		int reservationId = getMaxId(item);
		Checker checkerReservation = new CheckerReservation(new ReservationConcrete(customer, rooms, reservationId, startDate, endDate));
		ArrayList<Integer> errors = checkerReservation.check();
		return checkErrors(errors, item);

	}
	
	public void showRoom() {
		roomList.forEach(r -> System.out.println(r));
	}
	
	public void showCustomer() {
		customerList.forEach(r -> System.out.println(r));
	}
	
	public void showReservation() {
		reservationList.forEach(r -> System.out.println(r));
	}

	

	public boolean deleteRoom(int roomId){
		boolean roomRemoved = false;
		for(Room r: this.roomList){
			if(r.getRoomId()==roomId){
				roomList.remove(r);
				roomRemoved = true;
			}
		}
		if(roomRemoved){
			System.out.println("Room "+roomId+" deleted");
			return roomRemoved;
		}
		else{
			System.out.println("Room not exists");
			return roomRemoved;
		}
	}

	public boolean deleteCustomer(String mailAddress){
		boolean customerRemoved = false;
		for(Customer c: this.customerList){
			if(c.getMailAddress()==mailAddress){
				customerList.remove(c);
				customerRemoved = true;
			}
		}
		if(customerRemoved){
			System.out.println("Customer with "+mailAddress+" address deleted");
			return customerRemoved;
		}
		else{
			System.out.println("Customer not exists");
			return customerRemoved;
		}

	}

	public boolean deleteReservation(int reservationId){
		boolean reservationRemoved = false;
		for(Reservation rs: this.reservationList){
			if(rs.getReservationId()==reservationId){
				reservationList.remove(rs);
				reservationRemoved = true;
			}
		}
		if(reservationRemoved){
			System.out.println("Reservation "+reservationId+" deleted");
			return reservationRemoved;
		}
		else{
			System.out.println("Reservation not exists");
			return reservationRemoved;
		}
	}


}