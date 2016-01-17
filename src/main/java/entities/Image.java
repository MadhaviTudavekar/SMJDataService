package entities;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="IMAGE")
public @Data class Image {
	@Id @GeneratedValue
	@Column(name="imageID")
	private int imageID;
	
	@Column(name="image" ,unique = false, nullable = false, length = 100000)
	private byte[] image;	
	
	public Image() {
		super();
	}
	/**
	 * 
	 * @return the imageId
	 */
	public int getImageId() {
		return imageID;
	}
	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(int imageId) {
		this.imageID = imageId;
	}
	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
	

}
