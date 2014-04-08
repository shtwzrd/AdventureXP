package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.kea.adventureXP.model.Instructor;
import edu.kea.adventureXP.model.InstructorController;
import edu.kea.adventureXP.view.ManageInstructorUI;

public class ManageInstructorPresenter {
  
  ManageInstructorUI        iui;
  Instructor                instructorToEdit;
  InstructorViewerPresenter ivp;
  private boolean           isEdit;
  
  public ManageInstructorPresenter() {
    isEdit = false;
    iui = new ManageInstructorUI();
  }
  
  public ManageInstructorPresenter(ManageInstructorUI iui, InstructorViewerPresenter ivp) {
    isEdit = false;
    this.iui = iui;
    this.ivp = ivp;
    iui.setSaveListener(new SaveButtonListener());
    iui.setDiscardListener(new DiscardButtonListener());
  }
  
  public ManageInstructorPresenter(ManageInstructorUI iui, InstructorViewerPresenter ivp,
      Instructor instructorToEdit) {
    this.iui = iui;
    this.ivp = ivp;
    iui.setFields(instructorToEdit);
    this.instructorToEdit = instructorToEdit;
    isEdit = true;
  }
  
  public boolean validateFirstName(String name) {
    return !name.isEmpty();
  }
  
  public boolean validateLastName(String lname) {
    return !lname.isEmpty();
  }
  
  public boolean validateStreetField(String street) {
    return !street.isEmpty();
  }
  
  public boolean validateStreetNumField(String string) {
    return Integer.parseInt(string) > 0;
  }
  
  public boolean validateCityField(String cityName) {
    return !cityName.isEmpty();
  }
  
  public boolean validateZipField(String zipCode) {
    return !zipCode.isEmpty();
  }
  
  public boolean validatePhoneField(String string) {
    return string.length() >= 7;
  }
  
  public boolean validateEmailField(String email) {
    if (email.contains("@") && email.contains(".") && !email.isEmpty())
      return true;
    else
      return false;
  }
  
  /**
   * 
   * SaveButtonListener is a private class implementing the behavior of an
   * ActionListener. The class has the behavior for saving informations about a
   * person..
   *
   */
  
  private class SaveButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      String errorMessage = "";
      boolean flag = true;
      
      if (!validateFirstName(iui.getFNameField())) {
        errorMessage += "- First name field cannot be empty.\n";
        flag = false;
      }
      
      if (!validateLastName(iui.getLNameField())) {
        errorMessage += "- Last name field cannot be empty.\n";
        flag = false;
      }
      
      if (!validateStreetField(iui.getStreetField())) {
        errorMessage += "Street cannot be empty.\n";
        flag = false;
      }
      
      if (!validateCityField(iui.getCityField())) {
        errorMessage += "City field cannot be empty. \n";
        flag = false;
      }
      
      if (!validateZipField(iui.getZipField())) {
        errorMessage += "Zip field cannot be empty. \n";
        flag = false;
      }
      
      if (!validatePhoneField(iui.getPhoneField())) {
        errorMessage += "Phone number should contain 7 or more digits. \n";
        flag = false;
      }
      
      if (!validateEmailField(iui.getEmailField())) {
        errorMessage += "Email should contain . and @ . And it should not be empty. \n";
        flag = false;
        
      }
      if (flag) {
        if(ManageInstructorPresenter.this.isEdit) {
        	ManageInstructorPresenter.this.iui.setFNameField(instructorToEdit.getFirstName());
        	ManageInstructorPresenter.this.iui.setLNameField(instructorToEdit.getLastName());
        	ManageInstructorPresenter.this.iui.setStreetField(instructorToEdit.getStreet());
        	ManageInstructorPresenter.this.iui.setCityField(instructorToEdit.getCity());
        	ManageInstructorPresenter.this.iui.setZipField(instructorToEdit.getZipCode());
        	ManageInstructorPresenter.this.iui.setPhoneField(instructorToEdit.getTelephone());
        	ManageInstructorPresenter.this.iui.setEmailField(instructorToEdit.getEmail());
          InstructorController.updateInstructor(ManageInstructorPresenter.this.instructorToEdit);
          ManageInstructorPresenter.this.ivp.updateUI();
          ManageInstructorPresenter.this.iui.dispose();
        } else {
          Instructor instructor = new Instructor(
              ManageInstructorPresenter.this.iui.getFNameField(),
              ManageInstructorPresenter.this.iui.getLNameField(),
              ManageInstructorPresenter.this.iui.getStreetField(),
              ManageInstructorPresenter.this.iui.getZipField(),
              ManageInstructorPresenter.this.iui.getCityField(),
              "Denmark",
              ManageInstructorPresenter.this.iui.getPhoneField(), 
              ManageInstructorPresenter.this.iui.getEmailField());

          InstructorController.addInstructor(instructor);  
          ManageInstructorPresenter.this.ivp.updateUI();
          ManageInstructorPresenter.this.iui.dispose();
        }
      }
      else
        iui.displayError(errorMessage);
    }
  }
  
  /**
   * DiscardButtonListener is a private class implementing the behavior of an
   * ActionListener. The class has the behavior for discarding the changes made
   * on the information about a person.
   */
  private class DiscardButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      iui.dispose();
    }
    
  }
}
