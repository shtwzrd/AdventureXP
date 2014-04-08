package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import edu.kea.adventureXP.model.Instructor;
import edu.kea.adventureXP.view.InstructorViewerUI;
import edu.kea.adventureXP.view.ManageActivityUI;
import edu.kea.adventureXP.view.ManageInstructorUI;

public class InstructorViewerPresenter {
  
  InstructorViewerUI    ui;
  ArrayList<Instructor> instructorList       = new ArrayList<>();
  ArrayList<Instructor> sortedInstructorList = new ArrayList<>();
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
    updateUI();
  }
  
  public InstructorViewerUI getUI() {
    return ui;
  }
  
  public void setInstructorList(ArrayList<Instructor> list) {
    instructorList = list;
    sortedInstructorList = new ArrayList<Instructor>(list);
  }
  
  /**
   * Updates the UI
   */
  public void updateUI() {
    ui.setTable(sortedInstructorList);
    ui.revalidate();
  }
  
  public void sortByName(String name) {
    ArrayList<Instructor> temp = new ArrayList<>();
    
    for (Instructor i : instructorList) {
      String iName = i.getFName() + " " + i.getLName();
      if (iName.contains(name))
        temp.add(i);
    }
    sortedInstructorList = new ArrayList<Instructor>(temp);
  }
  
  /**
   * MouseListener class used to listen for clicks happening within a JTable.
   */
  private class TableListener implements MouseListener {
    
    @Override
    public void mousePressed(MouseEvent e) {
      selectedRow = ui.getTable().rowAtPoint(e.getPoint());
      Instructor i = instructorList.get(selectedRow);
      String description = i.getStreet() + " " + i.getStreetNum() + ", " + i.getZipCode()
          + " " + i.getCity() + "\nPhone: " + i.getTelephone();
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
        instructorList.remove(selectedRow);
        ui.setDescriptionArea("");
        updateUI();
      }
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
            sortedInstructorList.get(selectedRow));
    }
    
  }
  
  /**
   * Listens to the add button within the UI.
   */
  private class AddListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      new ManageActivityPresenter(new ManageActivityUI());
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