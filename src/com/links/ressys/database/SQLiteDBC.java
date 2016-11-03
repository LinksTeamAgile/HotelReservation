package com.links.ressys.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.links.ressys.Main;
import com.links.ressys.core.Customer;
import com.links.ressys.core.CustomerConcrete;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.ReservationConcrete;
import com.links.ressys.core.Room;
import com.links.ressys.core.RoomConcrete;

// TODO: Auto-generated Javadoc
/**
 * The Class SQLiteDBC.
 */
public class SQLiteDBC implements DBConnection {

	/** The jdbc type. */
	private final String JDBC_TYPE = "jdbc:sqlite:";
	
	/** The db path. */
	private final String DB_PATH = new Main().getProperty("db_path");
	
	/** The s driver name. */
	private final String S_DRIVER_NAME = "org.sqlite.JDBC";
	
	//private static final String DB_PATH = "/Users/userm06/git/HotelReservation/res/db/HotelReservation.sqlite";
	
	/**
	 * Initialization driver.
	 */
	private void initializationDriver(){
		try {
			Class.forName(S_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Connection resul set.
	 *
	 * @param query the query
	 * @return the result set
	 */
	private ResultSet connectionResulSet(String query){
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return rs;
	}
	
	/**
	 * Connection prepared statement.
	 *
	 * @param query the query
	 * @return the prepared statement
	 */
	private PreparedStatement connectionPreparedStatement(String query){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
			ps = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return ps;
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#getCustomers()
	 */
	@Override
	public ArrayList<Customer> getCustomers(){
		String query = "SELECT * FROM customer";
		ArrayList<Customer> customer = new ArrayList<Customer>();
		
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				
				customer.add(new CustomerConcrete(rs.getString("taxCode"), rs.getString("name"), 
						rs.getString("surname"), rs.getString("cellPhoneNumber"), rs.getString("mailAddress"), rs.getString("cardNumber")));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;	
		
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#getRooms()
	 */
	@Override
	public ArrayList<Room> getRooms(){
		String query = "SELECT * FROM room";
		ArrayList<Room> room = new ArrayList<Room>();
		
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				room.add(new RoomConcrete(rs.getInt("idRoom"), rs.getBoolean("isServiceable"), 
						rs.getBoolean("isAvailable"), rs.getInt("maxGuest"), rs.getString("services").split(" ")));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;		
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#getReservations()
	 */
	@Override
	public ArrayList<Reservation> getReservations(){
		String query = "SELECT idReservation, idCustomer, startDate, endDate FROM reservation GROUP BY idCustomer, startDate, endDate";
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		
		ArrayList<String> arrayRS = new ArrayList<String>();
		
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				String temp="";
				
				temp+=rs.getInt("idReservation")+",";
				temp+=rs.getInt("idCustomer")+",";
				temp+=rs.getString("startDate")+",";
				temp+=rs.getString("endDate")+",";
				
				arrayRS.add(temp);
			}
			
			for(String s : arrayRS){
				//System.out.println(s);
				reservations.add(mergeReservation(s));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#createCustomer(com.links.ressys.core.Customer)
	 */
	@Override
	public boolean createCustomer(Customer c){
		boolean result = false;
		
		String name = c.getName();
		String surname = c.getSurname();
		String mail = c.getMailAddress();
		String cell = c.getCellPhoneNumber();
		String card = c.getCardNumber();
		String tax = c.getTaxCode();
		
		String sql = "INSERT INTO customer (name, surname, mailAddress, cellPhoneNumber, cardNumber, taxCode) VALUES ( ?, ?, ?, ?, ?, ? )";

		initializationDriver();
		
		try(PreparedStatement ps = connectionPreparedStatement(sql)) {
			
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, mail);
			ps.setString(4, cell);
			ps.setString(5, ""+card);
			ps.setString(6, tax);
			
			ps.executeUpdate();
			
			result = true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#createRoom(com.links.ressys.core.Room)
	 */
	@Override
	public boolean createRoom(Room r){
		boolean result = false;
		
		int maxGuest = r.getMaxGuests();
		boolean isServiceable = r.isServiceable();
		String[] services = r.getServices();
		String servicesConcat="";
		for(String s : services)
			servicesConcat+=" "+s;
		
		boolean isAvailable = r.isAvailable();
		
		String sql = "INSERT INTO room (maxGuest , isServiceable, services, isAvailable ) VALUES ( ?, ?, ?, ? )";
		
		initializationDriver();
		
		try(PreparedStatement ps = connectionPreparedStatement(sql)) {
			
			ps.setInt(1, maxGuest);
			ps.setBoolean(2, isServiceable);
			ps.setString(3, servicesConcat);
			ps.setBoolean(4, isAvailable);
			
			ps.executeUpdate();
			
			result = true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#createReservation(com.links.ressys.core.Reservation)
	 */
	@Override
	public boolean createReservation(Reservation r){
		boolean result = false;
		
		int idCustomer = getCustomerId(r.getCustomer());
		Room[] rooms = r.getRooms();
		LocalDate startDate = r.getStartDate();
		LocalDate endDate = r.getEndDate();
		

		String sql = "INSERT INTO reservation ( idCustomer, idRoom , startDate, endDate ) VALUES ( ?, ?, ?, ? )";
		
		initializationDriver();
		
		for(Room room : rooms)
		try(PreparedStatement ps = connectionPreparedStatement(sql)) {
			
			ps.setInt(1, idCustomer);
			ps.setInt(2, room.getRoomId());
			ps.setString(3, startDate.toString());
			ps.setString(4, endDate.toString());
			
			ps.executeUpdate();
			
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Merge reservation.
	 *
	 * @param result the result
	 * @return the reservation
	 */
	private Reservation mergeReservation(String result){
		Reservation reservation = null;
		
		ArrayList<Integer> roomId = new ArrayList<Integer>();
		ArrayList<Room> room = new ArrayList<Room>();
		Customer customer = null;
		
		String reservationId = result.split(",")[0];
		String customerId = result.split(",")[1];
		String startDate = result.split(",")[2];
		String endDate = result.split(",")[3];
		
		String query ="SELECT idRoom FROM reservation WHERE idCustomer = "+customerId+
						" AND startDate = '"+startDate+"' AND endDate = '"+endDate+"' ";
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				roomId.add(rs.getInt("idRoom"));
			}
			customer = getCustomer( Integer.parseInt(customerId) );
			
			for(Integer i : roomId)
				room.add(getRoom(i));
			
			Room[] roomArray = new Room[room.size()];

			//da rifare assolutamente con dateformatter
			String[] startDateArray = startDate.split("/");
			String[] endDateArray = endDate.split("/");

			LocalDate startDateLD = LocalDate.of(Integer.parseInt(startDateArray[2]), Integer.parseInt(startDateArray[0]), Integer.parseInt(startDateArray[1]));
			LocalDate endDateLD = LocalDate.of(Integer.parseInt(endDateArray[2]), Integer.parseInt(endDateArray[0]), Integer.parseInt(endDateArray[1]));
			
			
			reservation = new ReservationConcrete(customer, 
											      room.toArray(roomArray), 
											      Integer.parseInt(reservationId), 
											      startDateLD,
											      endDateLD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reservation;
	}
	
	/**
	 * Gets the room.
	 *
	 * @param id the id
	 * @return the room
	 */
	private Room getRoom(int id){
		Room room = null;
		
		String query = "SELECT * FROM room WHERE idRoom="+id;
		
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				room = new RoomConcrete(rs.getInt("idRoom"), rs.getBoolean("isServiceable"), 
						rs.getBoolean("isAvailable"), rs.getInt("maxGuest"), rs.getString("services").split(" "));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return room;
	}
	
	/**
	 * Gets the customer.
	 *
	 * @param id the id
	 * @return the customer
	 */
	private Customer getCustomer(int id){
		Customer customer = null;
		String query = "SELECT * FROM customer WHERE idCustomer="+id;
		
		String name = "", surname = "", mailAddress = "", cellPhone = "", cardNumber = "", taxCode = "";
		
		
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				name = rs.getString("name");
				surname = rs.getString("surname");
				mailAddress = rs.getString("mailAddress");
				cellPhone = rs.getString("cellPhoneNumber");
				cardNumber = rs.getString("cardNumber");
				taxCode = rs.getString("taxCode");
			}		
			customer = new CustomerConcrete(name, surname, mailAddress, cellPhone, cardNumber, taxCode);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return customer;
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#deleteRoom(int)
	 */
	@Override
	public boolean deleteRoom(int roomIndex){
		boolean result = false;
		
		String sql = "DELETE FROM room WHERE idRoom = ?";

		initializationDriver();
		
		try(PreparedStatement ps = connectionPreparedStatement(sql)) {
			
			ps.setInt(1, roomIndex);
			ps.executeUpdate();
			result = true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#deleteCustomer(java.lang.String)
	 */
	@Override
	public boolean deleteCustomer(String mailAdd){
		boolean result = false;
		
		String sql = "DELETE FROM customer WHERE mailAddress = ?";
		
		initializationDriver();
		
		try(PreparedStatement ps = connectionPreparedStatement(sql)) {
			
			ps.setString(1, mailAdd);
			ps.executeUpdate();
			result = true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#getMaxRoomId()
	 */
	@Override
	public int getMaxRoomId(){
		int maxId = 0;
		String query = "SELECT MAX(idRoom) AS maxIdRoom FROM room";
		
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				maxId = rs.getInt("maxIdRoom");
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return maxId;
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.database.DBConnection#getMaxReservationId()
	 */
	@Override
	public int getMaxReservationId() {
		int maxId = 0;
		String query = "SELECT MAX(idReservation) AS maxIdReservation FROM reservation";
		
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				maxId = rs.getInt("maxIdReservation");
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return maxId;
	}
	
	/**
	 * Gets the customer id.
	 *
	 * @param customer the customer
	 * @return the customer id
	 */
	private int getCustomerId(Customer customer){
		int maxId = 0;
		String query = "SELECT idCustomer FROM customer WHERE mailAddress = '"+customer.getMailAddress()+"'";
		
		initializationDriver();
		
		try(ResultSet rs = connectionResulSet(query)) {
			
			while(rs.next()) {
				maxId = rs.getInt("idCustomer");
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maxId;
	}
	
//	public static void main(String[] args){
//		try {
////			String[] sss={"asdasd","adasdsa"};
////			System.out.println( createCustomer(new CustomerConcrete("alberto","sanso","dfasf@fdsfs.com","551662626","sdasdas65sadasd",112232125)) );
////			System.out.println( createRoom(new RoomConcrete(500, true, true,4, sss)) );
////			System.out.println( deleteRoom(201) );
////			System.out.println(deleteCustomer("sdasdas65sadasd"));
////			System.out.println( getMaxRoomId() );
//			
////			DBConnection db = new SQLiteDBC();
////			ArrayList<Customer> listcust = db.getCustomers();
////			
////			for (Customer customer : listcust) {
////				System.out.println(customer);
////			}
//			
//			
////			ArrayList<Room> listroom = getRooms();
////			RoomConcrete[] rooom = new RoomConcrete[1];
////			rooom[0]=(RoomConcrete)listroom.get(0);
//			
////			System.out.println( getCustomerId(new CustomerConcrete("", "", "", "", "jbanksrr@squidoo.com",	55565) ) );
////			ReservationConcrete rescon = new ReservationConcrete(cust, rooom, 1000, new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(), new GregorianCalendar(2014, Calendar.MARCH, 11).getTime());
////			System.out.println( createReservation(rescon) );
//			//System.out.println(getRoom(202).toString());
//			ArrayList<Reservation> reservations = getReservations();
//			for(Reservation r : reservations)
//				System.out.println(r.toString());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}