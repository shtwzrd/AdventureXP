package edu.kea.adventureXP.model;


import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import edu.kea.adventureXP.model.Activity;

public class ActivityControllerTest {
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
  public void activityControllerBasicUsageTest() {
    Activity activity = new Activity("Dwarf Toss", "Fun", 200.0, true);
    ActivityController.addActivity(activity);
    
    List<Activity> list = ActivityController.selectAllFromActivity();
    for (Activity a : list)
      System.out.println(a.getName());
    
    Activity returned = ActivityController.selectFromActivity(activity.getName());
    
    assertEquals(activity.getName(), returned.getName());
    
  }
  
  @Test
  public void removeActivityControllerTest() {
    
  }
  
}
