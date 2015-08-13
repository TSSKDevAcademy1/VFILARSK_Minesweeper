package lambda;

import java.awt.EventQueue;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Lambda can appear only in:
 * - Variable declaration
 * - Assignment
 * - Return statement
 * - Array initializer
 * - Method or constructor arguments
 * - Lambda body
 * - Ternary conditional expression
 * - Cast expression
 */
public class LambdaContextDemonstration {
	public static void main(String[] args) throws Exception {
		// Target type: variable declaration
		Runnable r = () -> {
			for (int i = 0; i < 5; i++)
				System.out.println(i);
		};
		r.run();

		// Target type: assignment
		r = () -> System.out.println("running");
		r.run();

		// Target type: return statement (in getRunnable())
		EventQueue.invokeLater(getRunnable("I'm running"));

		// Target type: array initializer
		Callable<String>[] callables = new Callable[] { () -> "First callable",
				() -> "Second callable", () -> "Third callable" };
		System.out.println(callables[1].call());

		// Target type: method or constructor arguments
		EventQueue.invokeLater(() -> System.out.println("invoked later"));

		// Target type: lambda body (a nested lambda)
		Callable<Runnable> callable = () -> () -> System.out
				.println("callable says hello");
		callable.call().run();

		// Target type: ternary conditional expression
		boolean ascendingSort = false;
		Comparator<String> cmp;
		cmp = (ascendingSort) ? (s1, s2) -> s1.compareTo(s2) : (s1, s2) -> s2
				.compareTo(s1);
		List<String> planets = Arrays.asList("Mercury", "Venus", "Earth",
				"Mars", "Jupiter", "Saturn", "Uranus", "Neptune");
		Collections.sort(planets, cmp);
		for (String planet : planets)
			System.out.println(planet);
		
		for(String p : planets) { System.out.println(p); }

		// Target type: cast expression
		String user = AccessController
				.doPrivileged((PrivilegedAction<String>) () -> System
						.getProperty("user.name"));
		System.out.println(user);
	}

	static Runnable getRunnable(String s) {
		return () -> System.out.println(s);
	}
}