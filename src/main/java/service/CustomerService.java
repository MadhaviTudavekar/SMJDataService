package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;  

import Utils.HibernateUtility;



import entities.Customer;

public class CustomerService { 

	SessionFactory sessionFactory=HibernateUtility.getSessionFactory();
	

	public void addCustomer(Customer customer) {  
		Session session=sessionFactory.openSession();
		//creating transaction object  
		Transaction transaction=session.beginTransaction();  
		try{
			
			session.persist(customer);//persisting the object  

			transaction.commit();//transaction is committed  			 

			System.out.println("Customer successfully saved");

		}catch(Exception e){
			if(transaction!=null){
				transaction.rollback();
			}
		}
		finally{
			session.close(); 
			
		}

	}  


	public boolean deleteCustomerById(Class<?> type,Serializable id){
		Session session=sessionFactory.openSession();
		//creating transaction object  
		Transaction transaction=session.beginTransaction();  
		try{
			
			Object dbObject=session.load(type, id);
			if(dbObject!=null){
				session.delete(dbObject);
				transaction.commit();//transaction is committed  	
				return true;
			}

		}catch(Exception e){
			if(transaction!=null){
				transaction.rollback();
			}
		}
		finally{
			session.close(); 
			
		}
		return false;


	}

	public Customer getCustomer(Class<?> type,Serializable id){
		Session session=sessionFactory.openSession();
		return (Customer) session.get(type,id);

	}

} 