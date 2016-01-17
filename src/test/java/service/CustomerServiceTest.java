package service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import entities.Customer;
import entities.Image;

public class CustomerServiceTest {

	@Test
	public void testAddCustomer() {
		   Customer c1=new Customer();  
		   c1.setCustomerName("Suraj");
		   c1.setAddress("Bangalore");
		 //save image into database
		   File file = new File("G:\\Madhavi\\PHOTOS\\germany\\IMG-20150404-WA0010.jpg");
		   byte[] bFile = new byte[(int) file.length()];
		   
		   try {
		    FileInputStream fileInputStream = new FileInputStream(file);
		    //convert file into array of bytes
		    fileInputStream.read(bFile);
		    fileInputStream.close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		   
		   Image image = new Image();
		   image.setImage(bFile);
		   c1.setImage(image);
		   CustomerService service = new CustomerService();
		   service.addCustomer(c1);
	}

}
