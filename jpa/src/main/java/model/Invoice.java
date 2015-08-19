package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Invoice {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	private String addressee;
	private Date makeDate;
	private Date expireDate;
	private String accountNumber;
	
	
	@OneToMany
	private List<Item> items = new ArrayList<Item>();

	private long priceItems = 0;
	
	public Invoice(Company company, String addressee,Date makeDate,Date expireDate, String accountNumber){
		this.company = company;
		this. addressee = addressee;
		this.makeDate = makeDate;
		this.expireDate = expireDate;
		this.accountNumber = accountNumber;
	}
	
	
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
		updatePriceItems();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getPriceItems() {
		return priceItems;
	}

	public void setPriceItems(long priceItems) {
		this.priceItems = priceItems;
	}
	
	private void updatePriceItems(){
		for(Item item : items){
			priceItems += item.getPrice();
		}
	}
	
	public void addItem(Item item){
		items.add(item);
		updatePriceItems();
	}
}
