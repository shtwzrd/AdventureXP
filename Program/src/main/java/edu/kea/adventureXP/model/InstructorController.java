package edu.kea.adventureXP.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public final class InstructorController {
  
  public static void addInstructor(Instructor instructor) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.save(instructor);
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
  
  public static void removeInstructor(Instructor instructor) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.delete(instructor);
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
  
  public static void updateInstructor(Instructor instructor) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Instructor retrieved = (Instructor) session.load(Instructor.class,
          instructor.getId());
      retrieved.setFirstName(instructor.getFirstName());
      retrieved.setLastName(instructor.getLastName());
      retrieved.setStreet(instructor.getStreet());
      retrieved.setZipCode(instructor.getZipCode());
      retrieved.setCity(instructor.getCity());
      retrieved.setTelephone(instructor.getTelephone());
      retrieved.setEmail(instructor.getEmail());
      retrieved.setCountry(instructor.getCountry());
      session.save(retrieved);
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
  
  public static List<Instructor> selectAllFromInstructor() {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      List<Instructor> result = session.createQuery("from Instructor").list();
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
  
  public static List<Instructor> selectAllFromInstructor(String query) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      List<Instructor> result = session.createQuery(query).list();
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
