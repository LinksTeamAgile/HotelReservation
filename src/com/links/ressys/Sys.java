package com.links.ressys;

import java.util.ArrayList;

import com.links.ressys.core.Customer;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.Room;

import com.links.ressys.core.RoomConcrete;

public class Sys {
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	
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
	
	
}
