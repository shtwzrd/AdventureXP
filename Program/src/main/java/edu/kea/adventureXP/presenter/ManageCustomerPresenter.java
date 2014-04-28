package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kea.adventureXP.model.Member;
import edu.kea.adventureXP.model.MemberController;
import edu.kea.adventureXP.view.ManageCustomerUI;

public class ManageCustomerPresenter {
  
  ManageCustomerUI        cui;
  Member                customerToEdit;
  CustomerViewerPresenter cvp;
  private boolean           isEdit;
  
  public ManageCustomerPresenter() {
    isEdit = false;
    cui = new ManageCustomerUI();
  }
  
  public ManageCustomerPresenter(ManageCustomerUI cui, CustomerViewerPresenter cvp) {
    isEdit = false;
    this.cui = cui;
    this.cvp = cvp;
    cui.setSaveListener(new SaveButtonListener());
    cui.setDiscardListener(new DiscardButtonListener());
  }
  
  public ManageCustomerPresenter(ManageCustomerUI cui, CustomerViewerPresenter cvp,
      Member customerToEdit) {
    isEdit = true;
    this.cui = cui;
    this.cvp = cvp;
    cui.setSaveListener(new SaveButtonListener());
    cui.setDiscardListener(new DiscardButtonListener());
    
    this.customerToEdit = customerToEdit;
    cui.setFields(customerToEdit);
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
      
      if (!validateFirstName(cui.getFNameField())) {
        errorMessage += "- First name field cannot be empty.\n";
        flag = false;
      }
      
      if (!validateLastName(cui.getLNameField())) {
        errorMessage += "- Last name field cannot be empty.\n";
        flag = false;
      }
      
      if (!validateStreetField(cui.getStreetField())) {
        errorMessage += "Street cannot be empty.\n";
        flag = false;
      }
      
      if (!validateCityField(cui.getCityField())) {
        errorMessage += "City field cannot be empty. \n";
        flag = false;
      }
      
      if (!validateZipField(cui.getZipField())) {
        errorMessage += "Zip field cannot be empty. \n";
        flag = false;
      }
      
      if (!validatePhoneField(cui.getPhoneField())) {
        errorMessage += "Phone number should contain 7 or more digits. \n";
        flag = false;
      }
      
      if (!validateEmailField(cui.getEmailField())) {
        errorMessage += "Email should contain . and @ . And it should not be empty. \n";
        flag = false;
        
      }
      if (flag) {
        Member customer = new Member(cui.getFNameField(), cui.getLNameField(),
            cui.getStreetField(), cui.getZipField(), cui.getCityField(), "Denmark",
            cui.getPhoneField(), cui.getEmailField(), false);
        if (isEdit)
          MemberController.updateMember(customerToEdit);
        else
          MemberController.addMember(customer);
        
        cvp.updateTable();
        cui.dispose();
      }
      else
        cui.displayError(errorMessage);
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
      cui.dispose();
    }
  }
}
