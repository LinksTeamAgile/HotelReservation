package com.links.ressys.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.*;
import org.sqlite.jdbc4.JDBC4Connection;

import com.links.ressys.core.*;

public class DBConnection {

	private String URL = "jdbc:sqlite:/Documents/GitHub/HotelReservation/res/HotelReservation.sqlite";
	private String userName = "";
	private String password = "";

	
	public DBConnection() {
		// TODO Auto-generated constructor stub
	}
	public static void main (String[] args) {
		DBConnection dbc = new DBConnection();
		try {
			dbc.getRooms();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Room[] getRooms() throws Exception{
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		String query = "SELECT * FROM room";
		try(Connection con = DriverManager.getConnection(URL);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)){
			while(rs.next()) {
				System.out.println(rs.getInt("idRoom"));
				System.out.println(rs.getInt("isServiceable"));
				System.out.println(rs.getInt("isAvailable"));
				System.out.println(rs.getInt("maxGuest"));
				System.out.println(rs.getString("services"));
				System.out.println("____________________________");

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
