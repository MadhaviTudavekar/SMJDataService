package entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BILLITEM")
public @Data class BillItem {
	
	@Id @GeneratedValue
	@Column(name="billItemID")
	private long billItemID;
	
	@Column(name="netWeight")
	private long netWeight;
	
	@Column(name="grossWeight")
	private long grossWeight;
	
	@Column(name="melting")
	private int melting;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="billID")
	private Bill bill;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="itemID")
	private Item item;
	
	@Column(name="createTS")
	private Timestamp createTS;


	
	
	
}

