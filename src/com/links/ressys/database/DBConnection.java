package com.links.ressys.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.links.ressys.core.Room;
import com.links.ressys.core.RoomConcrete;

public class DBConnection {

	private String URL = "jdbc:sqlite:/Documents/GitHub/HotelReservation/res/HotelReservation.sqlite";

	ArrayList<Room> room = new ArrayList<Room>();

	public ArrayList<Room> getRooms() throws Exception{
		String query = "SELECT * FROM room";
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		try(Connection con = DriverManager.getConnection(URL);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
			while(rs.next()) {
				room.add(new RoomConcrete(rs.getInt("idRoom"), rs.getBoolean("isServiceable"), 
						rs.getBoolean("isAvailable"), rs.getInt("maxGuest"), rs.getString("services").split(" ")));
				/*System.out.println(rs.getInt("idRoom"));
				System.out.println(rs.getInt("isServiceable"));
				System.out.println(rs.getInt("isAvailable"));
				System.out.println(rs.getInt("maxGuest"));
				System.out.println(rs.getString("services"));
				System.out.println("- - - - - - - - - - - - - -");*/
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;		
	}
}