package edu.kea.adventureXP.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookingController {
	
	 public static void saveBooking(Booking booking) {
		    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
		    Session session = sessionFactory.openSession();
		    try {
		      session.beginTransaction();
		      session.save(booking);
		      session.getTransaction().commit();
		    }
		    catch (HibernateException e) {
		      e.printStackTrace();
		    }
		    finally {
		      try {
		        session.close();
		      }
		      catch (HibernateException e) {
		        e.printStackTrace();
		      }
		    }
		  }
	 
	
	/**
	 * Removes an Booking from the database
	 * 
	 * @param booking The Booking to remove.
	 */
	public static void removeBooking(Booking booking) {
	  SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	  Session session = sessionFactory.openSession();
	  try {
	    session.beginTransaction();
	    session.delete(booking);
	    session.getTransaction().commit();
	  }
	  catch (HibernateException e) {
	    e.printStackTrace();
	  }
	  finally {
	    try {
	      session.close();
	    }
	    catch (HibernateException e) {
	      e.printStackTrace();
	    }
	  }
	}
	
	/**
	 * Gets a Booking from the database
	 * 
	 * @param id The id on the Booking to get.
	 * @return the Booking with that id.
	 */
	public static Booking selectFromBooking(long id) {
	  SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	  Session session = sessionFactory.openSession();
	  try {
	    session.beginTransaction();
	    Booking result = (Booking)session.get(Booking.class, id);
	    session.getTransaction().commit();
	    return result;
	  }
	  catch (HibernateException e) {
	    e.printStackTrace();
	  }
	  finally {
	    try {
	      session.close();
	    }
	    catch (HibernateException e) {
	      e.printStackTrace();
	    }
	  }
	  return new Booking();
	}
	
	
	/**
	 * Updates an Booking in the database
	 * 
	 * @param Booking The Booking with altered fields.
	 */
	public static void updateBooking(Booking booking) {
	  SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	  Session session = sessionFactory.openSession();
	  try {
	    session.beginTransaction();
	    Booking retrieved = selectFromBooking(booking.getId());
	    retrieved.setScheduledActivity(booking.getScheduledActivity());
	    retrieved.setCustomer(booking.getCustomer());;
	    session.update(retrieved);
	    session.getTransaction().commit();
	  }
	  catch (HibernateException e) {
	    e.printStackTrace();
	  }
	  finally {
	    try {
	      session.close();
	    }
	    catch (HibernateException e) {
	      e.printStackTrace();
	    }
	  }
	}
	

		  
	public static List<Booking> selectAllFromBooking() {
	    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	    Session session = sessionFactory.openSession();
	    try {
	      session.beginTransaction();
	      @SuppressWarnings("unchecked")
		List<Booking> result = session.createQuery("from Booking").list();
	      session.getTransaction().commit();
	      return result;
	    } catch (HibernateException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        session.close();
	      } catch (HibernateException e) {
	        e.printStackTrace();
	      }
	    }
	    return null;
	}
	
	public static List<Booking> selectAllFromBooking(String query) {
	  SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	  Session session = sessionFactory.openSession();
	  try {
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Booking> result = session.createQuery(query).list();
	    session.getTransaction().commit();
	    return result;
	  }
	  catch (HibernateException e) {
	    e.printStackTrace();
	  }
	  finally {
	    try {
	      session.close();
	    }
	    catch (HibernateException e) {
	      e.printStackTrace();
	    }
	  }
	  return null;
	}



}


