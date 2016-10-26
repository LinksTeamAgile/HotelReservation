/**
 * 
 */
package com.links;


import java.util.ArrayList;

import com.links.checker.CustomerChecker;
import com.links.checker.ReservationChecker;
import com.links.checker.RoomChecker;
import com.links.entities.*;
import com.links.relations.Reservation;
/**
 * @author Mirko
 *
 */
public class Main {

	public static void main(String[] args) {
		
		CustomerConcrete customerConcrete = new CustomerConcrete("SSSKVN74A01F839P",
				"Kevin","Sasso","342 042 7775","kevinciaociao@gmail.com","4023600442460293");
				
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
		ArrayList<Room> roomList = new ArrayList<Room>();
		customerList.add(customerConcrete);
		
		(new CustomerChecker(customerList)).check();
		(new ReservationChecker(reservationList)).check();
		(new RoomChecker(roomList)).check();

		for(Customer c:customerList)
			System.out.println(c);
	}
}