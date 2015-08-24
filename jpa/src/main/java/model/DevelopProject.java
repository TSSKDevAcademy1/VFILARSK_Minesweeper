package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
@Entity
@DiscriminatorValue("D")
public class DevelopProject extends Project {
	@ElementCollection(fetch =FetchType.LAZY)
	private List<String> technologies = new ArrayList<String>();

	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}
	
	public void addTechnologies(String string){
		technologies.add(string);
	}
	
}
