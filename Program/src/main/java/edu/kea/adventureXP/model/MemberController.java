package edu.kea.adventureXP.model;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * Controller class for saving, retrieving updating and deleting Member objects
 * 
 * @see CustomerViewerPresenter
 * @see InstructorViewerPresenter
 * @see Member
 *
 */
public final class MemberController {
  

	/**
	 * Adds a Member entity in the database
	 * 
	 * @param member the Member to save
	 */
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
	  
	  /**
	   * removes a Member from the database
	   * 
	   * @param member the member to remove
	   */
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
	  
	  /**
	   * Updates a Member in the database
	   * @param member the member entity with altered fields
	   */
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
	  
	  /**
	   * Gets all Members from the database
	   * @return a list with all Members
	   */
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
	  
	  /**
	   * Gets the Members that fulfills the requirements in the sql query
	   * @param query the sql query
	   * @return a list with the member entities
	   */
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
	  
	  /**
	   * Gets all member entities that are Instructors
	   * @return a list of Instructor members
	   */
	  public static List<Member> getAllInstructors(){
		  List<Member> members = selectAllFromMember();
		  List<Member> instructors = new ArrayList<Member>();
		  for(int i = 0; i < members.size(); i++){
			  if(members.get(i).isInstructor())
				  instructors.add(members.get(i));
		  }
		  return instructors;
	  }
	  
	  /**
	   * Gets all members that are customers
	   * @return a list of customer members
	   */
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
