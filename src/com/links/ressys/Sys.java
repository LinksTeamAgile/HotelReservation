package com.links.ressys;

import java.util.ArrayList;

import com.links.ressys.core.Customer;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.Room;

import com.links.ressys.core.RoomConcrete;
import com.links.ressys.database.DBConnection;

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
	
	public void showRoom(int guests) {
		DBConnection dbc = new DBConnection();
		ArrayList<RoomConcrete> rooms;
		try {
			rooms = dbc.getRooms();
			rooms.stream()
				.filter(r -> r.getMaxGuests() <= guests).forEach(r -> System.out.println(r));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		for(Room r: this.roomList){
			System.out.println(r.toString());
		}
	}
	
	
}
