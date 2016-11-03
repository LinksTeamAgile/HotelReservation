package com.links.ressys.statuscodes;

public enum RoomCode {
	
    SUCCESS_ROOM(100, "Valid room"),
	
	EMPTY_MAXGUESTS(311, "Guests field empty"),
	//EMPTY_SERVICEABLE(321, "Serviceable field empty"),
	//EMPTY_AVAILABLE(331, "Available field empty"),
	EMPTY_SERVICES(341, "Services field empty"),
	
	WRONG_MAXGUESTS(312, "Invalid number of guests"),
	//WRONG_SERVICEABLE(322, "Serviceable field not valid"),
	//WRONG_AVAILABLE(332, "Available field not valid"),
    //WRONG_SERVICES(342, "Services not valid"),
	
	//DUPLICATE_MAXGUESTS(313, "Duplicate max guests field"),
	//DUPLICATE_SERVICEABLE(323, "Duplicate serviceable field"),
	//DUPLICATE_AVAILABLE(333, "Duplicate available field"),
	//DUPLICATE_SERVICES(343, "Duplicate services field"),
	;
	
	private final int code;
	private final String description;
	
	private RoomCode(int code, String description){
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
