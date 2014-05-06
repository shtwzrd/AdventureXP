package edu.kea.adventureXP.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Controller class for saving, retrieving, updating and deleting EventPackage
 * objects.
 * 
 * @see ManageEventPackagePresenter
 * @see EventPackage
 * */
public final class EventPackageController {

    /**
     * Adds an Event Package entity to the database.
     * 
     * @param event
     *            The EventPackage to save.
     */
    public static void addEventPackage(EventPackage event) {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            for (Activity a : event.getActivities()) {
                session.merge(a);
            }

            session.saveOrUpdate(event);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Gets all EventPackages saved in the database
     * 
     * @return a list containing all EventPackage objects.
     */
    public static List<EventPackage> selectAllFromEventPackage() {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<EventPackage> result = session
                            .createQuery("from EventPackage").list();
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
     * Controller method which attempts to retrieve an EventPackage from the Database by name.
     * Currently, if you request an EventPackage which doesn't exist, the method will cause an
     * ArrayOutOfBounds exception.
     * 
     * If there are more than one EventPackage in the database with the same name, this method will
     * only retrieve the first one.
     * 
     * @param name the name of the EventPackage to retrieve
     * @return the EventPackage object retrieved from the database.
     */
    public static EventPackage selectEventPackageByName(String name) {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            EventPackage result = (EventPackage) session
                            .createQuery("from EventPackage where name = '"
                                            + name + "'").list().get(0);
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
     * Controller method for retrieving an EventPackage by its id
     * 
     * @param id The id of the desired EventPackage
     * @return The EventPackage object with the requested id 
     */
    public static EventPackage selectEventPackageById(long id) {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            @SuppressWarnings("boxing")
            EventPackage result = (EventPackage) session.get(
                            EventPackage.class, id);
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
     * Controller method for removing an EventPackage by its id
     * 
     * @param id The id of the EventPackage to remove
     */
    public static void removeEventPackage(long id) {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            @SuppressWarnings("unchecked")
            EventPackage result = (EventPackage) session.get(
                            EventPackage.class, id);
            session.delete(result);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }
}
