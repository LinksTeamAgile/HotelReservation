package com.links.ressys.statuscodes;

public enum CustomerCode {
	
	SUCCESS_CUSTOMER(100, "Valid customer"),
	
	EMPTY_NAME(511, "Name field empty"),
	EMPTY_SURNAME(521, "Surname field empty"),
	EMPTY_TAXCODE(531, "TaxCode field empty"),
	EMPTY_PHONENUM(541, "Phone number field empty"),
	EMPTY_MAIL(551, "Mail field empty"),
	EMPTY_CARDNUM(561, "Card field empty"),
	
    WRONG_NAME(512, "Wrong name field"),
	WRONG_SURNAME(522, "Wrong surname field"),
	WRONG_TAXCODE(532, "Wrong Tax Code format"),
    WRONG_PHONENUM(542, "Wrong phone number format"),
	WRONG_MAIL(552, "Wrong mail format"),
	WRONG_CARDNUM(562, "Wrong card format"),
	
	//DUPLICATE_NAME(513, "Duplicate name field"),
	//DUPLICATE_SURNAME(523, "Duplicate surname field"),
	//DUPLICATE_TAXCODE(533, "Duplicate Tax Code field"),
	//DUPLICATE_PHONENUM(543, "Duplicate phone number field"),
	DUPLICATE_MAIL(553, "Duplicate mail"),
	//DUPLICATE_CARDNUM(561, "DuplicTE Card field")
	;
	
	private final int code;
	private final String description;
	
	private CustomerCode(int code, String description){
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString(){
		return code + ": " + description;
	}

}
