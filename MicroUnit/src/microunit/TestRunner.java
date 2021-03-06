package microunit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
	int allCount = 0;
	int correctCount = 0;
	
	List<String> register = new ArrayList();
	public void processTestSuite(String filename) throws Exception{
		try(BufferedReader r = new BufferedReader(new FileReader(filename))) {
			String line;
			while((line = r.readLine()) != null){
				line = line.trim();
				if(!"".equals(line)){
				runTests(line);
				}
				vypis(line);
			}
		}
		
	}
	
	public void runTests(String className) throws Exception {
		Class<?> clazz;
		try {
			clazz = Class.forName(className);
		} catch (Exception e) {
			System.err.println("Not valid test class: " + className);
			return;
		}
		Object testCase;
		try {
			testCase = clazz.newInstance();
		} catch (Exception e) {
			System.err.println("Cannot create isntance for test class" + className);
			return;
		}

		for (Method method : clazz.getMethods()) {
			// TODO: over, ci metoda je v tvare public void XXX()
			if (method.isAnnotationPresent(Test.class)) {
				System.out.printf("Running test: %s.%s\n", clazz.getName(), method.getName());
				try {
					method.invoke(testCase);
					register.add("Test metody "+ method.getName() +" prebehol uspesne \n");
					System.out.printf("Test successful: %s.%s\n", clazz.getName(), method.getName());
					allCount++;correctCount++;
				} catch (InvocationTargetException e) {
					register.add("Test metody "+ method.getName() +" neprebehol uspesne \n");
					System.out.printf("Test failed: %s.%s\n", clazz.getName(), method.getName());
					e.getCause().printStackTrace();
					allCount++;
				} catch (Exception e) {
					register.add("Test metody "+ method.getName() +" neprebehol uspesne \n");
					System.out.printf("Not valid test method: %s.%s\n", clazz.getName(), method.getName());
					e.printStackTrace();
					allCount++;
				}

			}
		}
	}
	
	private void vypis(String line){
		System.out.println(register.toString());
		System.out.printf("Pocet dobrych testov pre triedu %s je %s/%s \n",line,correctCount,allCount);
	}

	public static void main(String[] args) throws Exception {
		long time = System.currentTimeMillis();
		TestRunner runner = new TestRunner();
		runner.processTestSuite("tests");
		System.out.println((System.currentTimeMillis()- time));
	}

}
