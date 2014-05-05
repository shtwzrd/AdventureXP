package edu.kea.adventureXP.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EquipmentTest {
  
  private SessionFactory  sessionFactory;
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
  public void basicEquipmentUsageTest() {
    // create an equipment...
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    //session.save(new Equipment("Paintball Gun", "PB Factory", new Date(2014, 03, 03),
 //       "eowijfoe"));

    session.getTransaction().commit();
    session.close();
    
    // retrieve it
    session = sessionFactory.openSession();
    session.beginTransaction();
    List<Equipment> result = session.createQuery("from Equipment").list();
    for (Equipment event : result)
      System.out.println(event.getName() + ": " + event.getBrand() + ": "
          + event.getDate() + ": " + event.getNote());
    session.getTransaction().commit();
    session.close();
  }
  
  @Test
  public void populateEquipmentTableTest() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
<<<<<<< HEAD
//    session.save(new Equipment("Paintball Gun", "PB Factory", new Date(2014, 03, 03),
//        "eowijfoe"));
//    session
//        .save(new Equipment("Cross Bow", "PB Factory", new Date(2014, 04, 03), "wefew"));
//    session.save(new Equipment("Test 1", "PB Factory", new Date(2014, 05, 03), "erg"));
//    session.save(new Equipment("Test 2", "AB Factory", new Date(2014, 06, 03), "j5yt"));
//    session.save(new Equipment("Test 3", "CT Factory", new Date(2014, 07, 03),
 //       "iultjyrht"));
=======
  //  session.save(new Equipment("Paintball Gun", "PB Factory", new Date(2014, 03, 03),
  //      "eowijfoe"));
  //  session
  //      .save(new Equipment("Cross Bow", "PB Factory", new Date(2014, 04, 03), "wefew"));
  //  session.save(new Equipment("Test 1", "PB Factory", new Date(2014, 05, 03), "erg"));
  //  session.save(new Equipment("Test 2", "AB Factory", new Date(2014, 06, 03), "j5yt"));
  //  session.save(new Equipment("Test 3", "CT Factory", new Date(2014, 07, 03),
  //      "iultjyrht"));
>>>>>>> 1b8dfb392a20b83312b0024338e02c920a232649
    session.getTransaction().commit();
    session.close();
  }
}
