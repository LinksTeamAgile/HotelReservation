package com.links.ressys;

import java.util.ArrayList;
import java.util.Date;

import com.links.ressys.checker.CheckerCustomer;
import com.links.ressys.checker.CheckerReservation;
import com.links.ressys.checker.CheckerRoom;
import com.links.ressys.core.Customer;
import com.links.ressys.core.CustomerConcrete;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.ReservationConcrete;
import com.links.ressys.core.Room;

import com.links.ressys.core.RoomConcrete;
import com.links.ressys.statuscodes.CustomerCode;

public class Sys {
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	private CustomerCode[] customerCodes;

	
	
	public Sys(){
		String[] services = { "fridge", "phon", "television" };
		Room roomCrt1 = new RoomConcrete(false, false, 1,services);
		roomList.add(roomCrt1);
		
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
	
	public int createReservation(CustomerConcrete customer, RoomConcrete[] rooms, int reservationId, Date startDate, Date endDate){
        CheckerReservation checkerReservation = new CheckerReservation(new ReservationConcrete(customer, rooms, reservationId, startDate, endDate));
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

}
