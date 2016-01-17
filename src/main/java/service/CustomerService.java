package service;
  
import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;  

import entities.Customer;
  
public class CustomerService {  
public void addCustomer(Customer customer) {  
      
    //creating configuration object  
	AnnotationConfiguration cfg=new AnnotationConfiguration();  
    cfg.configure("main/resources/hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating seession factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object  
    Transaction t=session.beginTransaction();  
          
    session.persist(customer);//persisting the object  
      
    t.commit();//transaction is committed  
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
} 