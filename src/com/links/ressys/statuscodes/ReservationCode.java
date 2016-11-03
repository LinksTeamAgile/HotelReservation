package com.links.ressys.statuscodes;

public enum ReservationCode {
	
    SUCCESS_RESERVATION(100, "Valid reservation"),
	
	EMPTY_CUSTOMER(411, "Customer field empty"),
	EMPTY_ROOMS(421, "Room field empty"),
	EMPTY_RESERVATIONID(431, "Reservation id field empty"),
	EMPTY_STARTDATE(441, "Start date field empty"),
	EMPTY_ENDDATE(451, "End date field empty"),
	
	WRONG_CUSTOMER(412, "Wrong customer field"),
	WRONG_ROOMS(422, "Wrong room field"),
	WRONG_RESERVATIONID(432, "Reservation id not valid"),
    WRONG_STARTDATE(442, "Start date format not valid"),
	WRONG_ENDDATE(452, "End date format not valid"),
	
    //DUPLICATE_CUSTOMER(413, "Duplicate customer field"),
	//DUPLICATE_ROOM(423, "Duplicate room field"),
	DUPLICATE_RSERVATIONID(433, "Duplicate reservation id"),
	//DUPLICATE_STARTDATE(443, "Duplicate start date field"),
	//DUPLICATE_ENDDATE(453, "Duplicate end date field");
	INVALID_DATE(403, "Invalid start date format");
	
	
	private final int code;
	private final String description;
	
	private ReservationCode(int code, String description){
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
