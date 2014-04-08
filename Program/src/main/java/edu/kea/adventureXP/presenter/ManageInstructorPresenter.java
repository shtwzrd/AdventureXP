package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import edu.kea.adventureXP.view.ManageInstructorUI;
import edu.kea.adventureXP.view.InstructorViewerUI;
import edu.kea.adventureXP.presenter.InstructorViewerPresenter;
import edu.kea.adventureXP.model.InstructorController;
import edu.kea.adventureXP.model.Instructor;

public class ManageInstructorPresenter {

  ManageInstructorUI iui;
  Instructor instructorToEdit;
  InstructorViewerPresenter ivp;
  private boolean isEdit;


  public ManageInstructorPresenter() {
    this.isEdit = false;
    this.iui = new ManageInstructorUI();
  }

  public ManageInstructorPresenter(ManageInstructorUI iui) {
    this.iui = iui;
    this.isEdit = false;
    iui.setSaveListener(new SaveButtonListener());
    iui.setDiscardListener(new DiscardButtonListener());
  }

  public ManageInstructorPresenter(ManageInstructorUI iui, InstructorViewerPresenter ivp,
      Instructor instructorToEdit) {
    this.iui = new ManageInstructorUI();
    this.ivp = ivp;
    this.instructorToEdit = instructorToEdit;
    this.isEdit = true;
  }

  public boolean validateFirstName(String name) {
    return !name.isEmpty();
  }

  public boolean validateLastName(String lname){
    return !lname.isEmpty();
  }

  public boolean validateStreetField(String street){
    return !street.isEmpty();
  }

  public boolean validateStreetNumField(String string) {
    return Integer.parseInt(string) > 0;
  }
  public boolean validateCityField(String cityName){
    return !cityName.isEmpty();
  }

  public boolean validateZipField(String zipCode) {
    return !zipCode.isEmpty();
  }

  public boolean validatePhoneField(String string) {
    return string.length() >= 7;
  }

  public boolean validateEmailField(String email) {
    if(email.contains("@") && email.contains(".") && !email.isEmpty())
      return true;
    else
      return false;
  }

  /**
   * 
   * SaveButtonListener is a private class implementing the behavior of an ActionListener. The
   * class has the behavior for saving informations about a person..
   *
   */

  private class SaveButtonListener implements ActionListener {

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

      if(!validateStreetField(iui.getStreetField())) {
        errorMessage += "Street cannot be empty.\n";
        flag = false;
      }

      if(!validateStreetNumField(iui.getStreetNumField())){
        errorMessage += "Street number cannot be empty.\n";
        flag = false;
      }

      if(!validateCityField(iui.getCityField())){
        errorMessage += "City field cannot be empty. \n";
        flag = false;
      }

      if(!validateZipField(iui.getZipField())){
        errorMessage += "Zip field cannot be empty. \n";
        flag = false;
      }

      if(!validatePhoneField(iui.getPhoneField())){
        errorMessage += "Phone number should contain 7 or more digits. \n";
        flag = false;
      }

      if(!validateEmailField(iui.getEmailField())){
        errorMessage += "Email should contain . and @ . And it should not be empty. \n";
        flag = false;

      }
      if (flag) {
        if(isEdit) {
          InstructorController.updateInstructor(instructorToEdit);
          ivp.updateUI();
          iui.dispose();
        } else {
          List<String> phones = new ArrayList<>();
          phones.add(iui.getPhoneField() + "");
          Instructor instructor = new Instructor(
              iui.getFNameField(),
              iui.getLNameField(),
              iui.getStreetNumField() + "",
              iui.getStreetField(),
              iui.getZipField(),
              iui.getCityField(),
              "Denmark",
              phones,
              iui.getEmailField());

          InstructorController.addInstructor(instructor);  
          ivp.updateUI();
          iui.dispose();
        }
      } else {
        iui.displayError(errorMessage);
      }
    }
  }
  /**
   * DiscardButtonListener is a private class implementing the behavior of an ActionListener. The
   *class has the behavior for discarding the changes made on the information about a person.
   *
   */
  private class DiscardButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      iui.dispose();
    }

  }
} 

