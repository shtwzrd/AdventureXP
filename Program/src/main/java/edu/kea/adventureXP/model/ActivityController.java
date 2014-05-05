package edu.kea.adventureXP.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.kea.adventureXP.presenter.ManageActivityPresenter;


/**
 * Controller class for saving, retrieving, updating and deleting Activity
 * objects.
 * 
 * @see ManageActivityPresenter
 * @see Activity
 * */
public final class ActivityController {
  
  /**
   * Adds activity entity in the database.
   * 
   * @param activity The Activity to save.
   */
  public static void addActivity(Activity activity) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.save(activity);
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
   * Adds scheduled activity entity in the database.
   * 
   * @param scheduledActivity The ScheduledActivity to save.
   */
  public static void addSceduleActivity(ScheduledActivity scheduledActivity) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.save(scheduledActivity);
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
   * Removes an Activity from the database
   * 
   * @param activity The activity to remove.
   */
  public static void removeActivity(Activity activity) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.delete(activity);
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
   * Updates an Activity in the database
   * 
   * @param activity The Activity with altered fields.
   */
  public static void updateActivity(Activity activity) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      // Activity retrieved = (Activity) session.load(Activity.class,
      // activity.getId());
      Activity retrieved = selectFromActivity(activity.getId());
      retrieved.setName(activity.getName());
      retrieved.setDescription(activity.getDescription());
      retrieved.setPrice(activity.getPrice());
      retrieved.setIsActive(activity.getIsActive());
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
  
  /**
   * Gets an Activity from the database
   * 
   * @param id The id on the Activity to get.
   * @return the Activity with that name.
   */
  public static Activity selectFromActivity(long id) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Activity result = (Activity) session.get(Activity.class, id);
      System.out.println(result.getName());
      session.getTransaction().commit();
  //    result.setId(id);
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
    return new Activity();
  }
  
  /**
   * Gets an Activity from the database
   * 
   * @param name The name on the Activity to get.
   * @return the Activity with that name.
   */
  public static Activity selectFromActivity(String name) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Activity result = (Activity) session
          .createQuery(
              "select new Activity(name, description, price, isActive) "
                  + "from Activity " + "where name = " + "'" + name + "'").list().get(0);
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
    return new Activity();
  }
  
  /**
   * Gets all Activities saved in the database
   * 
   * @return a list containing all Activity objects.
   */
  public static List<Activity> selectAllFromActivity() {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      @SuppressWarnings("unchecked")
	List<Activity> result = session.createQuery("from Activity").list();
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
  
  public static List<Activity> selectAllFromActivity(String query) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      @SuppressWarnings("unchecked")
	List<Activity> result = session.createQuery(query).list();
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


public static ScheduledActivity selectFromScheduledActivity(long id) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      ScheduledActivity result = (ScheduledActivity) session.createQuery(
          "select new ScheduledActivity(id, date) " +
          "from ScheduledActivity " +
          "where id = " + "'" + id + "'").list().get(0);
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
    return new ScheduledActivity();
}

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

}
