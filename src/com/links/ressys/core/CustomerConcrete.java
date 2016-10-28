package com.links.ressys.core;

public class CustomerConcrete extends Customer{
	private String taxCode;
	private String name;
	private String surname;
	private String cellPhoneNumber;
	private String mailAddress;
	private int cardNumber;

	public CustomerConcrete(String taxCode, String name, String surname, String cellPhoneNumber, String mailAddress,
			int cardNumber) {
		super();
		this.taxCode = taxCode;
		this.name = name;
		this.surname = surname;
		this.cellPhoneNumber = cellPhoneNumber;
		this.mailAddress = mailAddress;
		this.cardNumber = cardNumber;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Customer: Tax Code = " + taxCode + ", Name = " + name + ", Surname = " + surname + ", Cell Phone Number = "
				+ cellPhoneNumber + ", Mail Address = " + mailAddress + ", Card Number = " + cardNumber + "\n";
	}

}
