package edu.kea.adventureXP.model;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookingTest {
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
	  public void basicBookingUsageTest() {	
	
			// put a customer into database
			 Member customer = new Member(
			          "Berta",
			          "Bobsen",
			          "Kartoffel Vej",
			          "2200",
			          "Copenhagen",
			          "Denmark",
			          "2222233",
			          "berta@kartoffel.dk",
			          false);
			 MemberController.addMember(customer);
			 // put a scheduledActivity into the database
			 Activity activity = new Activity("Dwarf Toss", "Fun", 200.0, true);
			 ActivityController.addActivity(activity);	
	
			 // create a date for the activity
			 Calendar cal = new GregorianCalendar();
			 cal.set(2013, 4, 10, 45, 0);
			 Date time = cal.getTime();
			 // the scheduledActivity to save
			 ScheduledActivity scheduledActivity = new ScheduledActivity(activity, time);
		
			 ScheduledActivityController.addSceduleActivity(scheduledActivity);
			 ScheduledActivity activityToBook = ScheduledActivityController.selectAllFromScheduledActivity().get(0);
			 Member bookingMember = MemberController.getAllCustomers().get(0);
				
			 // saving a booking
			 Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 session.save(new Booking(activityToBook, bookingMember));
			 session.getTransaction().commit();
			 session.close();
			    
			// retrieving the saved booking    session = sessionFactory.openSession();
			session = sessionFactory.openSession();
			session.beginTransaction();   List<Booking> result = session.createQuery("from Booking").list();
			for (Booking booked : result)
			   System.out.println(booked.getScheduledActivity().getActivity().getName() + ", " + booked.getCustomer().getFirstName() + " " + booked.getCustomer().getLastName());
			session.getTransaction().commit();
			session.close();
			      
			assertEquals(result.get(0).getCustomer().getFirstName(), customer.getFirstName());  
		}


}

