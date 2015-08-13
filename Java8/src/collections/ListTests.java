package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListTests {
    //http://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
    public static void main(String[] args) {
        List<String> names = Arrays.asList("jano", "fero", "katka", "jaroslav", 
                "hanka", "jozo");
       
        //vyber najdlhsie slovo
        String s = names.stream().reduce("", (x ,y) -> x.length() > y.length() ? x : y);
        System.out.println(s);
        
        //spoj stringy
        s = names.stream().reduce("", (x,y) -> x + y);
        System.out.println(s);

        //mapuj dlzky slov 
        System.out.println(
        		names
        		.stream()
        		.map(x -> x.length())
        		.collect(Collectors.toList()));
        
        //filtruj a zozbieraj        
        System.out.println(
        		names
        		.parallelStream()
        		.filter(str -> (str.charAt(0) == 'j'))
        		.collect(Collectors.toCollection(ArrayList::new)));
    }
}
