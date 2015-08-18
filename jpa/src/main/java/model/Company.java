package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Company {

	
	private String name;
	private Address address;
	private int employeesCount;
	@Temporal(TemporalType.DATE)
	private Date founded;
	@Id
	@GeneratedValue
	private long id;
	
	@ElementCollection
	private List<String> telephoneNumbers = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {	
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getEmployeesCount() {
		return employeesCount;
	}
	public void setEmployeesCount(int employeesCount) {
		this.employeesCount = employeesCount;
	}
	public Date getFounded() {
		return founded;
	}
	public void setFounded(Date founded) {
		this.founded = founded;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", employeesCount=" + employeesCount + ", founded="
				+ founded + ", id=" + id + ", telephoneNumbers=" + telephoneNumbers + "]";
	}
	
	public void addTelephoneNumber(String telephoneNumber){
		telephoneNumbers.add(telephoneNumber);
	}
	
	public List<String> getTelephoneNumber(){
		return telephoneNumbers;
	}
	
	
}
