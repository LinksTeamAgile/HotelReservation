package com.links.ressys.core;

public enum Services {
	
	TV(01, "Television"),
	WIFI(02, "Wifi"),
	SMOKERS(03, "Room for smokers"),
	HANDICAP(04, "Room for handicapped");
	
	
	private final int code;
	private final String description;
	
	private Services(int code, String description){
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
