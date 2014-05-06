package edu.kea.adventureXP.model;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

public final class MemberController {
  
  public static void addMember(Member member) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.saveOrUpdate(member);
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
  
  public static void removeMember(Member member) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.delete(member);
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
  
  public static void updateMember(Member member) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Member retrieved = (Member) session.load(Member.class,
          member.getId());
      retrieved.setFirstName(member.getFirstName());
      retrieved.setLastName(member.getLastName());
      retrieved.setStreet(member.getStreet());
      retrieved.setZipCode(member.getZipCode());
      retrieved.setCity(member.getCity());
      retrieved.setTelephone(member.getTelephone());
      retrieved.setEmail(member.getEmail());
      retrieved.setCountry(member.getCountry());
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
  
  public static List<Member> selectAllFromMember() {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      List<Member> result = session.createQuery("from Member").list();
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
  
  public static List<Member> selectAllFromMember(String query) {
    SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      List<Member> result = session.createQuery(query).list();
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
  
  public static List<Member> getAllInstructors(){
	  List<Member> members = selectAllFromMember();
	  List<Member> instructors = new ArrayList<Member>();
	  for(int i = 0; i < members.size(); i++){
		  if(members.get(i).isInstructor())
			  instructors.add(members.get(i));
	  }
	  return instructors;
  }
  
  public static List<Member> getAllCustomers(){
	  List<Member> members = selectAllFromMember();
	  List<Member> customers = new ArrayList<Member>();
	  for(int i = 0; i < members.size(); i++){
		  if(!members.get(i).isInstructor())
			  customers.add(members.get(i));
	  }
	  return customers;
  }
  
}
