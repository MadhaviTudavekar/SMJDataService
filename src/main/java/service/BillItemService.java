package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.BillItem;
import entities.Customer;

public class BillItemService {
	public void addBillItem(BillItem billitem) {  
	
	    //creating configuration object  
		AnnotationConfiguration cfg=new AnnotationConfiguration();  
	cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file 
	

	
	    //creating seession factory object  
	SessionFactory factory=cfg.buildSessionFactory();  
	
	    //creating session object  
	    Session session=factory.openSession();  
	
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	
	session.persist(billitem);//persisting the object  
	
	t.commit();//transaction is committed  
	session.close();  
	
	System.out.println("successfully saved");  
	
	}  
}

