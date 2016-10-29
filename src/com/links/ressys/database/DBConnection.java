package com.links.ressys.database;

import java.util.ArrayList;

import com.links.ressys.core.Customer;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.Room;

public interface DBConnection {

	ArrayList<Customer> getCustomers() throws Exception;

	ArrayList<Room> getRooms() throws Exception;

	boolean createCustomer(Customer c) throws Exception;

	boolean createRoom(Room r) throws Exception;

	boolean createReservation(Reservation r) throws Exception;

	boolean deleteRoom(int roomIndex) throws Exception;

	boolean deleteCustomer(String mailAdd) throws Exception;

	int getMaxRoomId() throws Exception;

	int getCustomerId(Customer customer) throws Exception;

}