package com.links.ressys;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

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
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	private DBConnection db;
	
	public Sys(DBConnection db){
		this.db = db;
				
		String[] services1 = { "fridge"};
		Room roomCrt1 = new RoomConcrete(1, true, true, 3,services1);
		roomList.add(roomCrt1);
		String[] services2 = {"phon"};
		Room roomCrt2 = new RoomConcrete(2, false, true, 2,services2);
		roomList.add(roomCrt2);
		String[] services3 = {"television"};
		Room roomCrt3 = new RoomConcrete(3, false, false, 1,services3);
		roomList.add(roomCrt3);
		String[] services4 = { "fridge", "television" };
		Room roomCrt4 = new RoomConcrete(4, true, true, 1,services4);
		roomList.add(roomCrt4);

		Customer customerCrt1 = new CustomerConcrete("MARRSSJ92B4N7142", "Mario", "Rossi", "3245965943", "mariorossi@gmail.com", "49237550475965433");
		customerList.add(customerCrt1);
		Customer customerCrt2 = new CustomerConcrete("FABRSS90U0T89193", "Fabio", "Rossi", "3245965949", "fabiorossi@gmail.com", "49237550475965434");
		customerList.add(customerCrt2);
		Customer customerCrt3 = new CustomerConcrete("FABNER90U0H87194", "Fabio", "Neri", "3245965944", "fabioneri@gmail.com", "49237550475965435");
		customerList.add(customerCrt3);
		
		Room[] roomArrayCrt1 = {roomCrt1};
		Room[] roomArrayCrt2 = {roomCrt2};
		Room[] roomArrayCrt3 = {roomCrt3, roomCrt4};
		Reservation reservationCrt1= new ReservationConcrete(customerCrt1, roomArrayCrt1, 1, LocalDate.of(2014, Month.FEBRUARY, 11), LocalDate.of(2014, Month.FEBRUARY, 13));
		reservationList.add(reservationCrt1);
		Reservation reservationCrt2= new ReservationConcrete(customerCrt2, roomArrayCrt3, 2, LocalDate.of(2015, Month.FEBRUARY, 15), LocalDate.of(2015, Month.FEBRUARY, 17));
		reservationList.add(reservationCrt2);
		Reservation reservationCrt3= new ReservationConcrete(customerCrt3, roomArrayCrt2, 3, LocalDate.of(2016, Month.FEBRUARY, 19), LocalDate.of(2016, Month.FEBRUARY, 23));
		reservationList.add(reservationCrt3);
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
	
	public void showRoom(Predicate<Room> pred) {
		if (pred!= null) {
			List<Room> filteredList = new ArrayList<Room>();
			
			for (Room p:roomList)
				if (pred.test(p))
					filteredList.add(p);

		filteredList.forEach(r -> System.out.println(r));
		} else
			roomList.forEach(r -> System.out.println(r));
		/* Old implementation:
		System.out.println("1: Visualizza tutte le stanze\n"
				+ "2: Visualizza le stanze libere\n"
				+ "3: Visualizza le stanze libere ma non ancora disponibili\n"
				+ "4: Visualizza le stanze che possono ospitare un minimo numero di persone\n"
				+ "5: Visualizza le stanze che forniscono certi servizi\n");
		
		Scanner keyboard = new Scanner(System.in);
	
		switch(keyboard.nextInt()) {
			case(1):
				roomList.forEach(r -> System.out.println(r));
				break;
			
			case(2):
				pred = p -> p.isAvailable() && p.isServiceable();
				break;
			
			case(3):
				pred = p -> p.isAvailable() && !p.isServiceable();
			break;
			case(4): {
				System.out.println("Inserire il numero minimo di persone che la stanza dovra' contenere");
				int pNumber = keyboard.nextInt();
				pred = p -> p.getMaxGuests() >= pNumber;
				break;	
			}

			case(5):		
				System.out.println("Inserire il servizio richiesto:");
				String service = keyboard.next().toLowerCase();
				
				pred = p -> Arrays.asList(p.getServices()).contains(service);
				break;
		}*/
	}

	
	public void showCustomer(Predicate<Customer> pred) {
		if (pred!= null) {
			List<Customer> filteredList = new ArrayList<Customer>();
			
			for (Customer p: customerList)
				if (pred.test(p))
					filteredList.add(p);
		
				filteredList.forEach(r -> System.out.println(r));
		} else
			customerList.forEach(r -> System.out.println(r));
		/* Old implementation:
		System.out.println("1: Visualizza tutti i clienti\n"
				+ "2: Visualizza i clienti aventi lo stesso cognome");
		
		Scanner keyboard = new Scanner(System.in);
	
		switch(keyboard.nextInt()) {
			case(1):
				customerList.forEach(r -> System.out.println(r));
				break;
			
			case(2): {
				System.out.println("Inserire il cognome del cliente:");
				String pSurname = keyboard.next();
				pred = p -> p.getSurname().compareToIgnoreCase(pSurname) == 0;
				break;	
			}
		}*/
	}
	
	public void showReservation(Predicate<Reservation> pred) {
		if (pred!= null) {
			List<Reservation> filteredList = new ArrayList<Reservation>();
			
			for (Reservation p:reservationList)
				if (pred.test(p))
					filteredList.add(p);
	 
		filteredList.forEach(r -> System.out.println(r));
		} else
			reservationList.forEach(r -> System.out.println(r));
		
		/* Old implementation:
		System.out.println("1: Visualizza tutte le prenotazioni\n"
				+ "2: Visualizza le prenotazioni eseguite da un cliente\n");
		
		Scanner keyboard = new Scanner(System.in);
	
		switch(keyboard.nextInt()) {
			case(1):
				reservationList.forEach(r -> System.out.println(r));
				break;
			
			case(2): {
				System.out.println("Inserire il codice fiscale del cliente:");
				String pSurname = keyboard.next();
				pred = p -> p.getCustomer().getTaxCode().compareToIgnoreCase(pSurname) == 0;
				break;	
			}
		}*/
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