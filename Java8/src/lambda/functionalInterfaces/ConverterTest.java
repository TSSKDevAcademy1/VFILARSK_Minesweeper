package lambda.functionalInterfaces;

import java.util.Arrays;

public class ConverterTest {
	@FunctionalInterface
	interface Converter {
		double convert(double input);
	}

	public static void main(String[] args) {
		// Convert Fahrenheit to Celsius
		System.out.println(convert(input -> (input - 32) * 5.0 / 9.0, 98.6));

		Arrays.asList(1.4, 156.43, 75.12).forEach(e -> System.out.println(convert(input -> (input - 32) * 5.0 / 9.0, e)));
		
		// Convert Kilometers to Miles
		System.out.println(convert(input -> input / 1.609344, 8));
	}

	//tu je double az druhy, vidno kde konci lambda pri zavolani metody (oddelenie ciarkou)
	static double convert(Converter converter, double input) {
		return converter.convert(input);
	}
}