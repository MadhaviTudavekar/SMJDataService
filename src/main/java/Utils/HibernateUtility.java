package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class HibernateUtility {
	
	public static SessionFactory sessionFactory = null;
	
	//to not allow create an instance of this class
	
	private HibernateUtility(){
		
	}
	
	public static synchronized  SessionFactory getSessionFactory() {
					
				if(sessionFactory==null){
					sessionFactory = new AnnotationConfiguration().configure("main/resources/hibernate.cfg.xml").
			                buildSessionFactory();
					return sessionFactory;
				}
				
		
		return sessionFactory;
		
		
	}
}
	
	
	


