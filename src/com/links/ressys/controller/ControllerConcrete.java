package com.links.ressys.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
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
				this.makeCreateRoom();
				break;
			case 2: // deleteRoom(,...)
				System.out.println("method for DeleteRoom");
				break;
			case 3:
				super.sys.showRoom(null);
				break;
			case 4:
				this.makeCreateCustomer();
				break;
			case 5: // deleteCustomer(,...)
				System.out.println("method for DeleteRoom");
				break;
			case 6:
				super.sys.showCustomer(null);
				break;
			case 7:
				this.makeCreateReservation();
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
			super.gui.viewMenu();
		}
	}

	private void makeCreateCustomer() {
		String taxCode = this.gui.getInput("Insert tax code:");
		String name = this.gui.getInput("Insert name:");
		String surName = this.gui.getInput("Insert surname:");
		String cellPhone = this.gui.getInput("Insert phone number:");
		String mail = this.gui.getInput("Insert email:");
		String cardNumber = this.gui.getInput("Insert card number:");
		super.sys.createCustomer(taxCode, name, surName, cellPhone, mail, cardNumber);
		if (!super.sys.isThereAnError()) {
			System.out.println("Customer create successfully!");
		} else {
			System.out.println(super.sys.getLastErrors());
			System.out.println("Customer not create!");
		}
	}

	private void makeCreateRoom() {
		int maxGuests = getRoomGuestsFromKeyboard();
		String[] services = getRoomServicesFromKeyboard();
		int codeOperation = 0;
		for (String service : services) {
			if (!service.equals(null) && maxGuests != 0 && maxGuests != -1) {
				codeOperation = 100;
			} else {
				codeOperation = 200;
			}
		}
		if (codeOperation == 100) {
			super.sys.createRoom(maxGuests, services);
			if (!super.sys.isThereAnError()) {
				System.out.println("Room create successfully!");
			} else {
				System.out.println(super.sys.getLastErrors());
				System.out.println("Room not create!");
			}
		}
	}

	private void makeCreateReservation() {
		int idCostumer = getCostumerIdFromKeyboard();
		int[] idRoom = getRoomIdFromKeyboard();
		LocalDate[] dates = getDatesFromKeyboard();
		super.sys.createReservation(idCostumer, idRoom, dates[0], dates[1]);
		if (!super.sys.isThereAnError()) {
			System.out.println("Reservation create successfully!");
		} else {
			System.out.println(super.sys.getLastErrors());
			System.out.println("Reservation not create!");
		}
	}

	public int checkRoomScanneredInformation() {
		int codeOperation = 0;

		return codeOperation;
	}

	public int getRoomGuestsFromKeyboard() {
		boolean continueScanneringUserInput = true;
		int scanneredNumber = 0;

		scanneredNumber = scannerIntegerInput();

		return scanneredNumber;
	}

	public String[] getRoomServicesFromKeyboard() {
		int serviceCounter = 0, pairNumber = 0;
		boolean continueScanneringUserInput = true, stopScanneringInput = true;
		Scanner keyboard = new Scanner(System.in);

		String scanneredService = "", scanneredChoice = "";
		ArrayList<String> scanneredServices = new ArrayList<>();

		while (continueScanneringUserInput == true) {
			System.out.println("Digit the word exit to stop typing services.Please enter\n"
					+ "the type of services that you want in your room: ");
			try {
				scanneredService = keyboard.nextLine();
				if (scanneredService.equals("exit")) {
					System.out.println("Back to the main menù");
					continueScanneringUserInput = false;
				} else if (scanneredService.isEmpty() == true
						|| scanneredService.matches("[0-9]+") && scanneredService.length() > 0) {
					System.out.println("Choice not valid!");
				} else {
					scanneredServices.add(scanneredService);
					serviceCounter += 1;
					stopScanneringInput = true;
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}

		String[] services = new String[serviceCounter];

		for (int i = 0; i < serviceCounter; i++) {
			services[i] = scanneredServices.get(i);
		}
		return services;
	}

	public int getCostumerIdFromKeyboard() {
		Scanner keyboard = new Scanner(System.in);
		boolean continueScanneringUserInput = true;
		int scanneredCustomerId = 0;

		while (continueScanneringUserInput == true) {
			System.out.println("Please insert the customer's id: ");
			try {
				scanneredCustomerId = keyboard.nextInt();
				if (scanneredCustomerId == 0) {
					System.out.println("Choice not valid!\nPlease enter a vail id");
				} else {
					continueScanneringUserInput = false;
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}
		return scanneredCustomerId;
	}

	public int[] getRoomIdFromKeyboard() {
		Scanner keyboard = new Scanner(System.in);
		boolean continueScanneringUserInput = true;
		int idCounter = 0;
		int scanneredRoomId = 0;
		int[] scanneredRoomIds = new int[10];

		while (continueScanneringUserInput == true) {
			System.out.println("Please insert the rooms' id: ");
			try {
				scanneredRoomId = keyboard.nextInt();
				if (scanneredRoomId == 0) {
					System.out.println("Choice not valid!\nPlease enter a vail id");
				} else {
					scanneredRoomIds[idCounter] = scanneredRoomId;
					idCounter += 1;
					continueScanneringUserInput = false;
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}
		return scanneredRoomIds;
	}

	public LocalDate[] getDatesFromKeyboard() {
		Scanner keyboard = new Scanner(System.in);
		boolean continueScanneringUserInput = true;
		LocalDate[] scanneredDates = new LocalDate[2];
		String[] scanneredDate = new String[2];
		int scannerCounter = 0;
		int startDate[] = new int[3];
		int endDate[] = new int[3];

		while (continueScanneringUserInput == true) {
			try {
				if (scannerCounter == 0) {
					System.out.println("Please insert a start date using the YYYY-MM-DD format: ");
					scanneredDate[0] = keyboard.nextLine();
					if ((scanneredDate[0].isEmpty() == true)
							|| (scanneredDate[0].matches("\\d{4}-[01]\\d-[0-3]\\d") == false)) {
						System.out.println("Choice not valid!\nPlease enter a vail date");
					} else {
						scannerCounter += 1;
					}
				} else {
					System.out.println("Please insert an end date using the YYYY-MM-DD format: ");
					scanneredDate[1] = keyboard.nextLine();
					if ((scanneredDate[1].isEmpty() == true)
							|| (scanneredDate[0].matches("\\d{4}-[01]\\d-[0-3]\\d") == false)) {
						System.out.println("Choice not valid!\nPlease enter a vail date");
					} else {
						scannerCounter += 1;
						continueScanneringUserInput = false;
					}
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}

		String[] start = new String[3];
		start = scanneredDate[0].split("-");
		for (int i = 0; i < 3; i++) {
			startDate[i] = Integer.parseInt(start[i]);
		}

		String[] end = new String[3];
		end = scanneredDate[0].split("-");
		for (int i = 0; i < 3; i++) {
			endDate[i] = Integer.parseInt(end[i]);
		}

		scanneredDates[0] = LocalDate.of(startDate[0], startDate[1], startDate[2]);
		scanneredDates[1] = LocalDate.of(endDate[0], endDate[1], endDate[2]);

		return scanneredDates;
	}

	public boolean validIntegerInput(String input) {
		boolean isValidInteger = false;

		if (input.charAt(0) == '-') {
			System.out.println(input.charAt(0));
			if (input.length() > 10) {
			} else {
				isValidInteger = true;
			}
		} else if (input.length() <= 10) {
			isValidInteger = true;
		}

		return isValidInteger;
	}

	public int scannerIntegerInput() {
		boolean continueScanneringUserInput = true;
		int scanneredNumber = 0;
		String input = "";
		Scanner keyboard = new Scanner(System.in);

		while (continueScanneringUserInput == true) {
			System.out.println("Please enter the number of guests: ");
			try {
				input = keyboard.nextLine();
				if (input.isEmpty() == true) {
				} else if (input.matches("[0-9]+") && input.length() > 0) {
					if (validIntegerInput(input) == true) {
						scanneredNumber = Integer.parseInt(input);
						continueScanneringUserInput = false;
					} else {
						System.out.println("Choice not valid!\nPlease entered a valid number of guests.");
					}
				} else {
					System.out.println("Choice not valid!\nPlease entered a valid number of guests.");
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				break;
			}
		}

		return scanneredNumber;
	}
}