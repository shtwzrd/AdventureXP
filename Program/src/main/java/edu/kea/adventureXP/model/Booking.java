package edu.kea.adventureXP.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 
 * Class represent a Booking with an Scheduled Activity and a customer
 *
 */
@Entity
@Table(name = "BOOKING")
public class Booking {


	 @Id
	  @GeneratedValue(generator = "increment")
	  @GenericGenerator(name = "increment", strategy = "increment")
	  private long    id;
	 
	 @ManyToOne(fetch=FetchType.EAGER)  
	 @JoinColumn(name = "id", insertable = false, updatable = false)  
	 private ScheduledActivity scheduledActivity;	 
	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="id", insertable = false, updatable = false )
	 private Member customer;
	 
	 public Booking(){
		 
	 }
	 
	 /**
	  * Controller for creating a Booking parsing its scheduledActivity and customer.
	  * 
	  * @param scheduledActivity
	  * @param customer
	  */
	 public Booking(ScheduledActivity scheduledActivity, Member customer){
		 this.scheduledActivity = scheduledActivity;
		 this.customer = customer;
	 }


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the scheduledActivity
	 */
	public ScheduledActivity getScheduledActivity() {
		return scheduledActivity;
	}

	/**
	 * @param scheduledActivity the scheduledActivity to set
	 */
	public void setScheduledActivity(ScheduledActivity scheduledActivity) {
		this.scheduledActivity = scheduledActivity;
	}

	/**
	 * @return the customer
	 */
	public Member getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Member customer) {
		this.customer = customer;
	}
 
  /**
   * 
   * @return the id
   */
  public long getId() {
    return id;
  }
  
}
