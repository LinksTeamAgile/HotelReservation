package com.links.ressys.statuscodes;

public enum MailCode {
	
	SUCCESS_MAIL(100, "Valid mail"),
	
	EMPTY_MAIL(201, "Mail field empty"),
	WRONG_MAIL(202, "Wrong mail format"),
	DUPLICATE_MAIL(203, "Duplicate mail");
	
	private final int code;
	private final String description;
	
	private MailCode(int code, String description){
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
