package lambda.functionalInterfaces;

//Generic interface:
@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}

//Concrete interface:
//@FunctionalInterface
//public interface Predicate<Person> {
//	boolean test(Person t);
//}
