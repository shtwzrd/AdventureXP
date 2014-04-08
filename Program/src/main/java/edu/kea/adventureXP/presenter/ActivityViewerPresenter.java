package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import java.util.List;

import edu.kea.adventureXP.model.Activity;
import edu.kea.adventureXP.model.ActivityController;
import edu.kea.adventureXP.view.ActivityViewerUI;
import edu.kea.adventureXP.view.ManageActivityUI;

public class ActivityViewerPresenter {
  
  ActivityViewerUI    ui;
  ArrayList<Activity> activityList       = new ArrayList<Activity>();
  List<Activity> sortedActivityList = new ArrayList<Activity>();
  int                 selectedRow        = -1;
  
  /**
   * Constructor associating the ui with the presenter and setting listeners on
   * all needed components within the UI.
   * 
   * @param ui The UI to listen to input from.
   */
  public ActivityViewerPresenter(ActivityViewerUI ui) {
    this.ui = ui;
    ui.setTableListener(new TableListener());
    ui.setAddButtonListener(new AddListener());
    ui.setDeleteButtonListener(new DeleteListener());
    ui.setEditButtonListener(new EditListener());
    ui.setSearchButtonListener(new SearchListener());
<<<<<<< HEAD
    setActivityList();
=======
    
    String[] dropDownChoices = { "ID", "Name", "Price" };
    ui.setDropDownOptions(dropDownChoices);
>>>>>>> f830af1dacec891af88cc70e30a3e8ae0df1c062
    updateUI();
  }
  
  public ActivityViewerUI getUI() {
    return ui;
  }
  
  public void setActivityList(ArrayList<Activity> list) {
	activityList = list;
    sortedActivityList = new ArrayList<Activity>(list);
  }
  
  public void setActivityList() {
		activityList = (ArrayList<Activity>) ActivityController.selectAllFromActivity();
		
	  }
  
  /**
   * Updates the UI
   */
  public void updateUI() {
    ui.setTable(activityList);
    ui.revalidate();
  }
  
  public void sortByName(String name) {
    ArrayList<Activity> temp = new ArrayList<>();
    
    for (Activity a : activityList)
      if (a.getName().contains(name))
        temp.add(a);
    sortedActivityList = new ArrayList<Activity>(temp);
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
      ui.setDescriptionArea(activityList.get(selectedRow).getDescription());
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
        activityList.remove(selectedRow);
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
<<<<<<< HEAD
      if (selectedRow != -1){
    	  Activity toEdit = ActivityController.selectFromActivity((long)ui.getTable().getValueAt(selectedRow, 0));
          new ManageActivityPresenter(new ManageActivityUI(),toEdit);
      }
      
=======
      if (selectedRow != -1)
        new ManageActivityPresenter(new ManageActivityUI(),
            sortedActivityList.get(selectedRow));
>>>>>>> f830af1dacec891af88cc70e30a3e8ae0df1c062
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
