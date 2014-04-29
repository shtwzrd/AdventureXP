package edu.kea.adventureXP.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BOOKING")
public class Booking {
  
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private long   id;
  
  @Column
  private String name;
  
  @Column
  private Date   date;
  
  public Booking(String name, Date date) {
    this.name = name;
    this.date = date;
  }
  
  public long getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
}
