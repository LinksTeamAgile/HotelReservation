package com.links.ressys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.links.ressys.controller.*;
import com.links.ressys.database.DBConnection;
import com.links.ressys.database.SQLiteDBC;
import com.links.ressys.gui.*;


public class Main {
	
	private static Main mn = null;
	private Properties prop;
	
	private Main(){
		prop = new Properties();
		try(InputStream input = new FileInputStream("res/configs/config.properties")) {
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("MAKE A CONFIG FILE AS SPECIFIED ON THE README.md");
			System.exit(1);
		}
	}
	
	public static Main getMain(){
		if(mn == null){
			mn = new Main();
		}
		return mn;
	}
		
	
	public String getProperty(String key){
		return prop.getProperty(key);
	}
	
	
	
	public static void main(String[] args) {
		DBConnection db = new SQLiteDBC();
		Sys sys = new Sys(db);
		Gui gui = new GuiBash();
		Controller cntrl = new ControllerConcrete(sys, gui);
		cntrl.start();
	}
	
}

