package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Customer;
import entities.Image;
import entities.Item;

public class TestCustomerAndItemPersist {

	/**
	 * @paramargs
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   //creating configuration object  
		AnnotationConfiguration cfg=new AnnotationConfiguration();  
	cfg.configure("main/resources/hibernate.cfg.xml");//populates the data of the configuration file 	
	
	    //Test customer and image  
	    Customer c1=new Customer();
	c1.setCustomerName("Madhavi");
	c1.setContactNo("9886582058");
	c1.setAddress("Kangrali Belgaum");
	    Calendar c=Calendar.getInstance();
	    Date now=c.getTime();
	c1.setCreateTS(new Timestamp(now.getTime()));
	    File cimage=new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
	    File itemimage=new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
	byte[] b=new byte[(int)cimage.length()];
	
	try {
			FileInputStream fis=new FileInputStream(cimage);
			fis.read(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Image custimage=new Image();
	custimage.setImage(b);
	custimage.setImageName("Madhavi Image");
	now=c.getTime();
	custimage.setCreateTS(new Timestamp(now.getTime()));
	c1.setImage(custimage);
	
	    Item item=new Item();
	now=c.getTime();
	item.setCreateTS(new Timestamp(now.getTime()));
	item.setItemName("Necklace");
	item.setItemDesc("Long Necklace");
	item.setImage(custimage);
	
	
	    //creating seession factory object  
	SessionFactory factory=cfg.buildSessionFactory();  
	
	    //creating session object  
	    Session session=factory.openSession();  
	
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	session.persist(c1);	
	session.persist(item);
	
	
	
	t.commit();//transaction is committed  
	session.close();  
	
	System.out.println("successfully saved");  
	
	}

}
