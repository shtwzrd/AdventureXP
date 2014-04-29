package edu.kea.adventureXP.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventPackageTest {

    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    @Before
    public void setUp() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure(); // configures settings from hibernate.cfg.xml
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
        // A SessionFactory is set up once for an application
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    @After
    public void tearDown() throws Exception {
        if (sessionFactory != null)
            sessionFactory.close();
    }

    @Test
    public void basicEventPackageUsageTest() {
        // create an eventset...
        String packageName = "Stand Teambuilding 1";
        Set<Activity> set = new HashSet<>();
        Activity one = new Activity("Sumo Wresting", "Get big", 299.00, true);
        Activity two = new Activity("Go Cart", "Go fast", 499.00, true);
        Activity three = new Activity("Arrow and Bow", "Shoot apples off  your boss' head", 350.00, true);
        Activity four = new Activity("Paintball", "So pretty", 150.00, true);
        int duration = 6;
        double price = 2455.90;
        set.add(one);
        set.add(two);
        set.add(three);
        set.add(four);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(one);
        session.save(two);
        session.save(three);
        session.save(four);
        session.save(new EventPackage(packageName, set, duration, price));
        session.getTransaction().commit();
        session.close();

        // retrieve it
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<EventPackage> result = session.createQuery("from EventPackage").list();
        for (EventPackage e : result)
            System.out.println(e.toString());
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void populateEventPackageTableTest() {
        
        String packageName1 = "Questionably Legal Teambuilding";
        Set<Activity> set1 = new HashSet<>();
        Activity one = new Activity("Dwarf Tossing", "Toss dwarves whole across the shire", 249.00, true);
        Activity two = new Activity("Granny Rastlin'", "More fun than pushing a hoop down a road", 120.00, true);
        Activity three = new Activity("Archery", "Learn you a bow", 229.00, true);
        Activity four = new Activity("Paintball", "Turn them into rainbows", 320.00, true); 
        set1.add(one);
        set1.add(two);
        int duration1 = 3;
        double price1 = 2338.30;

        String packageName2 = "Apocalypse Preparation Teambuilding";
        Set<Activity> set2 = new HashSet<>();
        set2.add(three);
        set2.add(four);
        int duration2 = 6;
        double price2 = 4000.0;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(one);
        session.save(two);
        session.save(three);
        session.save(four);
        session.save(new EventPackage(packageName1, set1, duration1, price1));
        session.save(new EventPackage(packageName2, set2, duration2, price2));
        session.getTransaction().commit();
        session.close();
    }

}
