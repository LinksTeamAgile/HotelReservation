package com.links.ressys.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private String URL = "jdbc:sqlite:/Documents/GitHub/HotelReservation/res/HotelReservation.sqlite";

	public static void main (String[] args) throws Exception {
		DBConnection dbc = new DBConnection();
			dbc.getRooms();
	}
	public void getRooms() throws Exception{
		String query = "SELECT * FROM room";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(URL);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
			while(rs.next()) {
				System.out.println(rs.getInt("idRoom"));
				System.out.println(rs.getInt("isServiceable"));
				System.out.println(rs.getInt("isAvailable"));
				System.out.println(rs.getInt("maxGuest"));
				System.out.println(rs.getString("services"));
				System.out.println("- - - - - - - - - - - - - -");
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}