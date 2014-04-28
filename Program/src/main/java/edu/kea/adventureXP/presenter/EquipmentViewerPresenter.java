package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import edu.kea.adventureXP.model.Equipment;
import edu.kea.adventureXP.model.EquipmentController;
import edu.kea.adventureXP.view.EquipmentViewerUI;
import edu.kea.adventureXP.view.ManageEquipmentUI;

public class EquipmentViewerPresenter {
  
  EquipmentViewerUI    ui;
  ArrayList<Equipment> equipmentList       = new ArrayList<Equipment>();
  List<Equipment>      sortedEquipmentList = new ArrayList<Equipment>();
  int                  selectedRow         = -1;
  
  /**
   * Constructor associating the ui with the presenter and setting listeners on
   * all needed components within the UI.
   * 
   * @param ui The UI to listen to input from.
   */
  
  public EquipmentViewerPresenter(EquipmentViewerUI ui) {
    this.ui = ui;
    ui.setTableListener(new TableListener());
    ui.setAddButtonListener(new AddListener());
    ui.setDeleteButtonListener(new DeleteListener());
    ui.setEditButtonListener(new EditListener());
    ui.setSearchButtonListener(new SearchListener());
    setEquipmentList();
    
    String[] dropDownChoices = { "ID", "Name", "Brand" };
    ui.setDropDownOptions(dropDownChoices);
    updateUI();
  }
  
  public EquipmentViewerUI getUI() {
    return ui;
  }
  
  public void setEquipmentList(ArrayList<Equipment> list) {
    equipmentList = list;
    sortedEquipmentList = new ArrayList<Equipment>(list);
  }
  
  public void setEquipmentList() {
    equipmentList = (ArrayList<Equipment>) EquipmentController.selectAllFromEquipment();
  }
  
  public void updateTable() {
    setEquipmentList();
    updateUI();
  }
  
  /**
   * Updates the UI
   */
  public void updateUI() {
    ui.setTable(equipmentList);
    ui.revalidate();
  }
  
  public void sortByName(String name) {
    ArrayList<Equipment> temp = new ArrayList<>();
    
    for (Equipment a : equipmentList)
      if (a.getName().contains(name))
        temp.add(a);
    sortedEquipmentList = new ArrayList<Equipment>(temp);
  }
  
  public void sortByID(String ID) {
    
  }
  
  public void sortByPrice(String Price) {
    
  }
  
  /**
   * MouseListener class used to listen for clicks happening within a JTable.
   */
  private class TableListener implements MouseListener {
    
    @Override
    public void mousePressed(MouseEvent e) {
      selectedRow = ui.getTable().rowAtPoint(e.getPoint());
      ui.setNoteArea(equipmentList.get(selectedRow).getNote());
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
        equipmentList.remove(selectedRow);
        ui.setNoteArea("");
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
      if (selectedRow != -1) {
        Equipment toEdit = EquipmentController.selectFromEquipment((long) ui.getTable()
            .getValueAt(selectedRow, 0));
        new ManageEquipmentPresenter(new ManageEquipmentUI(), toEdit,
            EquipmentViewerPresenter.this);
      }
    }
  }
  
  /**
   * Listens to the add button within the UI.
   */
  private class AddListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      new ManageEquipmentPresenter(new ManageEquipmentUI(), EquipmentViewerPresenter.this);
    }
  }
  
  private class SearchListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      String choice = ui.getSelectedDropDown();
      
      if (choice.equals("ID"))
        sortByID(ui.getSearchField());
      else if (choice.equals("Name"))
        sortByName(ui.getSearchField());
      else if (choice.equals("Price"))
        sortByPrice(ui.getSearchField());
      updateUI();
    }
  }
  
}
