package register;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;




public class ListRegister implements Register {

	private List<Person> persons = new ArrayList<Person>();
	
	@Override
	public int getCount() {
		persons.size();
		return 0;
	}

	
	
	@Override
	public int getSize() {
		return persons.size();
	}

	@Override
	public Person getPerson(int index) {
		return persons.get(index);
	}

	@Override
	public void addPerson(Person person) {
		if(!(this.findPersonByName(person.getName()) instanceof Object) && !(this.findPersonByPhoneNumber(person.getPhoneNumber()) instanceof Object)){
			persons.add(person);
		}
		
		
	}

	@Override
	public Person findPersonByName(String name) {
		Iterator<Person> fIterator = persons.iterator();
		while(fIterator.hasNext()){
			Person person = fIterator.next();
			if(person.getName().equals(name)){
				return person;
			}
		}
		return null;
	}

	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
		Iterator<Person> fIterator = persons.iterator();
		while(fIterator.hasNext()){
			Person person = fIterator.next();
			if(person.getPhoneNumber().equals(phoneNumber)){
				return person;
			}
		}
		return null;
	}

	@Override
	public int getActual() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removePerson(Person person) {
		Iterator<Person> fIterator = persons.iterator();
		while(fIterator.hasNext()){
			if(fIterator.next().equals(person)){
				fIterator.remove();
			}
		}
	}
	

	
	public void vypis(){
		Collections.sort(persons);
		StringBuilder stringBuilder = new StringBuilder();
		System.out.println(persons.size());
		Formatter f = new Formatter();
		Iterator<Person> fIterator = persons.iterator();
		while(fIterator.hasNext()){
			stringBuilder.append(fIterator.next().toString()); 
			
		}
		System.out.println(stringBuilder.toString());
		f.close();
	}

}
