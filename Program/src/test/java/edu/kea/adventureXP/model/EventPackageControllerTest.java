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
    private Activity activityForTest;
    private Activity activityForTest2;


    @Before
    public void setUp() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure(); // configures settings from hibernate.cfg.xml
        this.serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
        // A SessionFactory is set up once for an application
        this.sessionFactory = configuration
                        .buildSessionFactory(this.serviceRegistry);

        activityForTest = new Activity("Mud Rastlin'", "More fun",
                        200.0, true);
        ActivityController.addActivity(activityForTest);

        activityForTest2 = new Activity("Dwarf Toss'", "More fun",
                        200.0, true);
        ActivityController.addActivity(activityForTest2);
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
        Set<Activity> activities = new HashSet<>();
        activities.add(activityForTest);
        activities.add(activityForTest2);
        EventPackage eventPackage = new EventPackage(name, activities,
                        duration, price);
        EventPackageController.addEventPackage(eventPackage);

        EventPackage out = EventPackageController.selectEventPackageByName("Test Package");
                        
        String originaloutput = eventPackage.toString();
        String retrievedoutput = out.toString();

        assertEquals(originaloutput, retrievedoutput);

    }

}