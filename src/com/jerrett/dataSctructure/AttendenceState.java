package com.jerrett.dataSctructure;

public enum AttendenceState {
	PRESENT("Present"),
	PRESENT_AND_VOTING("Present and Voting"),
	ABSCENT("Abscent");

	private final String name;
	
	AttendenceState(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
