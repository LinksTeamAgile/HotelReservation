package com.links.ressys.checker;

import java.util.ArrayList;
import com.links.ressys.core.Customer;
import com.links.ressys.statuscodes.*;

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
		if(customer.getName().equals(""))
			return CustomerCode.EMPTY_NAME.getCode();
		else if(customer.getName().length()<255)
			return CustomerCode.WRONG_NAME.getCode();
		else 
			return 100;
	}
	
	private int checkSurname(){
		if(!customer.getSurname().equals("") && customer.getSurname().length()<255)
			return 100;
		else
			return CustomerCode.EMPTY_SURNAME.getCode();
	}
	
	private int checkTaxCode(){
		if(!customer.getTaxCode().equals("") )
			return 100;
		else
			return CustomerCode.EMPTY_TAXCODE.getCode();
	}
	
	private int checkCellPhoneNumber(){
		if(!customer.getCellPhoneNumber().equals(""))
			return 100;
		else
			return CustomerCode.EMPTY_PHONENUM.getCode();
	}
	
	private int checkMailAddress(){
		if(!customer.getMailAddress().equals(""))
			return 100;
		else
			return CustomerCode.EMPTY_MAIL.getCode();
	}
	
	private int checkCardNumber(){
		if(!customer.getCardNumber().equals(""))
			return 100;
		else
			return CustomerCode.EMPTY_CARDNUM.getCode();
	}
}
