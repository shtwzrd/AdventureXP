package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManageInstructorUI extends JFrame {
	
	private static final long serialVersionUID = 880010111213141516L;

	private JButton saveButton, discardButton;
	private JLabel fNameLabel, lNameLabel, streetLabel, streetNumLabel, cityLabel,
					zipLabel, phoneLabel, emailLabel;
	private JTextField fNameTF, lNameTF, streetTF, streetNumTF, cityTF,
	zipTF, phoneTF, emailTF;
	
	public ManageInstructorUI() {
		createUI();
	}
	
	public void createUI() {
		setTitle("Add Instructor");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		JPanel center = new JPanel(new GridLayout(12, 24));
		fNameLabel = new JLabel("First Name:");
		fNameTF = new JTextField(10);
		lNameLabel = new JLabel("Last Name:");
		lNameTF = new JTextField(10);
		streetLabel = new JLabel("Street:");
		streetTF = new JTextField(15);
		streetNumLabel = new JLabel("Street #:");
		streetNumTF = new JTextField(5);
		cityLabel = new JLabel("City:");
		cityTF = new JTextField(10);
		zipLabel = new JLabel("Zip Code:");
		zipTF = new JTextField(6);
		phoneLabel = new JLabel("Phone:");
		phoneTF = new JTextField(10);
		emailLabel = new JLabel("Email:");
		emailTF = new JTextField(20);
		
		center.add(fNameLabel);
		center.add(fNameTF);
		center.add(lNameLabel);
		center.add(lNameTF);
		center.add(streetLabel);
		center.add(streetTF);
		center.add(streetNumLabel);
		center.add(streetNumTF);
		center.add(cityLabel);
		center.add(cityTF);
		center.add(zipLabel);
		center.add(zipTF);
		center.add(phoneLabel);
		center.add(phoneTF);
		center.add(emailLabel);
		center.add(emailTF);
		
		add(center, BorderLayout.CENTER);
		
		JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		discardButton = new JButton("Discard");
		discardButton.setSize(15, 15);
		
		saveButton = new JButton("Save");
		saveButton.setSize(15, 15);
		
		south.add(discardButton);
		south.add(saveButton);
		
		add(south, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void setSaveListener(ActionListener listener) {
		saveButton.addActionListener(listener);
	}
	
	public void setDiscardListener(ActionListener listener) {
		discardButton.addActionListener(listener);
	}
	
	public String getFNameField() {
		return fNameTF.getText();
	}
	
	public String getLNameField() {
		return lNameTF.getText();
	}
	
	public String getStreetField() {
		return streetTF.getText();
	}
	
	public int getStreetNumField() {
		return Integer.parseInt(streetNumTF.getText());
	}
	
	public String getCityField() {
		return cityTF.getText();
	}
	
	public String getZipField() {
		return zipTF.getText();
	}
	
	public int getPhoneField() {
		return Integer.parseInt(fNameTF.getText());
	}
	
	public String getEmailField() {
		return emailTF.getText();
	}
}