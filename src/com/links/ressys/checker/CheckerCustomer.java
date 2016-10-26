package com.links.ressys.checker;

import java.util.ArrayList;
import com.links.ressys.core.Customer;

public class CheckerCustomer implements Checker{

	private Customer customer;
	
	public CheckerCustomer(Customer c){
		this.customer = c;
	}
	
	@Override
	public ArrayList<Integer> check() {
		ArrayList<Integer> check = new ArrayList<Integer>();
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
