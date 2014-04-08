package edu.kea.adventureXP.model.misc;

import javax.persistence.*;

@Entity
@Table(name="PHONE")
public class Phone {

	private String phonenumber;
  private long id;

  private Phone() {

  }

	public void setPhonenumber(String phonenumber) {
  	this.phonenumber = phonenumber;
	}

	public String getPhonenumber() {  
		return this.phonenumber;
	}

}
