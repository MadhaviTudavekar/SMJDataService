package entities;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name="IMAGE")
public @Data  class Image {
	@Id @GeneratedValue
	@Column(name="imageID")
	private long imageID;
	
	@Column(name="imageName")
	private String imageName;
	
	@Lob
	@Column(name="image" ,unique = false, nullable = false, length = 100000)
	private byte[] image;	
	
	@Column(name="createTS")
	private Timestamp createTS;


	
	
	
	
	
}

