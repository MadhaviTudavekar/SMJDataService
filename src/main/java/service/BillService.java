package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Bill;
import entities.Customer;

public class BillService {
	public void addBill(Bill bill) {  
	
	    //creating configuration object  
		AnnotationConfiguration cfg=new AnnotationConfiguration();  
	cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file 
	

	
	    //creating seession factory object  
	SessionFactory factory=cfg.buildSessionFactory();  
	
	    //creating session object  
	    Session session=factory.openSession();  
	
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	
	session.persist(bill);//persisting the object  
	
	t.commit();//transaction is committed  
	session.close();  
	
	System.out.println("successfully saved");  
	
	}  
}
