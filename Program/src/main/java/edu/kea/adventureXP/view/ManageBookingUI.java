package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.kea.adventureXP.model.Activity;
import edu.kea.adventureXP.model.Booking;

/**
 * User interface which take care of managing bookings
 */
public class ManageBookingUI extends JFrame {
  
  private JLabel  customerLabel;
  private JButton cancelButton;
  private JButton editButton;
  private JButton bookButton;
  private JTable  activityTable;
  private JTable  bookedTable;
  
  public static void main(String[] args) {
    ManageBookingUI ui1 = new ManageBookingUI();
    ui1.setCustomerName("Tester");
    ui1.setActivityTable(new ArrayList<Activity>());
    ui1.setBookedTable(new ArrayList<Booking>());
    new DateSelecterUI();
    ManagePackageUI ui2 = new ManagePackageUI();
    ui2.setActivityTable(new ArrayList<Activity>());
    ui2.setSelectedTable(new ArrayList<Activity>());
  }
  
  public ManageBookingUI() {
    buildUI();
  }
  
  /**
   * Method for building the various panels within the BookActivityUI frame as
   * well as set the various properties of said panel.
   */
  public void buildUI() {
    setLayout(new BorderLayout());
    setSize(900, 600);
    
    buildNorthPanel();
    buildCenterPanel();
    buildSouthPanel();
    
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  // ------- North Panel -------
  
  public void buildNorthPanel() {
    JPanel northPanel = new JPanel();
    northPanel.setBackground(UIColors.DARKGREEN);
    
    customerLabel = new JLabel("");
    customerLabel.setForeground(UIColors.WHITE);
    customerLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
    northPanel.add(customerLabel);
    
    add(northPanel, BorderLayout.NORTH);
  }
  
  public void setCustomerName(String name) {
    customerLabel.setText("Customer: " + name);
  }
  
  // ------- Center Panel -------
  
  public void buildCenterPanel() {
    JPanel centerPanel = new JPanel(new GridLayout(1, 2));
    
    JPanel westPanel = new JPanel(new BorderLayout());
    westPanel.setBackground(UIColors.LIGHTGREEN);
    activityTable = new JTable();
    westPanel.setBorder(new TitledBorder(null, "Available Activities",
        TitledBorder.CENTER, TitledBorder.TOP));
    westPanel.add(new JScrollPane(activityTable));
    centerPanel.add(westPanel);
    
    JPanel eastPanel = new JPanel(new BorderLayout());
    eastPanel.setBackground(UIColors.LIGHTGREEN);
    bookedTable = new JTable();
    eastPanel.setBorder(new TitledBorder(null, "Booked Activities", TitledBorder.CENTER,
        TitledBorder.TOP));
    eastPanel.add(new JScrollPane(bookedTable));
    centerPanel.add(eastPanel);
    
    add(centerPanel, BorderLayout.CENTER);
  }
  
  public void setActivityTable(List<Activity> activityList) {
    String[] heads = { "ID", "Name" };
    
    DefaultTableModel model = new DefaultTableModel();
    
    model.setRowCount(activityList.size());
    model.setColumnIdentifiers(heads);
    
    int row = 0;
    
    for (Activity activity : activityList) {
      model.setValueAt(activity.getId(), row, 0);
      model.setValueAt(activity.getName(), row, 1);
      row++;
    }
    
    activityTable.setModel(model);
  }
  
  public void setBookedTable(List<Booking> bookedList) {
    String[] heads = { "ID", "Name", "Date" };
    
    DefaultTableModel model = new DefaultTableModel();
    
    model.setRowCount(bookedList.size());
    model.setColumnIdentifiers(heads);
    
    int row = 0;
    
    for (Booking booking : bookedList) {
      model.setValueAt(booking.getId(), row, 0);
      model.setValueAt(booking.getName(), row, 1);
      model.setValueAt(booking.getDate(), row, 2);
      row++;
    }
    
    bookedTable.setModel(model);
  }
  
  public JTable getBookedTable() {
    return bookedTable;
  }
  
  public JTable getActivityTable() {
    return activityTable;
  }
  
  // ------- South Panel -------
  
  public void buildSouthPanel() {
    JPanel southPanel = new JPanel();
    southPanel.setBackground(UIColors.DARKGREEN);
    
    cancelButton = new JButton("Cancel");
    southPanel.add(cancelButton);
    
    editButton = new JButton("Edit");
    southPanel.add(editButton);
    
    bookButton = new JButton("Book");
    southPanel.add(bookButton);
    
    add(southPanel, BorderLayout.SOUTH);
  }
  
  public void setCancelListener(ActionListener listener) {
    cancelButton.addActionListener(listener);
  }
  
  public void setEditListener(ActionListener listener) {
    editButton.addActionListener(listener);
  }
  
  public void setBookListener(ActionListener listener) {
    bookButton.addActionListener(listener);
  }
  
}
