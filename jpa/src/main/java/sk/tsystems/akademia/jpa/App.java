package sk.tsystems.akademia.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Address;
import model.Company;
import model.CompanyDao;
import model.Gender;
import model.JpaHelper;
import model.Person;

/**
 * Hello world!
 *
 */
public class App {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatePersistenceUnit");
    
    private EntityManager em = factory.createEntityManager();
	
	public void saveCompany(Company company){
		EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(company);
        transaction.commit();
	}
	
	public void ListAllCompanies(){
		List<Company> companies = em.createQuery("select p from Company p",Company.class).getResultList();
		for(Company c : companies){
			System.out.println(c);
		}
	}
		public void getHappyNumbersOwners(String number){
			List<Person> happyNumbersOwners = em.createQuery("SELECT DISTINCT p FROM Person p JOIN p.happyNumbers number where number = :number",Person.class).setParameter("number",number).getResultList();
		//	SELECT DISTINCT p FROM JOIN FETCH p.luckynumbers number where number = :number
			for(Person person : happyNumbersOwners){
				System.out.println(person);
			}
		}
		

	public static void main(String[] args) {
		
		App app = new App();
		/*
		Person person = new Person();
		person.setAge(24);
		person.setName("Vlado Filarsky");
		person.setGender(Gender.MALE);
		person.setBirthday(new Date());
		
		Person person1 = new Person();
		person1.setAge(25);
		person1.setName("Vlado Filarsky");
		person1.setGender(Gender.MALE);
		person1.setBirthday(new Date());
		
		Person person2 = new Person();
		person2.setAge(26);
		person2.setName("Drahotina Filarska");
		person2.setGender(Gender.MALE);
		person2.setBirthday(new Date());
		
		Person person3 = new Person();
		person3.setAge(27);
		person3.setName("Filip Filarsky");
		person3.setGender(Gender.MALE);
		person3.setBirthday(new Date());
		*/
		
		Company company1 = new Company();
		company1.setAddress(new Address());
		company1.setEmployeesCount(20);
		company1.setFounded(new Date());
		company1.setName("Chiradelta");
		
		Person person4 = new Person();
		person4.setAge(28);
		person4.setName("Jano Filarsky");
		person4.setGender(Gender.MALE);
		person4.setBirthday(new Date());
		person4.setEmployer(company1);
       
		
		/*
		Company company1 = new Company();
		company1.setAddress(new Address());
		company1.setEmployeesCount(20);
		company1.setFounded(new Date());
		company1.setName("Chiradelta");
		
		
		//app.saveCompany(company);
		//app.saveCompany(company1);
		//app.ListAllCompanies();
		
		/*
		CompanyDao companyDao = new CompanyDao();
		companyDao.saveCompany(person);
		companyDao.listAllCompanies();
		JpaHelper.close();
		*/
		
		EntityTransaction transaction = app.em.getTransaction();
		
        //transaction.begin();
       // app.em.persist(person1);
        
        //transaction.commit();
        
		//CompanyDao compDao = new CompanyDao();

		 System.out.println("Ides1?");
        transaction.begin();
        app.em.persist(person4);
        transaction.commit();
        System.out.println("Ides?");
		
		
		app.em.close();
		app.factory.close();
		
		//app.getHappyNumbersOwners("13");

	}
}