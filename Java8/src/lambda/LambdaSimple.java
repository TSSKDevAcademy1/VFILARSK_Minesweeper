package lambda;

import java.awt.Desktop.Action;
import java.util.Arrays;

public class LambdaSimple {
	public static void main(String[] args) {
		// type of e is automatically inferred
		Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

		// we can explicitly provide the type of the parameter
		Arrays.asList("a", "b", "c").forEach(
				(String e) -> System.out.println(e));
		
		// we can write as System.out::print - hinders the possibility to change the argument
		Arrays.asList("a", "b", "c").forEach(System.out::print);
		
		// If the lambda's body is more complex, {} brackets can be used as
		// usual
		Arrays.asList("a", "b", "c").forEach(e -> {
			System.out.print(e);
			System.out.print(e);
		});

		// Lambdas may reference class members and local variables
		// (implicitly making them effectively FINAL if they are not)
		/*final */String separator = ",";
		Arrays.asList("a", "b", "c").forEach(
				(String e) -> System.out.print(e + separator));
		
		//Lambdas may return a value - the type will be inferred by compiler
		//return is not required if the lambda body is just a one line
		Arrays.asList("a","b","c").sort((e1,e2) -> e1.compareTo(e2));
		//is equal to:
		Arrays.asList("a","b","c").sort((e1,e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});
	}
}
