package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.xswingx.PromptSupport;

import edu.kea.adventureXP.model.Instructor;

public class InstructorViewerUI extends JFrame {

	private JComboBox seeOption;
	private JButton addButton, deleteButton, editButton, searchButton;
	private JTextField searchF;
	private JTable instructorTable;
	
	public InstructorViewerUI() {
		createUI();
	}
	
	public void createUI() {
		setTitle("Instructor Overview");
		setSize(500, 500);
		setLayout(new BorderLayout());
		
		createNorth();
		createCenter();
		createSouth();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void createNorth() {
		JPanel north = new JPanel(new FlowLayout());
		north.setBackground(UIColors.DARKBLUE);
		
		seeOption = new JComboBox();
		searchF = new JTextField(25);
		PromptSupport.setPrompt("Type in to search...", searchF);
		searchButton = new JButton("Search");
		searchButton.setSize(10, 10);
		
		north.add(seeOption);
		north.add(searchF);
		north.add(searchButton);
		
		add(north, BorderLayout.NORTH);
	}
	
	public void setDropMenuItems(String[] names) {
		for(String n : names) {
			seeOption.addItem(n);
		}
	}
	
	public void createCenter() {
		JPanel southCenter = new JPanel(new FlowLayout());
		instructorTable = new JTable();
		
		southCenter.add(new JScrollPane(instructorTable), BorderLayout.CENTER);
		
		add(southCenter, BorderLayout.CENTER);
	}
	
	public void setInstructorTable(List<Instructor> instructorList) {
	    String[] columnNames = { "ID", "First Name", "Last Name", "Street",
	    		"Street #", "Post Code", "City", "Phone", "Email"};
	    
	    DefaultTableModel model = new DefaultTableModel();
	   
	    model.setRowCount(instructorList.size());
	    model.setColumnIdentifiers(columnNames);
	   
	    int row = 0;
	   
	    for (Instructor instr : instructorList) {
	      model.setValueAt(instr.getId(), row, 0);
	      model.setValueAt(instr.getFirstName(), row, 1);
	      model.setValueAt(instr.getLastName(), row, 2);
	      model.setValueAt(instr.getStreet(), row, 3);
	      model.setValueAt(instr.getStreetNum(), row, 4);
	      model.setValueAt(instr.getZipCode(), row, 5);
	      model.setValueAt(instr.getCity(), row, 6);
	      model.setValueAt(instr.getTelephone(), row, 7);
	      model.setValueAt(instr.getEmail(), row, 8);
	      row++;
	    }
	   
	    instructorTable.setModel(model);
	    model.fireTableDataChanged();
	}
	
	public void createSouth() {
	    JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    southPanel.setBackground(UIColors.DARKBLUE);
	   
	    deleteButton = new JButton("Delete");
	    editButton = new JButton("Edit");
	    addButton = new JButton("Add New");
	   
	    southPanel.add(deleteButton);
	    southPanel.add(editButton);
	    southPanel.add(addButton);
	   
	    add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setAddButtonListener(ActionListener listener) {
		addButton.addActionListener(listener);
	}
}
