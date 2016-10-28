package com.links.ressys;

import java.util.ArrayList;

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
		Room roomCrt1 = new RoomConcrete(601, false, false, 1,services);
		roomList.add(roomCrt1);
		Customer customerCrt1 = new CustomerConcrete("DFGHFT90U0H8919", "Mario", "Rossi", "3245965943", "mariorossi@gmail.com", 49237550);
		customerList.add(customerCrt1);
		//Reservation reservationCrt1= new ReservationConcrete(customerCrt1, null, 0, null, null);
		//reservationList.add(reservationCrt1);
	}
	
	
	public void createRoom() {
		
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