package com.jerrett.windows.chair;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jerrett.dataSctructure.AttendenceState;
import com.jerrett.dataSctructure.Committee;
import com.jerrett.dataSctructure.Position;

public class RollCallButtonPanel extends JPanel {

	public RollCallButtonPanel() {
		super.setLayout(new GridLayout(0, 1));
		
		Button present = new Button("Present");
		present.addActionListener(e -> {
			JTabbedPane tp = (JTabbedPane) super.getParent().getParent();
			int currentIndex = ((RollCallPanel) tp.getSelectedComponent()).tableView.getSelectedRow();
			int targetindex = Math.min(Committee.committee.getPositions().size()-1, currentIndex+1);
			Position pos = Committee.committee.getPositions().get(currentIndex);
			pos.setAttendence(AttendenceState.PRESENT);
			((AttendenceTable)((RollCallPanel) tp.getSelectedComponent()).tableView.getModel()).update();
			((RollCallPanel) tp.getSelectedComponent()).tableView.setRowSelectionInterval(targetindex, targetindex);
			((RollCallPanel) tp.getSelectedComponent()).tableView.scrollRectToVisible(
					new Rectangle(((RollCallPanel) 
					tp.getSelectedComponent()).
					tableView.getCellRect(targetindex, 0, true)));
		});
		super.add(present);
		
		Button pv = new Button("Present and Voting");
		pv.addActionListener(e -> {
			JTabbedPane tp = (JTabbedPane) super.getParent().getParent();
			int currentIndex = ((RollCallPanel) tp.getSelectedComponent()).tableView.getSelectedRow();
			int targetindex = Math.min(Committee.committee.getPositions().size()-1, currentIndex+1);
			Position pos = Committee.committee.getPositions().get(currentIndex);
			pos.setAttendence(AttendenceState.PRESENT_AND_VOTING);
			((AttendenceTable)((RollCallPanel) tp.getSelectedComponent()).tableView.getModel()).update();
			((RollCallPanel) tp.getSelectedComponent()).tableView.setRowSelectionInterval(targetindex, targetindex);
			((RollCallPanel) tp.getSelectedComponent()).tableView.scrollRectToVisible(
					new Rectangle(((RollCallPanel) 
					tp.getSelectedComponent()).
					tableView.getCellRect(targetindex, 0, true)));
		});
		super.add(pv);
		
		Button abs = new Button("Abscent");
		abs.addActionListener(e -> {
			JTabbedPane tp = (JTabbedPane) super.getParent().getParent();
			int currentIndex = ((RollCallPanel) tp.getSelectedComponent()).tableView.getSelectedRow();
			int targetindex = Math.min(Committee.committee.getPositions().size()-1, currentIndex+1);
			Position pos = Committee.committee.getPositions().get(currentIndex);
			pos.setAttendence(AttendenceState.ABSCENT);
			((AttendenceTable)((RollCallPanel) tp.getSelectedComponent()).tableView.getModel()).update();
			((RollCallPanel) tp.getSelectedComponent()).tableView.setRowSelectionInterval(targetindex, targetindex);
			((RollCallPanel) tp.getSelectedComponent()).tableView.scrollRectToVisible(
					new Rectangle(((RollCallPanel) 
					tp.getSelectedComponent()).
					tableView.getCellRect(targetindex, 0, true)));
		});
		super.add(abs);
		
		Button back = new Button("Back");
		back.addActionListener( e -> {
			JTabbedPane tp = (JTabbedPane) super.getParent().getParent();
			int row = ((RollCallPanel) tp.getSelectedComponent()).tableView.getSelectedRow();
			int target = Math.max(0, row - 1);
			((RollCallPanel) tp.getSelectedComponent())
				.tableView.setRowSelectionInterval(target, target);
		
		});
		super.add(back);
	}
}
