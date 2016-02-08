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
@Table(name="CUSTOMER")
public @Data  class Customer {
	@Id @GeneratedValue
	private long customerID;
	
	@Column(name = "customerName", nullable = false, length = 100)
	private String customerName;
	
	@Column(name = "address", nullable = false, length = 2500)
	private String address;
	
	@Column(name="contactNo")
	private String contactNo;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="imageID")
	private Image image;
	
	@Column(name="createTS")
	private Timestamp createTS;

	
	
	

}

