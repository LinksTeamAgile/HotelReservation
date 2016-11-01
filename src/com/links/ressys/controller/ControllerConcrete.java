	package com.links.ressys.controller;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.links.ressys.Sys;
import com.links.ressys.gui.Gui;

public class ControllerConcrete extends Controller {

	public ControllerConcrete(Sys sys, Gui gui) {
		super(sys, gui);
	}

	public void start() {
		int choice = 0;

		this.gui.open();

		while (true) {
			choice = Integer.valueOf(this.gui.getInput("Make a choice:"));
			switch (choice) {
			case 1:
				int codeOperation = checkRoomScanneredInformation();
				if (codeOperation == 100) {
					System.out.println("Room create successfully!");
				} else {
					System.out.println("Room not create!");
				}
				break;
			case 2: // deleteRoom(,...)
				System.out.println("method for DeleteRoom");
				break;
			case 3:
				super.sys.showRoom(null);
				break;
			case 4: // createCustomer(,...)
				String taxCode = this.gui.getInput("Insert tax code:");
				String name = this.gui.getInput("Insert name:");
				String surName = this.gui.getInput("Insert surname:");
				String cellPhone = this.gui.getInput("Insert phone number:");
				String mail = this.gui.getInput("Insert email:");
				String cardNumber = this.gui.getInput("Insert card number:");
				int success = sys.createCustomer(taxCode, name, surName, cellPhone, mail, cardNumber);
				if (success == 100) {
					System.out.println("Customer create successfully!");
				} else {
					System.out.println("Customer not create!");
				}
				break;
			case 5: // deleteCustomer(,...)
				System.out.println("method for DeleteRoom");
				break;
			case 6:
				super.sys.showCustomer(null);				
				break;
			case 7:
				int idCostumer = getCostumerIdFromKeyboard();
				int[] idRoom = getRoomIdFromKeyboard();
				LocalDate[] dates = getDatesFromKeyboard();
				try {
					//super.sys.createReservation(idCostumer, idRoom, dates[0], dates[1]);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8: // deleteReservation(,...)
				System.out.println("method for DeleteReservation");
				break;
			case 9:
				super.sys.showReservation(null);	
				break;
			case 0:
				System.out.println("Exit!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice, please retry");
				break;
			}
		}
	}

	public int checkRoomScanneredInformation() {
		int codeOperation = 0;

		int scanneredNumber = getRoomGuestsFromKeyboard();
		String[] scanneredServices = getRoomServicesFromKeyboard();
		for (String service : scanneredServices) {
			if (!service.equals(null) && scanneredNumber != 0 && scanneredNumber != -1) {
				codeOperation = 100;
			} else {
				codeOperation = 200;
			}
		}
		return codeOperation;
	}


	public int getRoomGuestsFromKeyboard() {
		boolean continueScanneringUserInput = true;
		int scanneredNumber = 0;
		Scanner keyboard = new Scanner(System.in);

		while (continueScanneringUserInput == true) {
			System.out.println("Please enter the number of guests: ");
			try {
				scanneredNumber = keyboard.nextInt();
				if (scanneredNumber <= 0 || scanneredNumber > 5) {
					System.out.println("Choice not valid!\nPlease entered a number of guests between 1 and 5.");
				} else {
					continueScanneringUserInput = false;
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
				scanneredNumber = -1;
			}
		}

		return scanneredNumber;
	}

	public String[] getRoomServicesFromKeyboard() {
		int serviceCounter = 0, pairNumber = 0;
		boolean continueScanneringUserInput = true, stopScanneringInput = true;

		String scanneredService = "", scanneredChoice = "";
		String[] scanneredServices = new String[50];

		try (Scanner keyboard = new Scanner(System.in)) {
			while (continueScanneringUserInput == true) {
				System.out.println("Please enter the type of services that you want in your room: ");
				try {
					scanneredService = keyboard.nextLine();
					if (scanneredService.isEmpty() == true) {
						System.out.println("Choice not valid!\nPlease entered a valid service");
					}
					if (scanneredService.matches("[0-9]+") && scanneredService.length() > 0) {
						System.out.println("Choice not valid!\nPlease entered a valid service");
					} else {
						scanneredServices[serviceCounter] = scanneredService;
						serviceCounter += 1;
						stopScanneringInput = true;
						if ((serviceCounter % 4) == 0) {
							while (stopScanneringInput == true) {
								System.out.println("Do you want to stop type? Please digit yes/no: ");
								scanneredChoice = keyboard.nextLine();
								if (scanneredChoice.equalsIgnoreCase("yes")) {
									stopScanneringInput = false;
									continueScanneringUserInput = false;
								} else if (scanneredChoice.isEmpty() == true) {
									System.out.println("Choice not valid!");
								} else if (scanneredChoice.equalsIgnoreCase("no")) {
									stopScanneringInput = false;
								} else {
									System.out.println("Choice not valid!");
								}
							}
						}
					}
				} catch (InputMismatchException ex) {
					System.out.println("User input is not a valid value for this method.");
					System.out.println("Exception caught: User cannot put that value as menu choice.");
					continueScanneringUserInput = false;
				}
			}
		}

		String[] services = new String[serviceCounter];

		for (int i = 0; i < serviceCounter; i++) {
			services[i] = scanneredServices[i];
		}
		return services;
	}
	
	public int getCostumerIdFromKeyboard(){
		Scanner keyboard = new Scanner(System.in);
		boolean continueScanneringUserInput = true;
		int scanneredCustomerId = 0;

		while(continueScanneringUserInput == true){
			System.out.println("Please insert the customer's id: ");
			try{
				scanneredCustomerId = keyboard.nextInt();
				if (scanneredCustomerId == 0){
					System.out.println("Choice not valid!\nPlease enter a vail id");
				} else {
					continueScanneringUserInput = false;
				}
			} catch (InputMismatchException ex){
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}
		return scanneredCustomerId;
	}
	
	public int[] getRoomIdFromKeyboard(){
		Scanner keyboard = new Scanner(System.in);
		boolean continueScanneringUserInput = true;
		int idCounter = 0;
		int scanneredRoomId = 0;
		int[] scanneredRoomIds = new int[10];

		while(continueScanneringUserInput == true){
			System.out.println("Please insert the rooms' id: ");
			try{
				scanneredRoomId = keyboard.nextInt();
				if (scanneredRoomId == 0){
					System.out.println("Choice not valid!\nPlease enter a vail id");
				} else {
					scanneredRoomIds[idCounter] = scanneredRoomId;
					idCounter += 1;
					continueScanneringUserInput = false;
				}
			} catch (InputMismatchException ex){
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}
		return scanneredRoomIds;
	}
	
	public LocalDate[] getDatesFromKeyboard(){
		Scanner keyboard = new Scanner(System.in);
		boolean continueScanneringUserInput = true;
		LocalDate[] scanneredDates = new LocalDate[2];
		String[] scanneredDate = new String[2];
		int scannerCounter = 0;
		int startDate[] = new int[3];
		int endDate[] = new int[3];

		while(continueScanneringUserInput == true){
			try{
			if(scannerCounter == 0){
				System.out.println("Please insert a start date using the YYYY-MM-DD format: ");
				scanneredDate[0] = keyboard.nextLine();
				if((scanneredDate[0].isEmpty() == true) || (scanneredDate[0].matches("\\d{4}-[01]\\d-[0-3]\\d") == false)){
					System.out.println("Choice not valid!\nPlease enter a vail date");
				} else {
					scannerCounter += 1;
				}
			}
			else{
				System.out.println("Please insert an end date using the YYYY-MM-DD format: ");
				scanneredDate[1] = keyboard.nextLine();
				if((scanneredDate[1].isEmpty() == true) || (scanneredDate[0].matches("\\d{4}-[01]\\d-[0-3]\\d") == false)){
					System.out.println("Choice not valid!\nPlease enter a vail date");
				} else {
					scannerCounter += 1;
					continueScanneringUserInput = false;
				}
			} 
		} catch (InputMismatchException ex){
			System.out.println("User input is not a valid value for this method.");
			System.out.println("Exception caught: User cannot put that value as menu choice.");
			continueScanneringUserInput = false;
			}
		}
		
		String[] start = new String[3];
		start = scanneredDate[0].split("-");
		for(int i=0; i<3; i++){
			startDate[i] = Integer.parseInt(start[i]);
		}
		
		String[] end = new String[3];
		end = scanneredDate[0].split("-");
		for(int i=0; i<3; i++){
			endDate[i] = Integer.parseInt(end[i]);
		}
		
		scanneredDates[0] = LocalDate.of(startDate[0], startDate[1], startDate[2]);
		scanneredDates[1] = LocalDate.of(endDate[0], endDate[1], endDate[2]);
		
		return scanneredDates;
	}

}

