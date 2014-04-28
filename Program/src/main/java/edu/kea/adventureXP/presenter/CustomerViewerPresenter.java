package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import edu.kea.adventureXP.model.Member;
import edu.kea.adventureXP.model.MemberController;
import edu.kea.adventureXP.view.CustomerViewerUI;
import edu.kea.adventureXP.view.InstructorViewerUI;
import edu.kea.adventureXP.view.ManageCustomerUI;

public class CustomerViewerPresenter {
  
  CustomerViewerUI    ui;
  List<Member>      customerList;
  ArrayList<Member> sortedCustomerList = new ArrayList<>();
  int                   selectedRow          = -1;
  
  public CustomerViewerPresenter(CustomerViewerUI ui) {
    this.ui = ui;
    ui.setTableListener(new TableListener());
    ui.setAddButtonListener(new AddListener());
    ui.setDeleteButtonListener(new DeleteListener());
    ui.setEditButtonListener(new EditListener());
    ui.setSearchButtonListener(new SearchListener());
    
    String[] dropDownChoices = { "Name" };
    ui.setDropDownOptions(dropDownChoices);
    updateTable();
  }
  
  public CustomerViewerUI getUI() {
    return ui;
  }
  
  public void setCustomerList(List<Member> list) {
    customerList = list;
    sortedCustomerList = new ArrayList<Member>(list);
  }
  
  public void updateTable() {
    setCustomerList(MemberController.getAllCustomers());
    updateUI();
  }
  
  /**
   * Updates the UI
   */
  public void updateUI() {
    ui.setTable(sortedCustomerList);
    ui.revalidate();
  }
  
  public void sortByName(String name) {
    ArrayList<Member> temp = new ArrayList<>();
    
    for (Member i : customerList) {
      String iName = i.getFirstName() + " " + i.getLastName();
      if (iName.contains(name))
        temp.add(i);
    }
    sortedCustomerList = new ArrayList<Member>(temp);
  }
  
  /**
   * MouseListener class used to listen for clicks happening within a JTable.
   */
  private class TableListener implements MouseListener {
    
    @Override
    public void mousePressed(MouseEvent e) {
      selectedRow = ui.getTable().rowAtPoint(e.getPoint());
      Member i = customerList.get(selectedRow);
      String description = i.getStreet() + ", " + i.getZipCode() + " " + i.getCity()
          + "\nPhone: " + i.getTelephone();
      ui.setDescriptionArea(description);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
  }
  
  /**
   * Listens to the delete button within the UI.
   */
  private class DeleteListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (selectedRow != -1) {
        customerList.remove(selectedRow);
        
        ui.setDescriptionArea("");
        updateUI();
      }
    }
  }
  
  private class UpdateListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      updateUI();
    }
  }
  
  /**
   * Listens to the edit button within the UI.
   */
  private class EditListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (selectedRow != -1)
        new ManageCustomerPresenter(new ManageCustomerUI(),
            CustomerViewerPresenter.this, sortedCustomerList.get(selectedRow));
    }
  }
  
  /**
   * Listens to the add button within the UI.
   */
  private class AddListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      new ManageCustomerPresenter(new ManageCustomerUI(),
          CustomerViewerPresenter.this);
    }
  }
  
  private class SearchListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      String choice = ui.getSelectedDropDown();
      
      if (choice.equals("Name"))
        sortByName(ui.getSearchField());
      updateUI();
    }
  }
  
}
