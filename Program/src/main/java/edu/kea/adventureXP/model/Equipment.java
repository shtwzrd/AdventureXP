package edu.kea.adventureXP.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EQUIPMENT")
public class Equipment {
  
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private long   id;
  
  @Column
  private String name;
  @Column
  private String brand;
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date   date;
  @Column
  private String note;
  
  public Equipment(String name, String brand, Date date) {
    this.name = name;
    this.brand = brand;
    this.date = date;
    
  }
  
  public Equipment(String name, String brand, Date date, String note) {
    this.name = name;
    this.brand = brand;
    this.date = date;
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
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
  public String getNote() {
    return note;
  }
  
  public void setNote(String note) {
    this.note = note;
  }
  
}
