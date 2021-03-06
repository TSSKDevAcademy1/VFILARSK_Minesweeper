package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Person {

	private String name;
	@Transient
	private int age;
	private Gender gender;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Id	
	@GeneratedValue
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Company employer;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Project> projects = new ArrayList<Project>();
	
	@ElementCollection(fetch =FetchType.LAZY)
	private List<String> happyNumbers = new ArrayList<String>();
	
	public Person(){
		Random rNumber = new Random();
		for(int i = 0; i<3;i++){
			happyNumbers.add(new Integer(rNumber.nextInt(14)).toString());
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", birthday=" + birthday + ", id=" + id
				+ ", happyNumbers=" + happyNumbers + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public List<String> getHappyNumbers(){
		return happyNumbers;
	}

	public Company getEmployer() {
		return employer;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}
	
	public void addProject(Project project){
		projects.add(project);
	}
}
