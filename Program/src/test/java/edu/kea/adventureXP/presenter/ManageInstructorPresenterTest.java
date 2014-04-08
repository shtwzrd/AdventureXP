package edu.kea.adventureXP.presenter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ManageInstructorPresenterTest {
	ManageInstructorPresenter mip = new ManageInstructorPresenter();

	@Test
	public void validateFirstNameTest() {
		assertTrue(mip.validateFirstName("Stoyan"));
	}
	@Test
	public void validateLastNameTest(){
		assertTrue(mip.validateLastName("Smith"));
	}
	@Test
	public void validateStreetFieldTest(){
		assertTrue(mip.validateStreetField("Rebeak Sopark"));
	}
	@Test
	public void validateStreetNumFieldTest() {
		assertTrue(mip.validateStreetNumField(5));
	}
	@Test
	public void validateCityFieldTest(){
		assertTrue(mip.validateCityField("Copenhagen"));
	}
	@Test
	public void validateZipFieldTest(){
		assertTrue(mip.validateZipField("2720"));
	}
	
	@Test
	public void validatePhoneFieldTest(){
		assertTrue(mip.validatePhoneField(53811118));
	}
	
	@Test
	public void validateEmailFieldTest(){
		assertTrue(mip.validateEmailField("stoyan.bonchev@yahoo.com"));
	}
}
