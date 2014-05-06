package edu.kea.adventureXP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 
 * Class representing a Member that can represent either an Instructor or a Customer
 *
 */
@Entity
@Table(name = "MEMBER")
public class Member {

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String street;

	@Column
	private String zipCode;

	@Column
	private String country;

	@Column
	private String city;

	@Column
	private String telephone;

	@Column
	private String email;
	
	@Column
	private boolean instructor;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private int id;
	

	/**
	 * 
	 * @param fName represents the first name.
	 * @param lName represents the last name.
	 * @param street represents the street name.
	 * @param streetNum represents the street number.
	 * @param zipCode represents the postal code.
	 * @param city represents the city name.
	 * @param telephone represents the telephone number.
	 * @param email represents the email address.
	 * @param instructor true for instructor, false for member
	 * @param id represents the unique id, which is auto incremented from the database.
	 */
	public Member(String fName, String lName, String street,
			String zipCode, String city, String country, String telephone, String email, boolean instructor)	 {
		this.firstName = fName;
		this.lastName = lName;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.telephone = telephone;
		this.email = email;
		this.country = country;
		this.instructor = instructor;
	}

	
	public Member() {
		this.instructor = true;
	}

	/**
	 * 
	 * @return the id for this Member
	 */
	public int getId(){
		return this.id;
	}

	/**
	 * Sets the id for this Member
	 * @param id the id to set
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * 
	 * @return the firstName for this Member
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets the firstName for this Member
	 * @param fName the name to set
	 */
	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	/**
	 * 
	 * @return the lastName for this Member
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets the lastName for this Member
	 * @param lName the lastName to set
	 */
	public void setLastName(String lName) {
		this.lastName = lName;
	}

	/**
	 * 
	 * @return the street for this Member
	 */
	public String getStreet(){
		return this.street;
	}

	/**
	 * Sets the street for this Member
	 * @param street the new street
	 */
	public void setStreet(String  street){
		this.street = street;
	}

	/**
	 * 
	 * @return the zipCode for this Member
	 */
	public String getZipCode(){
		return this.zipCode;
	}

	/**
	 * sets the zipCoce for this Member
	 * @param zipCode 
	 */
	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

	/**
	 * 
	 * @return the city for this Member
	 */
	public String getCity(){
		return this.city;
	}

	/**
	 * Sets the city for this Member
	 * @param city
	 */
	public void setCity(String city){
		this.city = city;
	}

	/**
	 * 
	 * @return the telephone for this Member
	 */
	public String getTelephone(){
		return this.telephone;
	}

	/**
	 * Sets the telephone for this Member
	 * @param telephone
	 */
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}

	/**
	 * 
	 * @return the email for this Member
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 * Sets the email for this Member
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}

	/**
	 * Sets the country for this Member
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return the country for this Member
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * 
	 * @return true if this object is an Instructor, false if this object is a Customer
	 */
	public boolean isInstructor() {
		return instructor;
	}

	/**
	 * Sets if this Member is an Instructor
	 * @param instructor true if an Instructor, false if a Customer
	 */
	public void setInstructor(boolean instructor) {
		this.instructor = instructor;
	}
	
	
}
