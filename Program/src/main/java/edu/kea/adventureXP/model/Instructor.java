package edu.kea.adventureXP.model;

import javax.persistence.*;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="INSTRUCTOR")
public class Instructor {

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private String street;

  @Column
  private String streetNum;

  @Column
  private String zipCode;

  private String country;

  @Column
  private String city;

  @ElementCollection
  @JoinTable(name="PHONE",
  joinColumns = {@JoinColumn(name="id")})
  private List<String> telephone;

  @Column
  private String email;

  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy="increment")
  private int id;

  public Instructor(String fName, String lName, String streetNum, String street,
      String zipCode, String city,	String country, List<String> telephone, String email)	 {
    this.firstName = fName;
    this.lastName = lName;
    this.street = street;
    this.streetNum = streetNum;
    this.zipCode = zipCode;
    this.city = city;
    this.telephone = telephone;
    this.email = email;
    this.country = country;
  }

  public Instructor() {

  }

  public int getID(){
    return this.id;
  }

  private void setID(int id){
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String fName) {
    this.firstName = fName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLName(String lName) {
    this.lastName = lName;
  }

  public String getStreet(){
    return this.street;
  }

  public void setStreet(String  street){
    this.street = street;
  }

  public String getStreetNum(){
    return this.streetNum;
  }

  public void setStreetNum(String streetNum){
    this.streetNum = streetNum;
  }

  public String getZipCode(){
    return this.zipCode;
  }

  public void setZipCode(String zipCode){
    this.zipCode = zipCode;
  }

  public String getCity(){
    return this.city;
  }

  public void setCity(String city){
    this.city = city;
  }

  public List<String> getTelephone(){
    return this.telephone;
  }

  public void setTelephone(List<String> telephone){
    this.telephone = telephone;
  }

  public void addPhone(String phone) {
    this.telephone.add(phone);
  }

  public void removePhone(String phone) {
    this.telephone.remove(phone);
  }

  public String getEmail(){
    return this.email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountry() {
    return this.country;
  }
}
