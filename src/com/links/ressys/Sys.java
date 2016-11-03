package com.links.ressys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
	private ArrayList<Reservation> reservationList = new ArrayList<>();
	private ArrayList<Integer> lastErrors;
	private DBConnection db;
	
	public Sys(DBConnection db){
		this.db = db;
		
		try {
			this.customerList = this.db.getCustomers();
			this.roomList = this.db.getRooms();
//			this.reservationList = this.db.getReservations();
		} catch (Exception e) {
			this.customerList = new ArrayList<Customer>();
			this.roomList = new ArrayList<Room>();
//			this.reservationList = new ArrayList<Reservation>();
			e.printStackTrace();
		}
		
	}
	
	public Iterator<Integer> getLastErrors(){
		return this.lastErrors.iterator();
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
	
	public void createReservation(String mailAddress, int[] roomIds, LocalDate startDate, LocalDate endDate){
	    Room[] rooms = new Room[roomIds.length];
	    Customer customer = null;
	    for(Customer c : this.customerList){
    		if(c.getMailAddress().equals(mailAddress)){
    			customer = c;
    		}
    	}
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
		Iterator<Room> itRoom=roomList.iterator();
		while(itRoom.hasNext()){
			Room ro=itRoom.next();
			if(ro.getRoomId()==roomId){
				itRoom.remove();
				roomRemoved=true;
			}else{
				;
			}
		}
		return roomRemoved;
	}

	public boolean deleteCustomer(String mailAddress){
		boolean customerRemoved = false;
		Iterator<Customer> itCustomer=customerList.iterator();
		while(itCustomer.hasNext()){
			Customer cust=itCustomer.next();
			if(cust.getMailAddress().equals(mailAddress)){
				itCustomer.remove();
				customerRemoved=true;
			}else{
				;
		    }
		}return customerRemoved;
	}
		


	public boolean deleteReservation(int reservationId){
		boolean reservationRemoved = false;
		Iterator<Reservation> itReservation=reservationList.iterator();
		while(itReservation.hasNext()){
			Reservation res=itReservation.next();
			if(res.getReservationId()==reservationId){
				itReservation.remove();
				reservationRemoved=true;
			}else{
				;
			}
		}if(reservationRemoved){
			return reservationRemoved;
		}else{
			System.out.println("Reservation not found");
			return reservationRemoved;
		}
	}


}