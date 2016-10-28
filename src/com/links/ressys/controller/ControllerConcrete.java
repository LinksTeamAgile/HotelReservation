package com.links.ressys.controller;

import com.links.ressys.Sys;
import com.links.ressys.gui.Gui;

public class ControllerConcrete extends Controller{
	
	public ControllerConcrete(Sys sys, Gui gui) {
		super(sys, gui);
	}

	public void start(){
		int choice = 0;
		
		this.gui.open();
		while(true){
			choice = Integer.valueOf(this.gui.getInput());
			switch (choice) {
				case 1: // createRoom(,...)
					System.out.println("method for CreateRoom");
					break;
				case 2: // deleteRoom(,...)
					System.out.println("method for DeleteRoom");
					break;
				case 3:
					super.sys.showRoom();
					break;
				case 4: // createCustomer(,...)
					System.out.println("method for CreateCustomer");
					break;
				case 5: // deleteCustomer(,...)
					System.out.println("method for DeleteRoom");
					break;
				case 6: // showCustomers(,...)
					super.sys.showCustomer();;
					break;
				case 7: // createReservation(,...)
					System.out.println("method for CreateReservation");
					break;
				case 8: // deleteReservation(,...)
					System.out.println("method for DeleteReservation");
					break;
				case 9: // showReservation(,...)
					super.sys.showReservation();;
					break;
				case 0: // System.exit(0)
					System.out.println("Exit!");
					System.exit(0);
					break;
				case -1:
					System.exit(1);
					break;
			}
		}
			
	};

}
