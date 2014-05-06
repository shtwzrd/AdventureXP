package edu.kea.adventureXP.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	  private long    sceduledActivity_id;
	 
	 
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="id")
	 private Activity activity;
	 @Column
	 private Date date;

	 public ScheduledActivity(){		
		 
	 }
	

	  /**
	   * Controller for creating a ScheduledActivity parsing its activity and date
	   * 
	   * @param activity
	   * @param date
	   */
	  public ScheduledActivity(Activity activity, Date date) {
	    this.activity = activity;
	    this.date = date;
	  }
	  	

	/**
	 * @return the id
	 */
	public long getId() {
		return sceduledActivity_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.sceduledActivity_id = id;
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


	/**
	 * @return the activityId
	 */
	public Activity getActivity() {
		return activity;
	}


	/**
	 * @param activityId the activityId to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}	

 
}
