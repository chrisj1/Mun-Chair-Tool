package com.jerrett.windows.chair;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jerrett.windows.chair.listeners.AttendenceActionListener;
import com.jerrett.windows.chair.listeners.ChairWindowListener;
import com.jerrett.windows.chair.listeners.ConfigActionListener;
import com.jerrett.windows.chair.listeners.ExitActionListener;
import com.jerrett.windows.chair.listeners.LoadActionListener;
import com.jerrett.windows.chair.listeners.PositionsActionListener;
import com.jerrett.windows.chair.listeners.SaveActionListener;

public class ChairFrame extends JFrame{
	
	int WIDTH = 1920, HEIGHT = WIDTH /16 * 9;

	JMenuBar menuBar = new JMenuBar();
	JTabbedPane tabbedPane = new JTabbedPane();
	
	public ChairFrame() {
		initMenu();
		intiTabs();
		configureDefaults();
		super.setLocationRelativeTo(null);
		super.setSize(WIDTH, HEIGHT);
		super.setJMenuBar(menuBar);
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.setVisible(true);
	}
	
	private void configureDefaults() {
		super.addWindowListener(new ChairWindowListener());
	}

	private void intiTabs() {
		tabbedPane.add("Roll Call", new RollCallPanel());
		tabbedPane.add("Speakers List", new JComponent() {
		});
		tabbedPane.add("Moderated Caucus", new JComponent() {
		});
		tabbedPane.add("Timer", new JComponent() {
		});
		
		super.add(tabbedPane);
	}

	private void initMenu() {
		menuBar.add(getFileMenuBar());
		menuBar.add(getCommitteeMenu());
	}
	
	private JMenu getFileMenuBar() {
		JMenu file = new JMenu("File");
		ArrayList<JMenuItem> menuItems = getFileOptions();
		for(JMenuItem item: menuItems) {
			file.add(item);
		}
		return file;
	}

	private ArrayList<JMenuItem> getFileOptions() {
		ArrayList<JMenuItem> items = new ArrayList<>();
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new SaveActionListener());
		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(new LoadActionListener());
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitActionListener());
		
		items.add(save);
		items.add(load);
		items.add(exit);
		return items;
	}
	
	private JMenu getCommitteeMenu() {
		JMenu menu = new JMenu("Committee");
		ArrayList<JMenuItem> menuItems = getCommitteeOptions();
		for(JMenuItem item: menuItems) {
			menu.add(item);
		}
		return menu;
	}
	
	private ArrayList<JMenuItem> getCommitteeOptions() {
		ArrayList<JMenuItem> items = new ArrayList<>();
		JMenuItem positions = new JMenuItem("Positions");
		positions.addActionListener(new PositionsActionListener());
		JMenuItem attendence = new JMenuItem("Attendence");
		attendence.addActionListener(new AttendenceActionListener());
		JMenuItem config = new JMenuItem("Committee Config");
		config.addActionListener(new ConfigActionListener());
		
		items.add(positions);
		items.add(attendence);
		items.add(config);
		return items;
	}
}
