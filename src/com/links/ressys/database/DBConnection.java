package com.links.ressys.database;

import java.util.ArrayList;

import com.links.ressys.core.Customer;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.Room;

// TODO: Auto-generated Javadoc
/**
 * The Interface DBConnection.
 */
public interface DBConnection {

	/**
	 * Gets the customers.
	 *
	 * @return the customers
	 */
	ArrayList<Customer> getCustomers();

	/**
	 * Gets the rooms.
	 *
	 * @return the rooms
	 */
	ArrayList<Room> getRooms();
	
	/**
	 * Gets the reservations.
	 *
	 * @return the reservations
	 */
	ArrayList<Reservation> getReservations();

	/**
	 * Creates the customer.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	boolean createCustomer(Customer c);

	/**
	 * Creates the room.
	 *
	 * @param r the r
	 * @return true, if successful
	 */
	boolean createRoom(Room r);

	/**
	 * Creates the reservation.
	 *
	 * @param r the r
	 * @return true, if successful
	 */
	boolean createReservation(Reservation r);

	/**
	 * Delete room.
	 *
	 * @param roomIndex the room index
	 * @return true, if successful
	 */
	boolean deleteRoom(int roomIndex);

	/**
	 * Delete customer.
	 *
	 * @param mailAdd the mail add
	 * @return true, if successful
	 */
	boolean deleteCustomer(String mailAdd);

	/**
	 * Gets the max room id.
	 *
	 * @return the max room id
	 */
	int getMaxRoomId();
	
	/**
	 * Gets the max reservation id.
	 *
	 * @return the max reservation id
	 */
	int getMaxReservationId();

}