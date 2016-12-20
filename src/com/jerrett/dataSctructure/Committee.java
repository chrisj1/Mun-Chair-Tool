package com.jerrett.dataSctructure;

import java.util.ArrayList;
import java.util.Collections;


public class Committee {

	public static Committee committee;
	
	private String name;
	private ArrayList<Position> positions;
	private String topic;
	
	public Committee(String name, String topic) {
		this.name = name;
		this.topic = topic;
		committee = this;
		
		positions = new ArrayList<Position>();
		positions.add(new Position("Chris", AttendenceState.ABSCENT));
		positions.add(new Position("Ally", AttendenceState.ABSCENT));
		positions.add(new Position("Bud", AttendenceState.ABSCENT));
		positions.add(new Position("Penny", AttendenceState.ABSCENT));
		positions.add(new Position("Lenny", AttendenceState.ABSCENT));
		positions.add(new Position("Tim", AttendenceState.ABSCENT));
		positions.add(new Position("Albania", AttendenceState.ABSCENT));
		positions.add(new Position("Chris", AttendenceState.ABSCENT));
		positions.add(new Position("China", AttendenceState.ABSCENT));
		positions.add(new Position("Bob", AttendenceState.ABSCENT));
		positions.add(new Position("Steve", AttendenceState.ABSCENT));
		positions.add(new Position("Hank", AttendenceState.ABSCENT));
		positions.add(new Position("Matt", AttendenceState.ABSCENT));
		positions.add(new Position("Harrison", AttendenceState.ABSCENT));
		positions.add(new Position("Jen", AttendenceState.ABSCENT));
		positions.add(new Position("Clarice", AttendenceState.ABSCENT));
		positions.add(new Position("John", AttendenceState.ABSCENT));
		positions.add(new Position("Nick", AttendenceState.ABSCENT));
		
		
		Collections.sort(positions);
	}
	
	public static void addPosition(Position pos) {
		committee.positions.add(pos);
		Collections.sort(committee.positions);
	}

	public ArrayList<Position> getPositions() {
		return positions;
	
	}
}
