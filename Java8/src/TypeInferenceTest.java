import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;


public class TypeInferenceTest {
	public static void main(String[] args) {
		Set birds = new TreeSet<>();
		birds.add("Robin");
		birds.add("Hawk");
		//won't be compiled in Java 7 and earlier
		//addAll target type: Collection<? extends String>
		//asList returns: List<T>, but List<Object> before Java 8
		birds.addAll(Arrays.asList());
		
		//in situations, where it won't be compiled, you have to state the type explicitly:
		//this will compile under Java 7
		birds.addAll(Arrays.<String>asList());
		
		
		birds.forEach(System.out::println);
	}
}
