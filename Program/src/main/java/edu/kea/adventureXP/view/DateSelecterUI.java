package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.xswingx.PromptSupport;

/**
 * User interface class used for specify date and time
 */
public class DateSelecterUI extends JFrame {
  
  private JButton    confirmButton;
  private JButton    cancelButton;
  private JTextField dateTextField;
  private JTextField timeTextField;
  
  public DateSelecterUI() {
    buildUI();
  }
  
  /**
   * Method which is holding methods and components for user interface creating
   */
  public void buildUI() {
    setTitle("Select Date & Time");
    setSize(300, 100);
    setLayout(new BorderLayout());
    
    buildCenterPanel();
    buildSouthPanel();
    
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
  }
  
  /**
   * Method which is building the center part of the user interface
   */
  public void buildCenterPanel() {
    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(UIColors.LIGHTGREEN);
    JLabel dateLabel = new JLabel("Date");
    dateTextField = new JTextField(8);
    PromptSupport.setPrompt("dd/mm/yyyy", dateTextField);
    
    JLabel timeLabel = new JLabel("Time");
    timeTextField = new JTextField(5);
    PromptSupport.setPrompt("hh:mm", timeTextField);
    
    centerPanel.add(dateLabel);
    centerPanel.add(dateTextField);
    centerPanel.add(timeLabel);
    centerPanel.add(timeTextField);
    
    add(centerPanel, BorderLayout.CENTER);
  }
  
  /**
   * Method which is building the south part of the user interface
   */
  public void buildSouthPanel() {
    JPanel southPanel = new JPanel();
    southPanel.setBackground(UIColors.DARKGREEN);
    confirmButton = new JButton("Confirm");
    cancelButton = new JButton("Cancel");
    
    southPanel.add(cancelButton);
    southPanel.add(confirmButton);
    
    add(southPanel, BorderLayout.SOUTH);
  }
  
  /**
   * Methods which are holding the actions for the buttons
   * 
   * @param listener take care of the responsibilities of current button
   */
  public void setConfirmListener(ActionListener listener) {
    confirmButton.addActionListener(listener);
  }
  
  public void setCancelListener(ActionListener listener) {
    cancelButton.addActionListener(listener);
  }
  
  /**
   * Method which allows you to get information for dare
   * 
   * @return the date
   */
  public String getDate() {
    return dateTextField.getText();
  }
  
  /**
   * Method which allows to get the time
   * 
   * @return the time
   */
  public String getTime() {
    return timeTextField.getText();
  }
}
