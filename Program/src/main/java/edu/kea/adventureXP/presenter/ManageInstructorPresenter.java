package edu.kea.adventureXP.presenter;

import edu.kea.adventureXP.view.ManageInstructorUI;

public class ManageInstructorPresenter {
	
	ManageInstructorUI iui;
	
//	public ManageInstructorPresenter(ManageInstructorUI iui) {
//		this.iui = iui;
//		//iui.setSaveListener(new SaveButtonListener);
//	}

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
}
