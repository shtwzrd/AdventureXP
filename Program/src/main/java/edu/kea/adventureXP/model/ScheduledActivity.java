package edu.kea.adventureXP.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	  private long    id;
	 @ManyToOne(fetch=FetchType.LAZY, targetEntity=Activity.class)
	 @JoinColumn(name="Id", updatable=false, insertable=false)
	  private long activityId;
	  @Column
	  private Date date;

	public ScheduledActivity(){		
	}
	

	  /**
	   * Controller for creating a ScheduledActivity parsing its activityId and date
	   * 
	   * @param id
	   * @param date
	   */
	  public ScheduledActivity(long activityId, Date date) {
	    this.activityId = activityId;
	    this.date = date;
	  }
	  
	  /**
	   * Controller for creating a ScheduledActivity parsing its id, activityId and date
	   * 
	   * @param id
	   * @param activityId
	   * @param date
	   */
	  public ScheduledActivity(long id, long activityId, Date date) {
		    this.activityId = activityId;
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
	public void setId(long id) {
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


	/**
	 * @return the activityId
	 */
	public long getActivityId() {
		return activityId;
	}


	/**
	 * @param activityId the activityId to set
	 */
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}	

 
}
