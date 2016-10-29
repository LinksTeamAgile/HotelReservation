package com.links.ressys.core;

public class CustomerConcrete extends Customer{
	private String taxCode;
	private String name;
	private String surname;
	private String cellPhoneNumber;
	private String mailAddress;
	private String cardNumber;

	public CustomerConcrete(String taxCode, String name, String surname, String cellPhoneNumber, String mailAddress,
			String cardNumber) {
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Customer:\n\tTax Code = " + taxCode + "\n\tName = " + name + "\n\tSurname = " + surname + "\n\tCell Phone Number = "
				+ cellPhoneNumber + "\n\tMail Address = " + mailAddress + "\n\tCard Number = " + cardNumber + "\n";
	}

}
