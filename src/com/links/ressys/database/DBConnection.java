package com.links.ressys.database;

import java.util.ArrayList;

import com.links.ressys.core.Customer;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.Room;

public interface DBConnection {

	ArrayList<Customer> getCustomers();

	ArrayList<Room> getRooms();
	
	ArrayList<Reservation> getReservations();

	boolean createCustomer(Customer c);

	boolean createRoom(Room r);

	boolean createReservation(Reservation r);

	boolean deleteRoom(int roomIndex);

	boolean deleteCustomer(String mailAdd);
	
	boolean deleteReservation(Reservation r);

	int getMaxRoomId();
	
	int getMaxReservationId();
	
	boolean updateReservation(Reservation oldReservation, Reservation newReservation);

}