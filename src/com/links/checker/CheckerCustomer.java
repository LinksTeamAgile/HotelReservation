package com.links.checker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hotelReservation.Checkable;
import hotelReservation.Customer;
import hotelReservation.Reservation;
import hotelReservation.Room;

public class CheckerCustomer implements Checker{

	private Customer customer;
	
	public CheckerCustomer(Customer c){
		this.customer = c;
	}
	@Override
	public ArrayList<Integer> check() {
		
		ArrayList<Integer> check = new ArrayList();
		
		check.add(checkName());
	    check.add(checkSurname());
	    check.add(checkTaxCode());
	    check.add(checkCellPhoneNumber());
	    check.add(checkMailAddress());
	    check.add(checkCardNumber());
	    
	    return check;	
	}
	
	private int checkName(){
		if(!customer.getName().equals(""))
			return 100;
		else
			return 511;
	}
	private int checkSurname(){
		if(!customer.getSurname().equals(""))
			return 100;
		else
			return 521;
	}
	private int checkTaxCode(){
		if(!customer.getTaxCode().equals(""))
			return 100;
		else
			return 531;
	}
	private int checkCellPhoneNumber(){
		if(!customer.getCellPhoneNumber().equals(""))
			return 100;
		else
			return 541;
	}
	private int checkMailAddress(){
		if(!customer.getMailAddress().equals(""))
			return 100;
		else
			return 551;
	}
	private int checkCardNumber(){
		if(customer.getCardNumber()>0)
			return 100;
		else
			return 561;
	}
}

