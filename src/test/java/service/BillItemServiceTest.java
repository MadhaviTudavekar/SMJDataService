package service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import entities.Bill;
import entities.BillItem;
import entities.Customer;
import entities.Item;

public class BillItemServiceTest {

	@Test
	public void testAddBillItem() {
		AnnotationConfiguration cfg=new AnnotationConfiguration();  
	cfg.configure("main/resources/hibernate.cfg.xml");//populates the data of the configuration file 	
	
	SessionFactory sessionFactory=cfg.buildSessionFactory();
	    Session session=sessionFactory.openSession();
		Bill bill=new Bill();
		Calendar c=Calendar.getInstance();
		Date now=c.getTime();
		bill.setBillDate(new Timestamp(now.getTime()));
		bill.setBillID("2016FEB04-01-12-00");
		String hql="from Customer customer where customerID=:customerID";
		String ihql="from Item item where itemID=:itemID";
		Query query=session.createQuery(hql);
		query.setInteger("customerID", 2);
		query.setMaxResults(1);
		Customer c1=(Customer)query.uniqueResult();
		bill.setCustomer(c1);
		
		Query query2=session.createQuery(ihql);
		query2.setInteger("itemID", 1);
		query2.setMaxResults(1);
		Item item=(Item)query2.uniqueResult();
		
		BillItem bi1=new BillItem();
		bi1.setBill(bill);
		bi1.setMelting(90);
		bi1.setItem(item);
		bi1.setBill(bill);
		bi1.setQuantity(2);
		
		BillItem bi2=new BillItem();
		bi2.setBill(bill);
		bi2.setMelting(90);
		bi2.setItem(item);
		bi2.setBill(bill);
		bi2.setQuantity(2);
		
		
		
		Transaction t=session.beginTransaction();
		session.persist(bill);
		session.persist(bi1);
		session.persist(bi2);
		
		t.commit();
		session.close();
		
		
	}

}
