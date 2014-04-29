package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import edu.kea.adventureXP.model.Activity;
import edu.kea.adventureXP.model.ActivityController;
import edu.kea.adventureXP.model.EventPackage;
import edu.kea.adventureXP.model.EventPackageController;
import edu.kea.adventureXP.view.ManageActivityUI;
import edu.kea.adventureXP.view.ManagePackageUI;

/**
 * Presenter class for the ManageActivityUI. It gets and saves information about
 * activities for the view.
 * 
 * @see ManageActivityUI
 */
public class ManageEventPackagePresenter {
  
  private ManagePackageUI        ui;
  private EventPackageViewerPresenter epvp;
  private EventPackage           event     = null;
  private boolean                 edit     = false;
  
  /**
   * Constructor for wanting to open 'Manage Activity' with pre-filled fields.
   * 
   * @param ui UI for 'Manage Activity'
   * @param activity Object of Activity, which delivers information to the
   *          fields
   * @param avp The Viewer that should be updated after the activity has been
   *          edited
   */
  public ManageEventPackagePresenter(ManagePackageUI ui, EventPackage package,
      EventPackageViewerPresenter avp) {
    this(ui, avp);
    ui.setNameField(package.getName());
    ui.setPriceField(package.getPrice());
    ui.setDurationField(package.getDuration);
    ui.setArea(activity.getDescription());
    ui.setIsActive(activity.getIsActive());
    this.activity = activity;
    edit = true;
  }
  
  /**
   * Constructor for 'Manage Activity', which adds listeners to the buttons.
   * 
   * @param ui UI for 'Manage Activity'
   * @param avp The Viewer that should be updated after a Activity has been
   *          saved
   */
  public ManageEventPackagePresenter(ManagePackageUI ui, EventPackageViewerPresenter avp) {
    this.ui = ui;
    this.epvp = avp;
    ui.setSaveListener(new SaveButtonListener());
    ui.setDiscardListener(new DiscardButtonListener());
    ui.setAddActivityListener(new AddActivityButtonListener());
    ui.setRemoveActivityListener(new RemoveActivityButtonListener());
    ui.setActivityTable(ActivityController.selectAllFromActivity());
  }
  
  /**
   * Default constructor
   */
  public ManageEventPackagePresenter() {
  }
  
  /**
   * Validates the name field in ManageActivityUI.
   * 
   * @param name The String in the text field.
   * @return true if the field is not empty
   */
  public boolean validateName(String name) {
    return !name.isEmpty();
  }
  
  /**
   * Validates the price field in ManageActivityUI.
   * 
   * @param price The price as double.
   * @return true if price is not negative.
   */
  public boolean validatePrice(double price) {
    return price >= 0;
  }
  
  /**
   * Inner private class implementing the behavior of an ActionListener. The
   * class has the behavior for saving an Activity.
   */
  private class SaveButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      String errorMessage = "";
      boolean flag = true;
      
      if (!validateName(ui.getNameField())) {
        errorMessage += "- Name field cannot be empty.\n";
        flag = false;
      }
      
      if (!validatePrice(ui.getPriceField())) {
        errorMessage += "- Price must be greater than or equal to 0.\n";
        flag = false;
      }
      
      if (flag) {
        // Call the Controller
     //   if (edit) {
     //     event.setDuration(ui.getDurationField());
     //     event.setName(ui.getNameField());
     //     event.setPrice(ui.getPriceField());
     //     event.setIsActive(ui.getIsActive());
     //     EventPackageController.(event);
     //   }
        
      //  else { 
          int rows = ui.getActivityTable().getRowCount();
          Set<Activity> set = new HashSet<>();
          
          for(int i = 0; i < rows; i++) {
              long id = (long) ui.getActivityTable().getValueAt(i, 0);
          }
          EventPackage toAdd = new EventPackage(ui.getNameField(), ui.getActivities(),
              ui.getDurationField(), ui.getPriceField());
          EventPackageController.addEventPackage(toAdd);
        epvp.updateTable();
        ui.dispose();
      }
      //else
        //ui.displayError(errorMessage);
    }
    
  }
  
  /**
   * Inner private class implementing the behaviour of an ActionListener. The
   * class has the behaviour for discarding the changes made to an Activity.
   */
  private class DiscardButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      ui.dispose();
    }
    
  }
  
}
