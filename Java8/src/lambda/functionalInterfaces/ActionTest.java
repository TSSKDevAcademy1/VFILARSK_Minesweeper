package lambda.functionalInterfaces;

import java.util.Arrays;


public class ActionTest {

	public static void main(String[] args) {
		//once we have a method that takes a functional interface as a param, we can use it in lambda
		execute((String s) -> System.out.println(s));
		//also can be written like this, but does not enable any transformations with the argument
		execute(System.out::println);
		//type of s can be automatically inferenced
		execute(s -> System.out.println("*" + s + "*"));
		
		/*****using two parameters in the execute method*****/
		Arrays.asList("a","b","c").forEach(s -> execute(
				s, System.out::println));
		
		//specifying parameters explicitly
		Arrays.asList("a","b","c").forEach(s -> execute(
						s,
						a -> System.out.println(a)));
	}

	private static void execute(Action action) {
		action.run("Hello!");
	}

	/**
	 * Multiple parameters
	 * @param s - string to perform the action on
	 * @param action - the action to perform
	 */
	private static void execute(String s, Action action) {
		//you can pass multiple actions as parameters and perform them one by one
		action.run("Hello " + s + "!");
	}
}
