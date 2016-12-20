package com.jerrett.windows.chair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

import com.jerrett.dataSctructure.AttendenceState;
import com.jerrett.dataSctructure.Committee;
import com.jerrett.dataSctructure.Position;

public class AttendenceTable extends AbstractTableModel {
	
	public AttendenceTable() {
	}

	@Override
	public int getRowCount() {
		return Committee.committee.getPositions().size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Position position = Committee.committee.getPositions().get(rowIndex);
		switch(columnIndex) {
			case(0):
				return position.getName();
			case(1):
				return position.getAttendence().getName();
			default:
				return "";
			}
	}
	
	public static final String[] names = {
		"Country", "Attendance"
	};
	
	@Override
	public String getColumnName(int index) {
	    return names[index];
	}
	
	public void update() {
		super.fireTableDataChanged();
	}
}
