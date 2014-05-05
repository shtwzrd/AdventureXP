package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.xswingx.PromptSupport;

public class ManageEquipmentUI extends JFrame {
  
  private static final long serialVersionUID = 6253925559410375343L;
  private JTextField        nameField;
  private JTextField        brandField;
  private JTextField        dateField;
  private JTextArea         noteArea;
  private JButton           saveButton;
  private JButton           discardButton;
  
  /**
   * Constructor for building the User Interface. It calls the buildUI method
   * which builds the frame and the panels within.
   */
  public ManageEquipmentUI() {
    buildUI();
  }
  
  /**
   * Builds the frame and the panels within.
   */
  public void buildUI() {
    setTitle("Manage Equipment");
    setSize(700, 500);
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
    // PromptSupport.setPrompt("Name (required)", nameField);
    
    JLabel brand = new JLabel("Brand:");
    brand.setForeground(UIColors.WHITE);
    
    brandField = new JTextField(10);
    
    JLabel date = new JLabel("Date:");
    date.setForeground(UIColors.WHITE);
    
    dateField = new JTextField(15);
    PromptSupport.setPrompt("dd/mm/yyyy", dateField);
    
    northPanel.add(name);
    northPanel.add(nameField);
    
    northPanel.add(brand);
    northPanel.add(brandField);
    
    northPanel.add(date);
    northPanel.add(dateField);
    
    add(northPanel, BorderLayout.NORTH);
  }
  
  /**
   * Builds the center panel with a description
   */
  public void buildCenterPanel() {
    noteArea = new JTextArea();
    noteArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
    noteArea.setWrapStyleWord(true);
    noteArea.setLineWrap(true);
    // PromptSupport.setPrompt("Description", noteArea);
    
    add(new JScrollPane(noteArea), BorderLayout.CENTER);
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
  
  public void setEditableToFalse() {
    dateField.setEditable(false);
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
  
  public String getBrandField() {
    String brandText = brandField.getText();
    return brandText;
  }
  
  public void setBrandField(String brand) {
    brandField.setText(brand + "");
  }
  
  public String getNoteField() {
    return noteArea.getText();
  }
  
  public void setNoteArea(String note) {
    noteArea.setText(note);
  }
  
  public Date getDateField() throws ParseException {
    String string = dateField.getText();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = df.parse(string);
    return date;
  }
  
  // TODO
  public void setDateField(Date date) {
    // String strDate = date.getDay() + "/" + date.getMonth() + "/" +
    // date.getYear();
    String date1 = date.toString();
    dateField.setText(date1);
  }
  
  public void setDateField(String date) {
    // String strDate = date.getDay() + "/" + date.getMonth() + "/" +
    // date.getYear();
    String date1 = date.toString();
    dateField.setText(date1);
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
