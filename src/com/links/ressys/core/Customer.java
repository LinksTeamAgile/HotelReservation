package com.links.ressys.core;

public abstract class Customer{	
	
	public abstract String getTaxCode();

	public abstract void setTaxCode(String taxCode);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getSurname();

	public abstract void setSurname(String surname);

	public abstract String getCellPhoneNumber();

	public abstract void setCellPhoneNumber(String cellPhoneNumber);

	public abstract String getMailAddress();

	public abstract void setMailAddress(String mailAddress);

	public abstract long getCardNumber();

	public abstract void setCardNumber(int cardNumber);
}
