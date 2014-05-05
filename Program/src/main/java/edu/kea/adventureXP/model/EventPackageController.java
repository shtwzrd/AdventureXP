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
public final class EventPackageController {

    /**
     * Adds activity entity in the database.
     * 
     * @param activity
     *            The Activity to save.
     */
    public static void addEventPackage(EventPackage event) {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            for (Activity a : event.getActivities()) {
                session.update(a);
            }

            session.save(event);
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
     * Gets all Activities saved in the database
     * 
     * @return a list containing all Activity objects.
     */
    public static List<EventPackage> selectAllFromEventPackage() {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            @SuppressWarnings("unchecked")
            List<EventPackage> result = session.createQuery("from EventPackage").list();
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

    public static EventPackage selectEventPackageByName(String name) {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            @SuppressWarnings("unchecked")
            EventPackage result = (EventPackage) session
            .createQuery("from EventPackage where name = '" + name + "'").list().get(0);
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

    public static EventPackage selectEventPackageById(long id) {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            @SuppressWarnings("unchecked")
            EventPackage result = (EventPackage) session.get(EventPackage.class, id);
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

    public static void removeEventPackage(long id) {
        SessionFactory sessionFactory = SessionFactoryInstance.getInstance();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            @SuppressWarnings("unchecked")
            EventPackage result = (EventPackage) session.get(EventPackage.class, id);
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
