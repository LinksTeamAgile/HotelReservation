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
		Room roomCrt1 = new RoomConcrete(601, false, false, 1,services);
		roomList.add(roomCrt1);
	}
	
	
	public void createRoom() {
		
		
	}
	
	public void showRoom() {
		for(Room r: this.roomList){
			System.out.println(r.toString());
		}
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
			System.out.println("Reservation created");	
			return 100;
		}else
			return status.get(0);
		
		}

}
