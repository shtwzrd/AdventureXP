package edu.kea.adventureXP.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScheduledActivityControllerTest {
	  private SessionFactory sessionFactory;
	  private ServiceRegistry serviceRegistry;
	  

	  @Before
	  public void setUp() throws Exception {
	    Configuration configuration = new Configuration();
	    configuration.configure();  // configures settings from hibernate.cfg.xml
	    this.serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	        configuration.getProperties()).build();
	    // A SessionFactory is set up once for an application
	    this.sessionFactory = configuration.buildSessionFactory(this.serviceRegistry); 
	  }

	  @After
	  public void tearDown() throws Exception {
	    if ( this.sessionFactory != null ) {
	      this.sessionFactory.close();
	    }
	  }
	
	@Test
	public void ScheduledActivityControllerBasicUsageTest() {
		// add an activity to schedule
		Activity activity = new Activity("Dwarf Toss", "Fun", 200.0, true);
		ActivityController.addActivity(activity);
		activity = ActivityController.selectFromActivity("Dwarf Toss");
		// create a date for the activity
		Calendar cal = new GregorianCalendar();
		cal.set(2013, 3, 10, 14, 20);
		Date time = cal.getTime();
		// the scheduledActivity to test
		ScheduledActivity scheduledActivity = new ScheduledActivity(activity, time);
		// test adding
		ScheduledActivityController.addSceduleActivity(scheduledActivity);
		
		ScheduledActivity testret = null;
		// test select all
		List<ScheduledActivity> list = ScheduledActivityController.selectAllFromScheduledActivity();
		for (ScheduledActivity a : list){
			testret = a;
		}
		ScheduledActivity scheduledactivity = ScheduledActivityController.selectFromScheduledActivity(testret.getId() );
	  
		assertEquals(scheduledactivity.getId(), testret.getId());
	  
	}
	
	@Test
	public void removeActivityControllerTest() {	
		// add an activity to schedule
		Activity activity = new Activity("Dwarf Toss", "Fun", 200.0, true);
		ActivityController.addActivity(activity);
		
		// create a date for the activity
		Calendar cal = new GregorianCalendar();
		cal.set(2013, 4, 10, 45, 0);
		Date time = cal.getTime();
		// the scheduledActivity to test
		ScheduledActivity scheduledActivity = new ScheduledActivity(activity, time);
		// test adding
		ScheduledActivityController.addSceduleActivity(scheduledActivity);
		ScheduledActivity scheduled = ScheduledActivityController.selectAllFromScheduledActivity().get(0);
		ScheduledActivityController.removeScheduledActivity(scheduled);
		ScheduledActivity deleted = ScheduledActivityController.selectFromScheduledActivity(scheduled.getId());
		assertEquals(null, deleted);
	}

}
