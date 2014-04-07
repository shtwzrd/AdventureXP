package edu.kea.adventureXP.model.aux;

public class Zip {

	private String zipcode;
	private String country;

  public Zip(String zipcode, String country) { 
		this.zipcode = zipcode;
		this.country = country;
  }

  private Zip() {

  }

	public void setZipcode(String zipcode) {
  	this.zipcode = zipcode;
	}

	public String getZipcode() {  
		return this.zipcode;
	}

	public void setCountry(String country) {
  	this.country = country;
	}

	public String getCountry() {  
		return this.country;
	}

}
