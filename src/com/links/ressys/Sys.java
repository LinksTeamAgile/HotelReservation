package com.links.ressys;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
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
	private ArrayList<Room> roomList;
	private ArrayList<Customer> customerList;
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	private ArrayList<Integer> lastErrors;
	private DBConnection db;
	
	public Sys(DBConnection db){
		this.db = db;
		
		try {
			this.customerList = this.db.getCustomers();
			this.roomList = this.db.getRooms();
		} catch (Exception e) {
			this.customerList = new ArrayList<Customer>();
			this.roomList = new ArrayList<Room>();
			e.printStackTrace();
		}
		
		Room[] roomArrayCrt1 = {roomList.get(0)};
		Reservation reservationCrt1= new ReservationConcrete(customerList.get(0), roomArrayCrt1, 201, LocalDate.of(2014, Month.FEBRUARY, 11), LocalDate.of(2014, Month.FEBRUARY, 23));
		reservationList.add(reservationCrt1);
		Room[] roomArrayCrt2 = {roomList.get(1), roomList.get(2)};
		Reservation reservationCrt2= new ReservationConcrete(customerList.get(1), roomArrayCrt2, 202, LocalDate.of(2015, Month.FEBRUARY, 15), LocalDate.of(2015, Month.FEBRUARY, 17));
		reservationList.add(reservationCrt2);
	}
	
	public ArrayList<Integer> getLastErrors(){
		return this.lastErrors;
	}
	
	public boolean isThereAnError() {
		for(Integer errCode: this.lastErrors){
			if(errCode != 100){
				return true;
			}
		}
		return false;
	}
	
	public void createRoom(int maxGuests, String[] services){
		Room room = new RoomConcrete(this.db.getMaxRoomId()+1, true, true, maxGuests, services);
		Checker checker = new CheckerRoom(room);
		this.lastErrors = checker.check();
		if(!this.isThereAnError()) {
			roomList.add(room);
			this.db.createRoom(room);
		}
	}

	public void createCustomer(String taxCode, String name, String surname, String cellPhoneNumber, String mailAddress, String cardNumber){
		Customer customer = new CustomerConcrete(taxCode, name, surname, cellPhoneNumber, mailAddress, cardNumber);
		Checker checker = new CheckerCustomer(customer);
		this.lastErrors = checker.check();
		if(!this.isThereAnError()) {
			customerList.add(customer);
			this.db.createCustomer(customer);
		}
	}
	
	public void createReservation(int customerId, int[] roomIds, LocalDate startDate, LocalDate endDate){
	    Customer customer = this.customerList.get(customerId);
	    Room[] rooms = new Room[roomIds.length];
	    
	    for (int i=0; i < roomIds.length; i++){
	    	for(Room r : this.roomList){
	    		if(r.getRoomId() == roomIds[i]){
	    			rooms[i] = r;
	    		}
	    	}
	    }
	    
	    Reservation reservation = new ReservationConcrete(customer, rooms, this.db.getMaxReservationId()+1, startDate, endDate);
		Checker checker = new CheckerReservation(reservation);
		this.lastErrors = checker.check();
		if(!this.isThereAnError()) {
			reservationList.add(reservation);
			this.db.createReservation(reservation);
		}
	}
	
	public List<Room> showRoom(Predicate<Room> pred) {
		if (pred!= null) {
			List<Room> filteredList = new ArrayList<Room>();
			
			for (Room p:roomList)
				if (pred.test(p))
					filteredList.add(p);

			filteredList.forEach(r -> System.out.println(r));
			return filteredList;
		}
		this.roomList.forEach(r -> System.out.println(r));
		return this.roomList;
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

	
	public List<Customer> showCustomer(Predicate<Customer> pred) {
		if (pred!= null) {
			List<Customer> filteredList = new ArrayList<Customer>();
			
			for (Customer p: customerList)
				if (pred.test(p))
					filteredList.add(p);
		
			filteredList.forEach(r -> System.out.println(r));
			return filteredList;
		} 
		this.customerList.forEach(r -> System.out.println(r));
		return this.customerList;
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
	
	public List<Reservation> showReservation(Predicate<Reservation> pred) {
		if (pred!= null) {
			List<Reservation> filteredList = new ArrayList<Reservation>();
			
			for (Reservation p:reservationList)
				if (pred.test(p))
					filteredList.add(p);
	 
			filteredList.forEach(r -> System.out.println(r));
			return filteredList;
		}
		this.reservationList.forEach(r -> System.out.println(r));
		return this.reservationList;
		
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
			this.db.deleteRoom(roomId);
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
			this.db.deleteCustomer(mailAddress);
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