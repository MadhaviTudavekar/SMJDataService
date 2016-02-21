package service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import Utils.*;
//import Utils.Utility;
import service.CustomerService;

import entities.Customer;
import entities.Image;

public class CustomerServiceTest {
	
	CustomerService service = new CustomerService();

	@Test
	public void testAddCustomer() {
		Customer c1=new Customer();  
		c1.setCustomerName("Suraj");
		c1.setAddress("Bangalore");
		c1.setContactNo("9865321470");
		
		Calendar c=Calendar.getInstance();
		Date now=c.getTime();
		c1.setCreateTS(new Timestamp(now.getTime()));
		
		File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
		byte[] bfile=Utility.getBytesFromFile(file);
		Image image = new Image();
		image.setImage(bfile);
		image.setImageName("Suraj image");
		c1.setImage(image);
		
		//Add 2nd customer
		
		Customer c2=new Customer();  
		c2.setCustomerName("Madhavi");
		c2.setAddress("Bangalore");
		c2.setContactNo("9885471236");
		
		Calendar cal=Calendar.getInstance();
		Date current=cal.getTime();
		c2.setCreateTS(new Timestamp(current.getTime()));
		
		File file2 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
		byte[] bfile2=Utility.getBytesFromFile(file2);
		Image image2 = new Image();
		image2.setImage(bfile2);
		image2.setImageName("Madhavi image");
		c2.setImage(image2);
		
		service.addCustomer(c1);
		service.addCustomer(c2);
	}
	
	@Test
	public void testDeleteCustomerById() {
		boolean isSuccess = service.deleteCustomerById(Customer.class, new Long(1));
		System.out.println("DELETED CUSTOMER WITH ID : "+new Long(1)+" : "+isSuccess);
		
	}
	
	@Test
	public void testGetCustomer() {
		
		Customer customer=service.getCustomer(Customer.class, new Long(1));
		System.out.println("CUSTOMER NAME : "+customer.getCustomerName());
		
	}
	
	
	}


