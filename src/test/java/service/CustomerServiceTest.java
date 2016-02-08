package service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import entities.Customer;
import entities.Image;

public class CustomerServiceTest {

	@Test
	public void testAddCustomer() {
		   Customer c1=new Customer();  
		c1.setCustomerName("Suraj");
		c1.setAddress("Bangalore");
		c1.setContactNo("9865321470");
		   Calendar c=Calendar.getInstance();
		    Date now=c.getTime();
		c1.setCreateTS(new Timestamp(now.getTime()));
		 //save image into database
		   File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
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
		image.setImageName("Suraj image");
		c1.setImage(image);
		CustomerService service = new CustomerService();
		service.addCustomer(c1);
	}

}
