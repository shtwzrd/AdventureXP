package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.xswingx.PromptSupport;

import edu.kea.adventureXP.model.Activity;

/**
 * User Interface class for creating a new activity as well as edit an old
 * activity. The interface have fields for the activity's name, description and
 * price as well as buttons for saving and discarding.
 * 
 * @see Activity
 */
public class ManageActivityUI extends JFrame {
  
  private static final long serialVersionUID = 2989732749967452666L;
  
  private JTextField        nameField;
  private JTextField        priceField;
  private JTextArea         descriptionArea;
  private JButton           saveButton;
  private JButton           discardButton;
  
  private JCheckBox         activeCheck;
  
  /**
   * Constructor for building the User Interface. It calls the buildUI method
   * which builds the frame and the panels within.
   */
  public ManageActivityUI() {
    buildUI();
  }
  
  /**
   * Builds the frame and the panels within.
   */
  public void buildUI() {
    setTitle("Manage Activity");
    setSize(500, 500);
    setLayout(new BorderLayout());
    
    buildNorthPanel();
    buildCenterPanel();
    buildSouthPanel();
    
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
  }
  
  /**
   * Builds the north panel with fields for name and price
   */
  public void buildNorthPanel() {
    JPanel northPanel = new JPanel();
    northPanel.setBackground(UIColors.DARKGREEN);
    
    JLabel name = new JLabel("Name:");
    name.setForeground(UIColors.WHITE);
    
    nameField = new JTextField(10);
    PromptSupport.setPrompt("Name (required)", nameField);
    
    JLabel price = new JLabel("Price:");
    price.setForeground(UIColors.WHITE);
    
    priceField = new JTextField(10);
    PromptSupport.setPrompt("Price", priceField);
    
    JLabel active = new JLabel("Active:");
    active.setForeground(UIColors.WHITE);
    activeCheck = new JCheckBox();
    activeCheck.setSelected(true);
    
    northPanel.add(name);
    northPanel.add(nameField);
    
    northPanel.add(price);
    northPanel.add(priceField);
    
    northPanel.add(active);
    northPanel.add(activeCheck);
    
    add(northPanel, BorderLayout.NORTH);
  }
  
  /**
   * Builds the center panel with a description
   */
  public void buildCenterPanel() {
    descriptionArea = new JTextArea();
    descriptionArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
    descriptionArea.setWrapStyleWord(true);
    descriptionArea.setLineWrap(true);
    PromptSupport.setPrompt("Description", descriptionArea);
    
    add(new JScrollPane(descriptionArea), BorderLayout.CENTER);
  }
  
  /**
   * Builds the south panel containing a discard button and saving button
   */
  public void buildSouthPanel() {
    JPanel southPanel = new JPanel();
    southPanel.setBackground(UIColors.DARKGREEN);
    
    saveButton = new JButton("Save");
    discardButton = new JButton("Discard");
    
    southPanel.add(discardButton);
    southPanel.add(saveButton);
    
    add(southPanel, BorderLayout.SOUTH);
  }
  
  /**
   * Adds an ActionListener to the discard button
   * 
   * @param listener The ActionListener to be added
   */
  public void setDiscardListener(ActionListener listener) {
    discardButton.addActionListener(listener);
  }
  
  /**
   * Adds an ActionListener to the save button
   * 
   * @param listener The ActionListener to be added
   */
  public void setSaveListener(ActionListener listener) {
    saveButton.addActionListener(listener);
  }
  
  public String getNameField() {
    return nameField.getText();
  }
  
  public void setNameField(String name) {
    nameField.setText(name);
  }
  
  public double getPriceField() {
    String priceText = priceField.getText();
    if (priceText.equals(""))
      return 0; // Nothing was added
    else
      try {
        return Double.parseDouble(priceText);
      }
      catch (Exception e) {
        return 0; // Illegal characters were added
      }
  }
  
  public void setPriceField(double price) {
    priceField.setText(price + "");
  }
  
  public String getDescriptionField() {
    return descriptionArea.getText();
  }
  
  public boolean getIsActive() {
    return activeCheck.isSelected();
  }
  
  public void setIsActive(boolean flag) {
    if (flag)
      activeCheck.setSelected(true);
    else
      activeCheck.setSelected(false);
  }
  
  public void setDescriptionArea(String desc) {
    descriptionArea.setText(desc);
  }
  
  /**
   * Displays an error in a JOptionPane
   * 
   * @param error The error message to display
   */
  public void displayError(String error) {
    JOptionPane
        .showMessageDialog(null, error, "Error Message", JOptionPane.ERROR_MESSAGE);
  }
  
}
