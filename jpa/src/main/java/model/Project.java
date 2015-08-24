package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance
@DiscriminatorColumn(name="pojectType")
@Table(name="PROJECT")
public abstract class Project {
	@Id
	@GeneratedValue
	private int id;
	private String Name;
	private Date startDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	@ManyToMany(mappedBy="projects")
	private List<Person> persons = new ArrayList<Person>();
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public void addPerson(Person person){
		persons.add(person);
	}
	
	public void removePerson(Person person){
		int i = 0;
		for(Person person1 : persons){
			if(person1.equals(person)){
				persons.remove(i);
			}
			i++;
		}
	}
}
