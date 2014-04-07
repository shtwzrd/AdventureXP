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
import java.util.ArrayList;

import edu.kea.adventureXP.model.Instructor;

public class InstructorTest {
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
		// create an instructor...
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
    List<String> phones = new ArrayList<>();
    phones.add("+45 55 55 55 55"); 
		session.save( new Instructor(
          "Bob",
          "Bobsen",
          "42",
          "Kartoffel Vej",
          "2200",
          "Copenhagen",
          "Denmark",
          phones,
          "bob@kartoffel.dk")
          );
		session.getTransaction().commit();
		session.close();

		// retrieve it 
		session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<Instructor> result = session.createQuery( "from Instructor" ).list();
		for ( Instructor instructor : result ) {
			System.out.println( instructor.getFirstName() + " " + instructor.getLastName() +
          ", " + instructor.getEmail() );
		}
		session.getTransaction().commit();
		session.close();
	}
}
