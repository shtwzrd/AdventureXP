package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.Font;
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
import javax.swing.table.TableColumnModel;

import org.jdesktop.xswingx.PromptSupport;

import edu.kea.adventureXP.model.Activity;

/**
 * User Interface class used for displaying all Activities in the database. It
 * has a search bar for finding activities, a list of all activities as well as
 * buttons.
 */
public class ActivityViewerUI extends JPanel {
  
  private static final long serialVersionUID = 3954424525672177736L;
  
  private JComboBox<String> dropDown;
  private JTextField        searchField;
  private JButton           searchButton;
  private JTextArea         descriptionArea;
  private JTable            activityTable;
  private JButton           deleteButton;
  private JButton           addButton;
  private JButton           editButton;
  
  public ActivityViewerUI() {
    buildUI();
  }
  
  /**
   * Method for building the various panels within the ActivityViewerUI's panel
   * as well as set the various properties of said panel.
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
    PromptSupport.setPrompt("Type in search...", searchField);
    
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
   * Builds the center panel consisting of a JTable showing all activities and a
   * description box showing the description of the selected activity.
   */
  public void buildCenterPanel() {
    JPanel southPanel = new JPanel(new BorderLayout());
    
    activityTable = new JTable();
    southPanel.add(new JScrollPane(activityTable), BorderLayout.CENTER);
    
    descriptionArea = new JTextArea(10, 20);
    descriptionArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
    descriptionArea.setWrapStyleWord(true);
    descriptionArea.setLineWrap(true);
    descriptionArea.setEditable(false);
    PromptSupport.setPrompt("Description", descriptionArea);
    
    southPanel.add(descriptionArea, BorderLayout.SOUTH);
    
    add(southPanel, BorderLayout.CENTER);
  }
  
  /**
   * Adds a list of activities to the JTable.
   * 
   * @param activityList The list of activities to add
   */
  public void setTable(List<Activity> activityList) {
    String[] heads = { "ID", "Active", "Name", "Price (person/hour)" };
    
    DefaultTableModel model = new DefaultTableModel();
    
    model.setRowCount(activityList.size());
    model.setColumnIdentifiers(heads);
    
    int row = 0;
    
    for (Activity a : activityList) {
      model.setValueAt(a.getId(), row, 0);
      if (a.getIsActive())
        model.setValueAt("Y", row, 1);
      else
        model.setValueAt("N", row, 1);
      model.setValueAt(a.getName(), row, 2);
      model.setValueAt(String.format("%.2f DKK", a.getPrice()), row, 3);
      row++;
    }
    
    activityTable.setModel(model);
    
    activityTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TableColumnModel columnModel = activityTable.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(30);
    columnModel.getColumn(1).setPreferredWidth(50);
    columnModel.getColumn(2).setPreferredWidth(350);
    columnModel.getColumn(3).setPreferredWidth(150);
    activityTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    
    model.fireTableDataChanged();
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
    return activityTable;
  }
  
  public void setTableListener(MouseListener listener) {
    activityTable.addMouseListener(listener);
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
