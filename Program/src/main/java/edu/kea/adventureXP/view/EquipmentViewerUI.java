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

import edu.kea.adventureXP.model.Equipment;

public class EquipmentViewerUI extends JPanel {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private JComboBox<String> dropDown;
  private JTextField        searchField;
  private JButton           searchButton;
  private JTextArea         noteArea;
  private JTable            equipmentTable;
  private JButton           deleteButton;
  private JButton           addButton;
  private JButton           editButton;
  
  public EquipmentViewerUI() {
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
   * Builds the center panel consisting of a JTable showing all activities and a
   * description box showing the description of the selected activity.
   */
  public void buildCenterPanel() {
    JPanel southPanel = new JPanel(new BorderLayout());
    
    equipmentTable = new JTable();
    southPanel.add(new JScrollPane(equipmentTable), BorderLayout.CENTER);
    
    noteArea = new JTextArea(10, 20);
    noteArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
    noteArea.setWrapStyleWord(true);
    noteArea.setLineWrap(true);
    noteArea.setEditable(false);
    PromptSupport.setPrompt("Note", noteArea);
    
    southPanel.add(noteArea, BorderLayout.SOUTH);
    
    add(southPanel, BorderLayout.CENTER);
  }
  
  /**
   * Adds a list of activities to the JTable.
   * 
   * @param activityList The list of activities to add
   */
  public void setTable(List<Equipment> equipmentList) {
    String[] heads = { "Name", "Brand", "Date" };
    
    DefaultTableModel model = new DefaultTableModel();
    
    model.setRowCount(equipmentList.size());
    model.setColumnIdentifiers(heads);
    
    int row = 0;
    
    for (Equipment a : equipmentList) {
      model.setValueAt(a.getName(), row, 0);
      model.isCellEditable(row, 0);
      model.setValueAt(a.getBrand(), row, 1);
      model.isCellEditable(row, 1);
      model.setValueAt(a.getDate(), row, 2);
      model.isCellEditable(row, 2);
      row++;
    }
    
    equipmentTable.setModel(model);
    
    equipmentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TableColumnModel columnModel = equipmentTable.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(30);
    columnModel.getColumn(1).setPreferredWidth(400);
    columnModel.getColumn(2).setPreferredWidth(40);
    equipmentTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    
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
    return equipmentTable;
  }
  
  public void setTableListener(MouseListener listener) {
    equipmentTable.addMouseListener(listener);
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
  
  public void setNoteArea(String note) {
    noteArea.setText(note);
  }
  
  public String getSelectedDropDown() {
    return (String) dropDown.getSelectedItem();
  }
  
  public String getSearchField() {
    return searchField.getText();
  }
}
