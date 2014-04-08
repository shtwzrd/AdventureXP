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
  private Activity  activity = null;  
  private boolean edit = false;
  
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
    this.activity = activity;
    this.edit = true;
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

  /** The class Constructor. It sets the button listeners for the buttons
   * 	in ManageActivityUI.
   *	@param ui The ManageActivityUI
   *	@param controller The ActivityController*/
  public ManageActivityPresenter(ManageActivityUI ui, ActivityController controller) {
    this.ui = ui;
    ui.setSaveListener(new SaveButtonListener());
    ui.setDiscardListener(new DiscardButtonListener());
  }
  
  /**
   * Default constructor
   */
  public ManageActivityPresenter() {
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
    	 if(edit){
    		 activity.setDescription(ui.getDescriptionField());
    		 activity.setName(ui.getNameField());
    		 activity.setPrice(ui.getPriceField());
    		 System.out.println(activity.getDescription());
    		 System.out.println(activity.getName());
    		 System.out.println(activity.getId());
    		 System.out.println(activity.getPrice());
    		 ActivityController.updateActivity(activity);
    	 }
    	else{
      	  Activity activity = new Activity(ui.getNameField(), ui.getDescriptionField(), ui.getPriceField());
      	  ActivityController.addActivity(activity);
    	}
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
