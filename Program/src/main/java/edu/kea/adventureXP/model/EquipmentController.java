package edu.kea.adventureXP.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EquipmentController {
  
  /**
   * Adds activity entity in the database.
   * 
   * @param activity The Activity to save.
   */
  public static void addEquipment(Equipment equipment) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.save(equipment);
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
  public static void removeEquipment(Equipment equipment) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.delete(equipment);
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
   * Updates an Equipment in the database
   * 
   * @param equipment The Equipment with altered fields.
   */
  public static void updateEquipment(Equipment equipment) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      // Equipment retrieved = (Equipment) session.load(Equipment.class,
      // equipment.getID());
      Equipment retrieved = selectFromEquipment(equipment.getID());
      retrieved.setName(equipment.getName());
      retrieved.setBrand(equipment.getBrand());
      retrieved.setNote(equipment.getNote());
      retrieved.setDate(equipment.getDate());
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
   * Gets an Equipment from the database
   * 
   * @param id The id on the Equipment to get.
   * @return the Equipment with that name.
   */
  public static Equipment selectFromEquipment(long id) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Equipment result = (Equipment) session.get(Equipment.class, id);
      session.getTransaction().commit();
      result.setID(id);
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
    return new Equipment();
  }
  
  /**
   * Gets an Activity from the database
   * 
   * @param name The name on the Activity to get.
   * @return the Activity with that name.
   */
  public static Equipment selectFromEquipment(String name) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Equipment result = (Equipment) session
          .createQuery(
              "select new Equipment(name, brand, date) " + "from Equipment "
                  + "where name = " + "'" + name + "'").list().get(0);
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
    return new Equipment();
  }
  
  /**
   * Gets all Activities saved in the database
   * 
   * @return a list containing all Activity objects.
   */
  public static List<Equipment> selectAllFromEquipment() {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      List<Equipment> result = session.createQuery("from Equipment").list();
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
  
  public static List<Equipment> selectAllFromEquipment(String query) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      List<Equipment> result = session.createQuery(query).list();
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
