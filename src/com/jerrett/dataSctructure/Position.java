package com.jerrett.dataSctructure;

public class Position implements Comparable{

	private String name;
	private AttendenceState attendence;
	
	public Position(String name, AttendenceState attendence) {
		super();
		this.name = name;
		this.attendence = attendence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttendenceState getAttendence() {
		return attendence;
	}

	public void setAttendence(AttendenceState attendence) {
		this.attendence = attendence;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Object o) {
		Position pos = (Position) o;
		return -pos.getName().compareToIgnoreCase(getName());
	}
}
