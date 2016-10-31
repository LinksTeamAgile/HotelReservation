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

public class Sys {
	private ArrayList<Room> roomList;
	private ArrayList<Customer> customerList;
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	private DBConnection db;
	
	public Sys(DBConnection db){
		this.db = db;
		try {
			this.customerList = this.db.getCustomers();
			this.roomList = this.db.getRooms();
		} catch (Exception e) {
			this.customerList = new ArrayList<Customer>();
			this.roomList = new ArrayList<Room>();
			e.printStackTrace();
		}
		
		Room[] roomArrayCrt1 = {roomList.get(0)};
		Reservation reservationCrt1= new ReservationConcrete(customerList.get(0), roomArrayCrt1, 1, LocalDate.of(2014, Month.FEBRUARY, 11), LocalDate.of(2014, Month.FEBRUARY, 23));
		reservationList.add(reservationCrt1);
	}
	
	
	public int createRoom(int maxGuests, String[] services) {
		Room room = new RoomConcrete(2, true, true, maxGuests, services);
		Checker checker = new CheckerRoom(room);
		ArrayList<Integer> errors = checker.check();
		boolean success = true;
		for(Integer i : errors) {
			if(i != 100)
				success = false;
			else
				;
		}
		if(success == true) {
			this.db.createRoom(room);
			System.out.println("Room inserted");
			return 100;
		} else 
			return errors.get(0);
	}

	public int createCustomer(String taxCode, String name, String surname, String cellPhoneNumber, String mailAddress,
			String cardNumber){
		Customer customer = new CustomerConcrete(taxCode, name, surname, cellPhoneNumber, mailAddress, cardNumber);
		Checker checker = new CheckerCustomer(customer);
		ArrayList<Integer> errors = checker.check();
		boolean success = true;
		for(Integer i : errors) {
			if(i != 100)
				success = false;
			else
				;
		}
		if(success == true) {
			this.db.createCustomer(customer);
			System.out.println("Customer created");
			return 100;
		} else 
			return errors.get(0);
	}
	
	public int createReservation(Customer customer, Room[] rooms, int reservationId, LocalDate startDate, LocalDate endDate){
		Checker checkerReservation = new CheckerReservation(new ReservationConcrete(customer, rooms, reservationId, startDate, endDate));
		ArrayList<Integer> status = new ArrayList<Integer>();
		boolean success = true;

		status = checkerReservation.check();

		for(Integer x : status)
			if(x != 100)
				success = false;

		if(success == true){
			reservationList.add(new ReservationConcrete(customer, rooms, reservationId, startDate, endDate));
			System.out.println("Reservation created");	
			return 100;
		}else
			return status.get(0);

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
			this.db.deleteRoom(roomId);
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
			this.db.deleteCustomer(mailAddress);
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