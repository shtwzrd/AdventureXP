package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.kea.adventureXP.model.Instructor;

public class InstructorViewerUI extends JPanel {
  
  private JComboBox<String> dropDown;
  private JTextField        searchField;
  private JButton           searchButton;
  private JTextArea         descriptionArea;
  private JTable            instructorTable;
  private JButton           deleteButton;
  private JButton           addButton;
  private JButton           editButton;
  
  public InstructorViewerUI() {
    buildUI();
  }
  
  /**
   * Method for building the various panels within the InstructorViewerUI's
   * panel as well as set the various properties of said panel.
   */
  public void buildUI() {
    setLayout(new BorderLayout());
    
    buildNorthPanel();
    buildCenterPanel();
    buildSouthPanel();
  }
  
  /**
   * Builds the north panel with a dropdown menu, a search field and a search
   * button.
   */
  public void buildNorthPanel() {
    JPanel northPanel = new JPanel();
    northPanel.setBackground(UIColors.DARKGREEN);
    
    dropDown = new JComboBox<String>();
    searchField = new JTextField(15);
    // PromptSupport.setPrompt("Type in search...", searchField);
    
    searchButton = new JButton("Search");
    
    northPanel.add(dropDown);
    northPanel.add(searchField);
    northPanel.add(searchButton);
    
    add(northPanel, BorderLayout.NORTH);
  }
  
  /**
   * @param words The options to display in the drop down menu
   */
  public void setDropDownOptions(String[] words) {
    for (String s : words)
      dropDown.addItem(s);
  }
  
  /**
   * Builds the center panel consisting of a JTable showing all instructors and
   * a description box showing the description of the selected instructor.
   */
  public void buildCenterPanel() {
    JPanel southPanel = new JPanel(new BorderLayout());
    
    instructorTable = new JTable();
    southPanel.add(new JScrollPane(instructorTable), BorderLayout.CENTER);
    
    descriptionArea = new JTextArea(10, 20);
    descriptionArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
    descriptionArea.setWrapStyleWord(true);
    descriptionArea.setLineWrap(true);
    descriptionArea.setEditable(false);
    // PromptSupport.setPrompt("Information", descriptionArea);
    
    southPanel.add(descriptionArea, BorderLayout.SOUTH);
    
    add(southPanel, BorderLayout.CENTER);
  }
  
  /**
   * Adds a list of activities to the JTable.
   * 
   * @param activityList The list of activities to add
   */
  public void setTable(List<Instructor> instructorList) {
    String[] heads = { "ID", "First name", "Last name", "Email" };
    
    DefaultTableModel model = new DefaultTableModel();
    
    model.setRowCount(instructorList.size());
    model.setColumnIdentifiers(heads);
    
    int row = 0;
    
    for (Instructor i : instructorList) {
      model.setValueAt(i.getId(), row, 0);
      model.isCellEditable(row, 0);
      model.setValueAt(i.getFirstName(), row, 1);
      model.isCellEditable(row, 1);
      model.setValueAt(i.getLastName(), row, 2);
      model.isCellEditable(row, 2);
      model.setValueAt(i.getEmail(), row, 3);
      model.isCellEditable(row, 3);
      row++;
    }
    
    instructorTable.setModel(model);
  }
  
  /**
   * Builds the south panel having buttons for deleting, editing and adding
   * activities.
   */
  public void buildSouthPanel() {
    JPanel southPanel = new JPanel();
    southPanel.setBackground(UIColors.DARKGREEN);
    
    deleteButton = new JButton("Delete");
    editButton = new JButton("Edit");
    addButton = new JButton("Add New");
    
    southPanel.add(deleteButton);
    southPanel.add(editButton);
    southPanel.add(addButton);
    
    add(southPanel, BorderLayout.SOUTH);
  }
  
  public JTable getTable() {
    return instructorTable;
  }
  
  public void setTableListener(MouseListener listener) {
    instructorTable.addMouseListener(listener);
  }
  
  public void setDeleteButtonListener(ActionListener listener) {
    deleteButton.addActionListener(listener);
  }
  
  public void setEditButtonListener(ActionListener listener) {
    editButton.addActionListener(listener);
  }
  
  public void setAddButtonListener(ActionListener listener) {
    addButton.addActionListener(listener);
  }
  
  public void setSearchButtonListener(ActionListener listener) {
    searchButton.addActionListener(listener);
  }
  
  public void setDescriptionArea(String description) {
    descriptionArea.setText(description);
  }
  
  public String getSelectedDropDown() {
    return (String) dropDown.getSelectedItem();
  }
  
  public String getSearchField() {
    return searchField.getText();
  }

}
