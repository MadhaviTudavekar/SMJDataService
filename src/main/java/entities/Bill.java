package entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BILL")
public @Data class Bill {
	
	@Id @GeneratedValue
	@Column(name="billNo")
	private long billNo;
	
	@Column(name="billID")
	private String billID;
	
	@Column(name="billDate")
	private Timestamp billDate;
	
	@OneToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="customerID")
	private Customer customer; 
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="bill")
	private Set<BillItem>billItems=new HashSet<BillItem>();
	
	@Column(name="createTS")
	private Timestamp createTS;

	

}
