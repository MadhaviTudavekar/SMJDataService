package entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ITEM")
public  @Data class Item {
	@Id @GeneratedValue
	@Column(name="itemID")
	private long itemID;
	
	@Column(name="itemName")
	private String itemName;
	
	@Column(name="itemDesc")
	private String itemDesc;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="imageID")
	private Image image; 
	
	@Column(name="createTS")
	private Timestamp createTS;


	
	
	

}

