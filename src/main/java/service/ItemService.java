package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Customer;
import entities.Item;

public class ItemService {
	
	public void addItem(Item item) {  
	      
	    //creating configuration object  
		AnnotationConfiguration cfg=new AnnotationConfiguration();  
	    cfg.configure("main/resources/hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	      
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	          
	    session.persist(item);//persisting the object  
	      
	    t.commit();//transaction is committed  
	    session.close();  
	      
	    System.out.println("Item successfully saved");  
	      
	}  

}
