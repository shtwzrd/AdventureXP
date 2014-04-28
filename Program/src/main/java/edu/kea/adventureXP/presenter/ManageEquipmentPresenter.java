package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import edu.kea.adventureXP.model.Equipment;
import edu.kea.adventureXP.model.EquipmentController;
import edu.kea.adventureXP.view.ManageEquipmentUI;

public class ManageEquipmentPresenter {
  
  private ManageEquipmentUI        ui;
  private EquipmentViewerPresenter avp;
  private Equipment                equipment = null;
  private boolean                  edit      = false;
  
  /**
   * Constructor when wanting to open 'Manage equipment' with pre-filled fields.
   * 
   * @param ui UI for 'Manage equipment'.
   * @param equipment Object of equipment, which delivers information to the
   *          fields.
   */
  public ManageEquipmentPresenter(ManageEquipmentUI ui, Equipment equipment,
      EquipmentViewerPresenter avp) {
    this(ui, avp);
    ui.setNameField(equipment.getName());
    ui.setBrandField(equipment.getBrand());
    ui.setNoteArea(equipment.getNote());
    this.equipment = equipment;
    edit = true;
  }
  
  /**
   * Constructor for 'Manage equipment', which adds listeners to the buttons.
   * 
   * @param ui UI for 'Manage equipment'.
   */
  public ManageEquipmentPresenter(ManageEquipmentUI ui, EquipmentViewerPresenter avp) {
    this.ui = ui;
    this.avp = avp;
    ui.setSaveListener(new SaveButtonListener());
    ui.setDiscardListener(new DiscardButtonListener());
  }
  
  /**
   * The class Constructor. It sets the button listeners for the buttons in
   * ManageequipmentUI.
   * 
   * @param ui The ManageequipmentUI
   * @param controller The equipmentController
   */
  public ManageEquipmentPresenter(ManageEquipmentUI ui, EquipmentController controller) {
    this.ui = ui;
    ui.setSaveListener(new SaveButtonListener());
    ui.setDiscardListener(new DiscardButtonListener());
  }
  
  /**
   * Default constructor
   */
  public ManageEquipmentPresenter() {
  }
  
  /**
   * Validates the name field in ManageequipmentUI.
   * 
   * @param name The String in the text field.
   * @return true if the field is not empty
   */
  public boolean validateName(String name) {
    return !name.isEmpty();
  }
  
  /**
   * Validates the Brand field in ManageequipmentUI.
   * 
   * @param string The Brand as double.
   * @return true if Brand is not negative.
   */
  public boolean validateBrand(String string) {
    // return string >= 0;
    return true;
  }
  
  /**
   * Inner private class implementing the behavior of an ActionListener. The
   * class has the behavior for saving an equipment.
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
      
      if (!validateBrand(ui.getBrandField())) {
        errorMessage += "- Brand must be bigger than or equal to 0.\n";
        flag = false;
      }
      
      if (flag) {
        // Call the Controller
        if (edit) {
          equipment.setNote(ui.getNoteField());
          equipment.setName(ui.getNameField());
          equipment.setBrand(ui.getBrandField());
          System.out.println(equipment.getNote());
          System.out.println(equipment.getName());
          System.out.println(equipment.getDate());
          System.out.println(equipment.getBrand());
          EquipmentController.updateEquipment(equipment);
        }
        else {
          Equipment equipment = new Equipment(ui.getNameField(), ui.getBrandField(),
              new GregorianCalendar(), ui.getNoteField());
          EquipmentController.addEquipment(equipment);
        }
        avp.updateTable();
        ui.dispose();
      }
      else
        ui.displayError(errorMessage);
    }
    
  }
  
  /**
   * Inner private class implementing the behaviour of an ActionListener. The
   * class has the behaviour for discarding the changes made to an equipment.
   */
  private class DiscardButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      ui.dispose();
    }
    
  }
  
}
