package edu.kea.adventureXP.presenter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ManageInstructorPresenterTest {
	ManageInstructorPresenter mip = new ManageInstructorPresenter();

	@Test
	public void validateFirstNameTest() {
		assertTrue(mip.validateFirstName("Stoyan"));
	}
	
	public void validateLastNameTest(){
		assertTrue(mip.validateLastName("Smith"));
	}
	
	public void validateStreetFieldTest(){
		assertTrue(mip.validateStreetField("Rebeak Sopark"));
	}
	
	public void validateStreetNumFieldTest() {
		assertTrue(mip.validateStreetNumField(5));
	}
}
