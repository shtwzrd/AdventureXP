package edu.kea.adventureXP.model;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ScheduledActivityController {
	
	  /**
	   * Adds scheduled activity entity in the database.
	   * 
	   * @param scheduledActivity The ScheduledActivity to save.
	   */
	  public static void addSceduleActivity(ScheduledActivity scheduledActivity) {
	    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	    Session session = sessionFactory.openSession();
	    try {
	      session.beginTransaction();
	      session.merge(scheduledActivity.getActivity());
	      session.saveOrUpdate(scheduledActivity);
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
	 * Removes an ScheduledActivity from the database
	 * 
	 * @param scheduledActivity The ScheduledActivity to remove.
	 */
	public static void removeScheduledActivity(ScheduledActivity scheduledActivity) {
	  SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	  Session session = sessionFactory.openSession();
	  try {
	    session.beginTransaction();
	    session.delete(scheduledActivity);
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
	 * Gets a ScheduledActivity from the database
	 * 
	 * @param id The id on the ScheduledActivity to get.
	 * @return the ScheduledActivity with that id.
	 */
	public static ScheduledActivity selectFromScheduledActivity(long id) {
	  SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	  Session session = sessionFactory.openSession();
	  try {
	    session.beginTransaction();
	    ScheduledActivity result = (ScheduledActivity)session.get(ScheduledActivity.class, id);
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
	  return new ScheduledActivity();
	}


	
	/**
	 * Updates an ScheduledActivity in the database
	 * 
	 * @param scheduledActivity The ScheduledActivity with altered fields.
	 */
	public static void updateScheduledActivity(ScheduledActivity scheduledActivity) {
	  SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	  Session session = sessionFactory.openSession();
	  try {
	    session.beginTransaction();
	    ScheduledActivity retrieved = selectFromScheduledActivity(scheduledActivity.getId());
	    retrieved.setActivity(scheduledActivity.getActivity());;
	    retrieved.setDate(scheduledActivity.getDate());
	    session.saveOrUpdate(retrieved);
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
	 * Gets all ScheduledActivity entities from the database
	 * @return a list with the ScheculedActivity entities
	 */
	public static List<ScheduledActivity> selectAllFromScheduledActivity() {
	    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	    Session session = sessionFactory.openSession();
	    try {
	      session.beginTransaction();
	      @SuppressWarnings("unchecked")
		List<ScheduledActivity> result = session.createQuery("from ScheduledActivity").list();
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
	 * Gets all ScheduledActivities that fulfills the requirement from the sql query
	 * @param query the sql query
	 * @return a list of ScheduledActivities
	 */
	public static List<ScheduledActivity> selectAllFromScheduledActivity(String query) {
	  SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
	  Session session = sessionFactory.openSession();
	  try {
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<ScheduledActivity> result = session.createQuery(query).list();
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
