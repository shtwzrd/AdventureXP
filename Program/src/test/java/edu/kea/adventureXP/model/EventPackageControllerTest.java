package edu.kea.adventureXP.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import edu.kea.adventureXP.model.Activity;

public class EventPackageControllerTest {
    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    @Before
    public void setUp() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure(); // configures settings from hibernate.cfg.xml
        this.serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
        // A SessionFactory is set up once for an application
        this.sessionFactory = configuration
                        .buildSessionFactory(this.serviceRegistry);
    }

    @After
    public void tearDown() throws Exception {
        if (this.sessionFactory != null) {
            this.sessionFactory.close();
        }
    }

    @Test
    public void eventPackageControllerBasicUsageTest() {
        String name = "Test Package";
        double price = 4000;
        int duration = 7;
        Activity activityForTest = new Activity("Mud Rastlin'", "More fun", 200.0, true);
        ActivityController.addActivity(activityForTest);

        Activity activityForTest2 = new Activity("Dwarf Toss'", "More fun", 200.0, true);
        ActivityController.addActivity(activityForTest2);

        List<Activity> list = ActivityController.selectAllFromActivity();
        Set<Activity> activities = new HashSet(list);
        EventPackage eventPackage = new EventPackage(name,
                        new HashSet<Activity>(list), duration, price);
        EventPackageController.addEventPackage(eventPackage);

        EventPackage out = EventPackageController
                        .selectEventPackageByName("Test Package");

        String originaloutput = eventPackage.toString();
        String retrievedoutput = out.toString();

        System.out.println(originaloutput);
        System.out.println(retrievedoutput);
        assertEquals(originaloutput, retrievedoutput);
    }

}