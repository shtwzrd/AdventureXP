package edu.kea.adventureXP.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "EQUIPMENT")
public class Equipment {
  
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private long     id;
  
  @Column
  private String   name;
  @Column
  private String   brand;
  @Column
  @Type(type = "date")
  private Calendar Date;
  @Column
  private String   note;
  
  public Equipment(String name, String brand, Calendar Date) {
    this.name = name;
    this.brand = brand;
    this.Date = Date;
    
  }
  
  public Equipment(String name, String brand, Calendar Date, String note) {
    this.name = name;
    this.brand = brand;
    this.Date = Date;
    this.note = note;
    
  }
  
  public Equipment() {
    
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public long getID() {
    return id;
  }
  
  public void setID(long id) {
    this.id = id;
  }
  
  public String getBrand() {
    return brand;
  }
  
  public void setBrand(String brand) {
    this.brand = brand;
  }
  
  public Calendar getDate() {
    return Date;
  }
  
  public void setDate(Calendar Date) {
    this.Date = Date;
  }
  
  public String getNote() {
    return note;
  }
  
  public void setNote(String note) {
    this.note = note;
  }
  
}
