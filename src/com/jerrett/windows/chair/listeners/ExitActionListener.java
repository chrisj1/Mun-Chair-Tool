package com.jerrett.windows.chair.listeners;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.jerrett.start.MainApp;

public class ExitActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MainApp.getMainApp().exit();
	}
}
