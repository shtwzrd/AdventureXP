package edu.kea.adventureXP.model;

import java.util.List;





import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.Queryable;
/**
 * 
 * Controller for saving, retrieving updating and deleting Booking objects.
 * 
 * @see Booking
 * @see ManageBookingPresenter
 *
 */
public class BookingController {
	
	/**
	 * Adds a booking to the database
	 * 
	 * @param booking The booking to be saved
	 */
	 public static void saveBooking(Booking booking) {
		    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
		    Session session = sessionFactory.openSession();
		    try {
		      session.beginTransaction();
		      session.update(booking.getScheduledActivity().getActivity());
		      session.update(booking.getScheduledActivity());
		      session.update(booking.getCustomer());
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
	 * Gets all Bookings saved in the database
	 * 	  
	 * @return a list containing all Booking objects
	 */
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
	
	/**
	 * Gets all Bookings that fulfills the requirements in the sql query
	 * 
	 * @param query the sql query
	 * @return a list with the Booking objects
	 */
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


	/**
	 * Gets all the Bookings with a customer in
	 * 
	 * @param customer the customer
	 * @return all Booking objects containing that Member object
	 */
	public static List<Booking> selectAllBookingsFromCustomer(Member customer){
	    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	    Session session = sessionFactory.openSession();
		String hql = "FROM Booking B WHERE B.customer = '" + customer +"'";
		Query query = session.createQuery(hql);
		  try {
			    session.beginTransaction();
			    @SuppressWarnings("unchecked")
				List<Booking> result = query.list();
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


