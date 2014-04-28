package edu.kea.adventureXP.model;

import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import edu.kea.adventureXP.model.Activity;

public class ActivityTest extends TestCase {
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	@Override
	protected void setUp() throws Exception {
		Configuration configuration = new Configuration();
		configuration.configure();  // configures settings from hibernate.cfg.xml
		this.serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		// A SessionFactory is set up once for an application
		this.sessionFactory = configuration.buildSessionFactory(this.serviceRegistry); 
	}

	@Override
	protected void tearDown() throws Exception {
		if ( this.sessionFactory != null ) {
			this.sessionFactory.close();
		}
	}

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
}