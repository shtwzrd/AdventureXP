package edu.kea.adventureXP.view;

import edu.kea.adventureXP.presenter.InstructorViewPresenter;

public class TestRun {
	public static void main(String[] args) {
		new InstructorViewPresenter(new InstructorViewerUI());
	}
}
