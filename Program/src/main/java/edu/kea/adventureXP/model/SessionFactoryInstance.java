package edu.kea.adventureXP.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryInstance {

  private static boolean exists;
  private static SessionFactory session;

  private SessionFactoryInstance() {

  }

  public static SessionFactory getInstance() {
    if(exists) {
      return SessionFactoryInstance.session;
    } 

    ServiceRegistry serviceRegistry;
    Configuration configuration = new Configuration();
    configuration.configure();  // configures settings from hibernate.cfg.xml
    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
        configuration.getProperties()).build();
    session = configuration.buildSessionFactory(serviceRegistry);  
    exists = true;

    return SessionFactoryInstance.session;

  }

}
