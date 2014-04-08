package edu.kea.adventureXP.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.kea.adventureXP.model.Activity;

public class ActivityTest {
  private SessionFactory sessionFactory;
  private ServiceRegistry serviceRegistry;

  @Before
  public void setUp() throws Exception {
    Configuration configuration = new Configuration();
    configuration.configure();  // configures settings from hibernate.cfg.xml
    this.serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
        configuration.getProperties()).build();
    // A SessionFactory is set up once for an application
    this.sessionFactory = configuration.buildSessionFactory(this.serviceRegistry); 
  }

  @After
  public void tearDown() throws Exception {
    if ( this.sessionFactory != null ) {
      this.sessionFactory.close();
    }
  }

  @Test
  public void basicActivityUsageTest() {
    // create an activity...
    Session session = this.sessionFactory.openSession();
    session.beginTransaction();
    session.save( new Activity( "Dwarf Tossing",
          "Throw Dwarves whole across the shire!",
          400.0) );
    session.getTransaction().commit();
    session.close();

    // retrieve it 
    session = this.sessionFactory.openSession();
    session.beginTransaction();
    List<Activity> result = session.createQuery( "from Activity" ).list();
    for ( Activity event : result ) {
      System.out.println( event.getName() + ": " + event.getDescription() + ": " + event.getPrice() );
    }
    session.getTransaction().commit();
    session.close();
  }

  @Test
  public void populateActivityTableTest() {
    Session session = this.sessionFactory.openSession();
    session.beginTransaction();
    session.save( new Activity( "Dwarf Tossing",
          "Throw Dwarves whole across the shire!",
          400.0) );
    session.save( new Activity( "Paintball",
          "It's fun!",
          200.0) ); 
    session.save( new Activity( "Laser Tag",
          "also fun...",
          400.0) ); 
    session.save( new Activity( "Sumo Tossing",
          "Throw Sumo Wrestlers out along with your back.",
          800.0) ); 
    session.save( new Activity( "Skeet Shooting",
          "Pew pew!",
          400.0) ); 
    session.getTransaction().commit();
    session.close();
  }

}
