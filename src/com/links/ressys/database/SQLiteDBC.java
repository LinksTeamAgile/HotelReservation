package com.links.ressys.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.links.ressys.core.Customer;
import com.links.ressys.core.CustomerConcrete;
import com.links.ressys.core.Reservation;
import com.links.ressys.core.Room;
import com.links.ressys.core.RoomConcrete;

public class SQLiteDBC implements DBConnection {

	private final String JDBC_TYPE = "jdbc:sqlite:";
	private final String DB_PATH = "/Users/userm01/Desktop/Workspace/HotelReservation/res/HotelReservation.sqlite";
	
	@Override
	public ArrayList<Customer> getCustomers() throws Exception{
		String query = "SELECT * FROM customer";
		String sDriverName = "org.sqlite.JDBC";
		ArrayList<Customer> customer = new ArrayList<Customer>();
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
			while(rs.next()) {
				
				customer.add(new CustomerConcrete(rs.getString("taxCode"), rs.getString("name"), 
						rs.getString("surname"), rs.getString("cellPhoneNumber"), rs.getString("mailAddress"), rs.getString("cardNumber")));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;	
		
	}

	@Override
	public ArrayList<Room> getRooms() throws Exception{
		String query = "SELECT * FROM room";
		String sDriverName = "org.sqlite.JDBC";
		ArrayList<Room> room = new ArrayList<Room>();
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
			while(rs.next()) {
				room.add(new RoomConcrete(rs.getInt("idRoom"), rs.getBoolean("isServiceable"), 
						rs.getBoolean("isAvailable"), rs.getInt("maxGuest"), rs.getString("services").split(" ")));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;		
	}
	
	@Override
	public boolean createCustomer(Customer c) throws Exception{
		boolean result = false;
		
		String name = c.getName();
		String surname = c.getSurname();
		String mail = c.getMailAddress();
		String cell = c.getCellPhoneNumber();
		String card = c.getCardNumber();
		String tax = c.getTaxCode();
		
		String sql = "INSERT INTO customer (name, surname, mailAddress, cellPhoneNumber, cardNumber, taxCode) VALUES ( ?, ?, ?, ?, ?, ? )";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				PreparedStatement ps = con.prepareStatement(sql)) {
			
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
	
	@Override
	public boolean createRoom(Room r) throws Exception{
		boolean result = false;
		
		int maxGuest = r.getMaxGuests();
		boolean isServiceable = r.isServiceable();
		String[] services = r.getServices();
		String servicesConcat="";
		for(String s : services)
			servicesConcat+=" "+s;
		
		boolean isAvailable = r.isAvailable();
		
		String sql = "INSERT INTO room (maxGuest , isServiceable, services, isAvailable ) VALUES ( ?, ?, ?, ? )";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				PreparedStatement ps = con.prepareStatement(sql)) {
			
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
	
	
	
	@Override
	public boolean createReservation(Reservation r) throws Exception{
		boolean result = false;
		
		int idCustomer = getCustomerId(r.getCustomer());
		Room[] rooms = r.getRooms();
		LocalDate startDate = r.getStartDate();
		LocalDate endDate = r.getEndDate();
		

		String sql = "INSERT INTO reservation ( idCustomer, idRoom , startDate, endDate ) VALUES ( ?, ?, ?, ? )";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		for(Room room : rooms)
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				PreparedStatement ps = con.prepareStatement(sql)) {
			
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
	
	@Override
	public boolean deleteRoom(int roomIndex) throws Exception{
		boolean result = false;
		
		String sql = "DELETE FROM room WHERE idRoom = ?";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, roomIndex);
			ps.executeUpdate();
			result = true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public boolean deleteCustomer(String mailAdd) throws Exception{
		boolean result = false;
		
		String sql = "DELETE FROM customer WHERE mailAddress = ?";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, mailAdd);
			ps.executeUpdate();
			result = true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int getMaxRoomId() throws Exception{
		int maxId = 0;
		String query = "SELECT MAX(idRoom) AS maxIdRoom FROM room";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
			while(rs.next()) {
				maxId = rs.getInt("maxIdRoom");
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return maxId;
	}
	
	@Override
	public int getCustomerId(Customer customer) throws Exception{
		int maxId = 0;
		String query = "SELECT idCustomer FROM customer WHERE mailAddress = '"+customer.getMailAddress()+"'";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(JDBC_TYPE+DB_PATH);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
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
//			String[] sss={"asdasd","adasdsa"};
////			System.out.println( createCustomer(new CustomerConcrete("alberto","sanso","dfasf@fdsfs.com","551662626","sdasdas65sadasd",112232125)) );
////			System.out.println( createRoom(new RoomConcrete(500, true, true,4, sss)) );
////			System.out.println( deleteRoom(201) );
////			System.out.println(deleteCustomer("sdasdas65sadasd"));
////			System.out.println( getMaxRoomId() );
//			
//			ArrayList<Customer> listcust = getCustomers();
//			CustomerConcrete cust =(CustomerConcrete) listcust.get(0);
//			
//			ArrayList<Room> listroom = getRooms();
//			RoomConcrete[] rooom = new RoomConcrete[1];
//			rooom[0]=(RoomConcrete)listroom.get(0);
//			
////			System.out.println( getCustomerId(new CustomerConcrete("", "", "", "", "jbanksrr@squidoo.com",	55565) ) );
//			ReservationConcrete rescon = new ReservationConcrete(cust, rooom, 1000, new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(), new GregorianCalendar(2014, Calendar.MARCH, 11).getTime());
//			System.out.println( createReservation(rescon) );
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}