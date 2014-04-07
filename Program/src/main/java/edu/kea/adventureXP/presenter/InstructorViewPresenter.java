package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kea.adventureXP.view.InstructorViewerUI;
import edu.kea.adventureXP.view.ManageInstructorUI;

public class InstructorViewPresenter {

	InstructorViewerUI ivui;
	
	public InstructorViewPresenter(InstructorViewerUI ivui) {
		this.ivui = ivui;
		ivui.setAddButtonListener(new AddButtonListener());
	}
	
	private class AddButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			new ManageInstructorPresenter(new ManageInstructorUI());
		}
	}
}
