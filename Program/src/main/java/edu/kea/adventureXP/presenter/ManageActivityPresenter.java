package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kea.adventureXP.model.Activity;
import edu.kea.adventureXP.model.ActivityController;
import edu.kea.adventureXP.view.ManageActivityUI;

/** Presenter class for the ManageActivityUI.java It gets  and saves
 * 	information about activities for the view.
 * 
 * 	@see ManageActivityUI.java. */
public class ManageActivityPresenter {
  
  private ManageActivityUI ui;
  private ActivityController controller;
  
  public ManageActivityPresenter() {
  }
  
  /** The class Constructor. It sets the button listeners for the buttons
   * 	in ManageActivityUI.
   *	@param ui The ManageActivityUI
   *	@param controller The ActivityController*/
  public ManageActivityPresenter(ManageActivityUI ui, ActivityController controller) {
    this.ui = ui;
	this.controller = controller;
    ui.setSaveListener(new SaveButtonListener());
    ui.setDiscardListener(new DiscardButtonListener());
  }
  
  // METHODS >> VALIDATE THE INPUT FROM THE USER INTERFACE
  /**
   *  Validates the name field in ManageActivityUI. 
   * @param name The String in the text field.
   * @return true if the field is not empty
   */
  public boolean validateName(String name) {
    return !name.isEmpty();
  }
  
  /** Validates the price field in ManageActivityUI.
   * @param price The price as double.
   * @return true if price is not negative.*/
  public boolean validatePrice(double price) {
    return price >= 0;
  }
  
  /**
   * Inner private class implementing the behavior of an ActionListener. The
   * class has the behavior for saving an Activity.
   */
  private class SaveButtonListener implements ActionListener {
    
    @SuppressWarnings("static-access")
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
    	  Activity activity = new Activity(ui.getNameField(), ui.getDescriptionField(), ui.getPriceField());
    	  controller.addActivity(activity);
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
