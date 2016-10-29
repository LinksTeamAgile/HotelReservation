package com.links.ressys;

import com.links.ressys.controller.*;
import com.links.ressys.database.DBConnection;
import com.links.ressys.database.SQLiteDBC;
import com.links.ressys.gui.*;


public class Main {
	
	public static void main(String[] args) {
		DBConnection db = new SQLiteDBC();
		Sys sys = new Sys(db);
		Gui gui = new GuiBash();
		Controller cntrl = new ControllerConcrete(sys, gui);
		cntrl.start();
	}
	
}

