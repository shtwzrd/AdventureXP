package edu.kea.adventureXP.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Class representing a ScheduledActivity with an id and a date.
 */
@Entity
@Table(name = "SCHEDULEDACTIVITY")
public class ScheduledActivity {
  
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private long id;
  @Column
  private Date date;
  
  public ScheduledActivity() {
  }
  
  /**
   * Controller for creating a ScheduledActivity parsing its id and date
   * 
   * @param id
   * @param date
   */
  public ScheduledActivity(int id, Date date) {
    this.id = id;
    this.date = date;
  }
  
  /**
   * @return the id
   */
  public long getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }
  
  /**
   * @return the date
   */
  public Date getDate() {
    return date;
  }
  
  /**
   * @param date the date to set
   */
  public void setDate(Date date) {
    this.date = date;
  }
  
}
