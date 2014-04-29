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

import org.jdesktop.xswingx.PromptSupport;

// TODO UPDATE CLASS
// TODO ONLY USED FOR SHOWING ADD BUTTON RIGHT NOW
public class EventPackageViewerUI extends JPanel {
  
  private static final long serialVersionUID = 3954424525672177736L;
  
  private JComboBox<String> dropDown;
  private JTextField        searchField;
  private JButton           searchButton;
  private JTextArea         descriptionArea;
  private JTable            packageTable;
  private JButton           deleteButton;
  private JButton           addButton;
  private JButton           editButton;
  
  public EventPackageViewerUI() {
    buildUI();
  }
  
  /**
   * Method for building the various panels within the PackageViewerUI's panel
   * as well as set the various properties of said panel.
   */
  public void buildUI() {
    setLayout(new BorderLayout());
    
    // buildNorthPanel();
    // buildCenterPanel();
    buildSouthPanel();
  }
  
  /**
   * TODO
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
   * TODO
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
    
    packageTable = new JTable();
    southPanel.add(new JScrollPane(packageTable), BorderLayout.CENTER);
    
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
   * TODO
   */
  public void setTable(List<Package> packageList) {
  }
  
  /**
   * Builds the south panel having buttons for deleting, editing and adding
   * packages.
   */
  public void buildSouthPanel() {
    JPanel southPanel = new JPanel();
    southPanel.setBackground(UIColors.DARKGREEN);
    
    deleteButton = new JButton("Delete");
    editButton = new JButton("Edit");
    addButton = new JButton("Add New");
    
    // southPanel.add(deleteButton);
    // southPanel.add(editButton);
    southPanel.add(addButton);
    
    add(southPanel, BorderLayout.SOUTH);
  }
  
  public JTable getTable() {
    return packageTable;
  }
  
  public void setTableListener(MouseListener listener) {
    packageTable.addMouseListener(listener);
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
