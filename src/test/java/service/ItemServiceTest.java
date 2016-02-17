package service;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import entities.Image;
import entities.Item;

public class ItemServiceTest {

	@Test
	public void testAddItem(){
		
		   Item item=new Item();
		   item.setItemName("Necklace");
		   item.setItemDesc("Laxmi Necklace");
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
		   item.setImage(image);
		   
		  ItemService itemService=new ItemService();
		  itemService.addItem(item);
	}
}
