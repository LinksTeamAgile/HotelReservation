package com.links.ressys.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.links.ressys.core.Customer;
import com.links.ressys.core.CustomerConcrete;
import com.links.ressys.core.Room;
import com.links.ressys.core.RoomConcrete;

public class DBConnection {

	private static String URL = "jdbc:sqlite:/Users/userm01/Desktop/Workspace/HotelReservation/res/HotelReservation.sqlite";
	
	
	
	public ArrayList<Customer> getCustomers() throws Exception{
		String query = "SELECT * FROM customer";
		String sDriverName = "org.sqlite.JDBC";
		ArrayList<Customer> customer = new ArrayList<Customer>();
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(URL);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
			while(rs.next()) {
				
				customer.add(new CustomerConcrete(rs.getString("taxCode"), rs.getString("name"), 
						rs.getString("surname"), rs.getString("cellPhoneNumber"), rs.getString("mailAddress"), rs.getInt("cardNumber")));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;	
		
	}

	public ArrayList<Room> getRooms() throws Exception{
		String query = "SELECT * FROM room";
		String sDriverName = "org.sqlite.JDBC";
		ArrayList<Room> room = new ArrayList<Room>();
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(URL);
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
	
	public boolean createCustomer(Customer c) throws Exception{
		boolean result = false;
		
		String name = c.getName();
		String surname = c.getSurname();
		String mail = c.getMailAddress();
		String cell = c.getCellPhoneNumber();
		int card = c.getCardNumber();
		String tax = c.getTaxCode();
		
		String sql = "INSERT INTO customer (name, surname, mailAddress, cellPhoneNumber, cardNumber, taxCode) VALUES ( ?, ?, ?, ?, ?, ? )";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(URL);
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
		
		try(Connection con = DriverManager.getConnection(URL);
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
	
	public boolean deleteRoom(int roomIndex) throws Exception{
		boolean result = false;
		
		String sql = "DELETE FROM room WHERE idRoom = ?";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(URL);
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, roomIndex);
			ps.executeUpdate();
			result = true;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
//	public static void main(String[] args){
//		try {
//			String[] sss={"asdasd","adasdsa"};
//			System.out.println( createCustomer(new CustomerConcrete("alberto","sanso","dfasf@fdsfs.com","551662626","sdasdas65sadasd",112232125)) );
//			System.out.println( createRoom(new RoomConcrete(500, true, true,4, sss)) );
//			System.out.println( deleteRoom(201) );
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}