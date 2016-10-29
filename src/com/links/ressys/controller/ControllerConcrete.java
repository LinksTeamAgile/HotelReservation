package com.links.ressys.controller;

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
				int codeOperation = checkBasicRoomInformation();
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
				super.sys.showRoom();
				break;
			case 4: // createCustomer(,...)
				System.out.println("method for CreateCustomer");
				break;
			case 5: // deleteCustomer(,...)
				System.out.println("method for DeleteRoom");
				break;
			case 6: // showCustomers(,...)
				System.out.println("method for ShowRooms");
				break;
			case 7: // createReservation(,...)
				System.out.println("method for CreateReservation");
				break;
			case 8: // deleteReservation(,...)
				System.out.println("method for DeleteReservation");
				break;
			case 9: // showReservation(,...)
				System.out.println("method for ShowRooms");
				break;
			case 0: // System.exit(0)
				System.out.println("Exit!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice, please retry");
				break;
			}
		}
	}

	public int checkBasicRoomInformation() {
		/**
		 * @return 		100 if all info are correct else 200 
		 */
		int codeOperation = 0, scanneredNumber = 0;
		String[] scanneredServices = new String[5];

		scanneredNumber = getRoomGuestsFromKeyboard();
		scanneredServices = getRoomServicesFromKeyboard();

		for (int i = 0; i < 5; i++) {
			if (scanneredServices[i].isEmpty() != true) {
				if (scanneredNumber != 0 || scanneredNumber != -1) {
					codeOperation = 100;
				} else {
					codeOperation = 200;
				}
			}
		}
		return codeOperation;
	}

	public int getRoomGuestsFromKeyboard() {
		boolean continueScanneringUserInput = true;
		Scanner keyboard = new Scanner(System.in);
		int scanneredNumber = 0;

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
		int serviceCounter = 0;
		boolean continueScanneringUserInput = true;
		Scanner keyboard = new Scanner(System.in);
		String scanneredService = "";
		String[] scanneredServices = new String[5];

		while (serviceCounter < 5) {
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
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
				serviceCounter = 5;
			}
		}
		return scanneredServices;
	}

}
