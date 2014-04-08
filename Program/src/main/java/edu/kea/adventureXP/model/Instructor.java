package edu.kea.adventureXP.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "INSTRUCTOR")
public class Instructor {
  
  @Column
  private String       firstName;
  
  @Column
  private String       lastName;
  
  @Column
  private String       street;
  
  @Column
  private String       zipCode;
  
  @Column
  private String       country;
  
  @Column
  private String       city;
  
  @ElementCollection
  @JoinTable(name = "PHONE", joinColumns = { @JoinColumn(name = "id") })
  private List<String> telephone;
  
  @Column
  private String       email;
  
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int          id;
  
  /**
   * 
   * @param fName represents the first name.
   * @param lName represents the last name.
   * @param street represents the street name.
   * @param zipCode represents the postal code.
   * @param city represents the city name.
   * @param telephone represents the telephone number.
   * @param email represents the email address.
   * @param id represents the unique id, which is auto incremented from the
   *          database.
   */
  public Instructor(String fName, String lName, String street, String zipCode,
      String city, String country, List<String> telephone, String email) {
    firstName = fName;
    lastName = lName;
    this.street = street;
    this.zipCode = zipCode;
    this.city = city;
    this.telephone = telephone;
    this.email = email;
    this.country = country;
  }
  
  public Instructor() {
    
  }
  
  public int getId() {
    return id;
  }
  
  private void setId(int id) {
    this.id = id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String fName) {
    firstName = fName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lName) {
    lastName = lName;
  }
  
  public String getStreet() {
    return street;
  }
  
  public void setStreet(String street) {
    this.street = street;
  }
  
  public String getZipCode() {
    return zipCode;
  }
  
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public List<String> getTelephone() {
    return telephone;
  }
  
  public void setTelephone(List<String> telephone) {
    this.telephone = telephone;
  }
  
  public void addPhone(String phone) {
    telephone.add(phone);
  }
  
  public void removePhone(String phone) {
    telephone.remove(phone);
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public String getCountry() {
    return country;
  }
}
