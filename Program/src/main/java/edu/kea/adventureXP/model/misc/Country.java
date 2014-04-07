package edu.kea.adventureXP.model.aux;

public class Country {

	private String name;

  public Country(String name) { 
		this.name = name;
  }

  private Country() {

  }

	public void setName(String name) {
  	this.name = name;
	}

	public String getName() {  
		return this.name;
	}

}
