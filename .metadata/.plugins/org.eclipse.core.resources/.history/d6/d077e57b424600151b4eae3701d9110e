package model;

import java.util.List;

public class CompanyDao {

	public void saveCompany(Company company){
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(company);
		JpaHelper.commitTransaction();
	}
	
	public void listAllCompanies(){
		JpaHelper.beginTransaction();
		List<Company> companies = JpaHelper.getEntityManager().createQuery("select c from Company c", Company.class).getResultList();
		for(Company company :  companies){
			System.out.println(company);
		}
	}
	
}
