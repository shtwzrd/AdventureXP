package edu.kea.adventureXP.model;

public class Instructor {

	private String fName;
	private String lName;
	private String street;
	private int streetNum;
	private int zipCode;
	private String city;
	private int telephone;
	private String email;
	private int id;
	
	public Instructor(String fName, String lName, String street, int streetNum, int zipCode,
						String city, int telephone, String email, int id)	 {
		this.fName = fName;
		this.lName = lName;
		this.street = street;
		this.streetNum = streetNum;
		this.zipCode = zipCode;
		this.city = city;
		this.telephone = telephone;
		this.email = email;
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	public String getFName() {
		return fName;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public String getStreet(){
		return street;
	}
	
	public void setStreet(String  street){
		this.street = street;
	}
	
	public int getStreetNum(){
		return streetNum;
	}
	
	public void setStreetNum(int streetNum){
		this.streetNum = streetNum;
	}
	
	public int getZipCode(){
		return zipCode;
	}
	
	public void setZipCode(int zipCode){
		this.zipCode = zipCode;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public int getTelephone(){
		return telephone;
	}
	
	public void setTelephone(int telephone){
		this.telephone = telephone;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
}
