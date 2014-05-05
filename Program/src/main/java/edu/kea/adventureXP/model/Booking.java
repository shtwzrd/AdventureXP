package edu.kea.adventureXP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BOOKING")
public class Booking {

	 @Id
	  @GeneratedValue(generator = "increment")
	  @GenericGenerator(name = "increment", strategy = "increment")
	  private long    id;
	 
	 @ManyToOne  
	 @JoinColumn(name = "SCHEDULEDACTIVITY")  
	 private ScheduledActivity scheduledActivity;	 
	 @ManyToOne
	 @JoinColumn(name="MEMBER")
	 private Member customer;
	 
	 public Booking(){
		 
	 }
	 
	 public Booking(ScheduledActivity scheduledActivity, Member customer){
		 this.scheduledActivity = scheduledActivity;
		 this.customer = customer;
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
}
