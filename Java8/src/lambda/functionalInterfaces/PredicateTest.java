package lambda.functionalInterfaces;

import java.util.Arrays;
import java.util.List;

public class PredicateTest {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Janko", "Hrasko", 15),
				new Person("Miska", "Bacikova", 29), 
				new Person("Dominik", "Lakatos", 19));
		printPersonsWithPredicate(
			    persons,
			    p -> p.getFirstName() != null
			    	&& p.getLastName() != null
			        && p.getAge() >= 18
			        && p.getAge() <= 25
			);
	}

	public static void printPersonsWithPredicate(List<Person> persons,
			Predicate<Person> tester) {
		for (Person p : persons) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

}
