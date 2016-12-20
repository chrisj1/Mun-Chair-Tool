package com.jerrett.windows.chair;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.jerrett.dataSctructure.AttendenceState;
import com.jerrett.dataSctructure.Committee;
import com.jerrett.dataSctructure.Position;

public class RollCallPanel extends JPanel {

	GridBagConstraints constraints = new GridBagConstraints();
	JTable tableView;
	
	
	public RollCallPanel() {
		super();
		draw();
	}

	private JComponent createList() {
		AttendenceTable list = new AttendenceTable();
		JTable table = new JTable(list);
		table.setRowSelectionInterval(0, 0);
		tableView = table;
		table.setFont(new Font("arial",Font.PLAIN, 20));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);

		JScrollPane listScroller = new JScrollPane(table);
		return listScroller;
	}

	private void draw() {
		super.setLayout(setupLayout());
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(10, 10, 10, 10);
		setConstraints(4, 3, 1, 1);
		constraints.gridx = 10;
		super.add(new RollCallButtonPanel(), constraints);
		drawTitle();
		drawList();
	}

	private void drawList() {
		JComponent list = createList();
		setConstraints(1, 3, 2, 3);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.ipadx = 1000;
		constraints.ipady = 400;
		super.add(list, constraints);
	}

	private void drawTitle() {
		setConstraints(0, 0, 3, 1);
		JLabel label = new JLabel("Roll Call:");
		label.setHorizontalAlignment(JLabel.CENTER);
		super.add(label, constraints);
	}

	public void setAttendenceOfSelecter(AttendenceState state) {
		int index = tableView.getSelectedRow();
		Position position = Committee.committee.getPositions().get(index);
		position.setAttendence(state);
	}

	void setConstraints(int x, int y) {
		constraints.gridx =x;
		constraints.gridy = y;
	}

	void setConstraints(int x, int y, int width, int height) {
		constraints.gridx =x;
		constraints.gridy = y;
		constraints.gridwidth = width;
		constraints.gridheight = height;
	}
	
	private LayoutManager setupLayout() {
		GridBagLayout layout = new GridBagLayout();
		return layout;
	}
}
