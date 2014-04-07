package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kea.adventureXP.model.Activity;
import edu.kea.adventureXP.view.ManageActivityUI;

public class ManageActivityPresenter {
  
  ManageActivityUI ui;
  
  /**
   * Constructor when wanting to open 'Manage Activity' with pre-filled fields.
   * 
   * @param ui UI for 'Manage Activity'.
   * @param activity Object of Activity, which delivers information to the
   *          fields.
   */
  public ManageActivityPresenter(ManageActivityUI ui, Activity activity) {
    this(ui);
    ui.setNameField(activity.getName());
    ui.setPriceField(activity.getPrice());
    ui.setDescriptionArea(activity.getDescription());
  }
  
  /**
   * Constructor for 'Manage Activity', which adds listeners to the buttons.
   * 
   * @param ui UI for 'Manage Activity'.
   */
  public ManageActivityPresenter(ManageActivityUI ui) {
    this.ui = ui;
    ui.setSaveListener(new SaveButtonListener());
    ui.setDiscardListener(new DiscardButtonListener());
  }
  
  /**
   * Default constructor
   */
  public ManageActivityPresenter() {
  }
  
  public boolean validateName(String name) {
    return !name.isEmpty();
  }
  
  public boolean validatePrice(double price) {
    return price >= 0;
  }
  
  /**
   * Inner private class implementing the behaviour of an ActionListener. The
   * class has the behaviour for saving an Activity.
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
        errorMessage += "- Price must be bigger than or equal to 0.\n";
        flag = false;
      }
      
      if (flag) {
        // Call the Controller
      }
      else
        ui.displayError(errorMessage);
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
