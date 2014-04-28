package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import edu.kea.adventureXP.model.Member;
import edu.kea.adventureXP.model.MemberController;
import edu.kea.adventureXP.view.InstructorViewerUI;
import edu.kea.adventureXP.view.ManageInstructorUI;

public class InstructorViewerPresenter {
  
  InstructorViewerUI    ui;
  List<Member>      instructorList;
  ArrayList<Member> sortedInstructorList = new ArrayList<>();
  int                   selectedRow          = -1;
  
  public InstructorViewerPresenter(InstructorViewerUI ui) {
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
  
  public InstructorViewerUI getUI() {
    return ui;
  }
  
  public void setInstructorList(List<Member> list) {
    instructorList = list;
    sortedInstructorList = new ArrayList<Member>(list);
  }
  
  public void updateTable() {
    setInstructorList(MemberController.getAllInstructors());
    updateUI();
  }
  
  /**
   * Updates the UI
   */
  public void updateUI() {
    ui.setTable(sortedInstructorList);
    ui.revalidate();
  }
  
  public void sortByName(String name) {
    ArrayList<Member> temp = new ArrayList<>();
    
    for (Member i : instructorList) {
      String iName = i.getFirstName() + " " + i.getLastName();
      if (iName.contains(name))
        temp.add(i);
    }
    sortedInstructorList = new ArrayList<Member>(temp);
  }
  
  /**
   * MouseListener class used to listen for clicks happening within a JTable.
   */
  private class TableListener extends MouseAdapter {
    
    @Override
    public void mouseClicked(MouseEvent e) {
      selectedRow = ui.getTable().rowAtPoint(e.getPoint());
      Member i = instructorList.get(selectedRow);
      String description = i.getStreet() + ", " + i.getZipCode() + " " + i.getCity()
          + "\nPhone: " + i.getTelephone();
      ui.setDescriptionArea(description);
    }
    
  }
  
  /**
   * Listens to the delete button within the UI.
   */
  private class DeleteListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (selectedRow != -1) {
        instructorList.remove(selectedRow);
        
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
        new ManageInstructorPresenter(new ManageInstructorUI(),
            InstructorViewerPresenter.this, sortedInstructorList.get(selectedRow));
    }
  }
  
  /**
   * Listens to the add button within the UI.
   */
  private class AddListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      new ManageInstructorPresenter(new ManageInstructorUI(),
          InstructorViewerPresenter.this);
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
