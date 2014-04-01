package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kea.adventureXP.view.ManageInstructorUI;

public class ManageInstructorPresenter {
	
	ManageInstructorUI iui;
	
	public ManageInstructorPresenter() {
		
	}
	
	public ManageInstructorPresenter(ManageInstructorUI iui) {
		this.iui = iui;
		iui.setSaveListener(new SaveButtonListener());
		iui.setDiscardListener(new DiscardButtonListener());
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
	
	public boolean validateStreetNumField(int streetNum) {
		return streetNum > 0;
	}
	public boolean validateCityField(String cityName){
		return !cityName.isEmpty();
	}
	
	public boolean validateZipField(String zipCode) {
		return !zipCode.isEmpty();
	}
	
	public boolean validatePhoneField(int phone) {
		return phone >= 7;
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
		    	  errorMessage += "Phone number should contain 7 digets. \n";
		    	  flag = false;
		      }
		      
		      if(!validateEmailField(iui.getEmailField())){
		    	  errorMessage += "Email should contain . and @ . And it should not be empty. \n";
		    	  flag = false;
		    	  
		      }
		      if (flag) {
		        // Call the Controller
		      }
		      else
		        iui.displayError(errorMessage);
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
