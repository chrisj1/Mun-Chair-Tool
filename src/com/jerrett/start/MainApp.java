package com.jerrett.start;

import java.awt.Dialog;

import javax.swing.JOptionPane;

import com.jerrett.dataSctructure.Committee;
import com.jerrett.windows.chair.ChairFrame;

public class MainApp {
	
	static MainApp app;
	
	private ChairFrame chairFrame;
	
	public static void main(String[] args) {
		app = new MainApp();
	}
	
	public static MainApp getMainApp() {
		return app;
	}
	
	public MainApp() {
		start();
		initChairWindow();
	}
	
	private void start() {
		Committee.committee = new Committee("GA", "SC");
	}
	
	private void initChairWindow() {
		chairFrame = new ChairFrame();
	}

	public void exit() {
		if(confirmClose()) {
			chairFrame.dispose();
			System.exit(0);			
		}
	}
	
	public static MainApp getApp() {
		return app;
	}

	public static void setApp(MainApp app) {
		MainApp.app = app;
	}

	public ChairFrame getChairFrame() {
		return chairFrame;
	}

	public void setChairFrame(ChairFrame chairFrame) {
		this.chairFrame = chairFrame;
	}

	private boolean confirmClose() {
		JOptionPane pane = new JOptionPane("Are you sure you want to close?",
				JOptionPane.ERROR_MESSAGE,JOptionPane.YES_NO_OPTION);
		Dialog dialog = pane.createDialog("");
		dialog.setVisible(true);
		return pane.getValue().equals(new Integer(0));
	}
	
}
