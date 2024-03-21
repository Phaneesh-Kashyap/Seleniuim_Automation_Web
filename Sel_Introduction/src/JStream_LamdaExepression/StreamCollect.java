package JStream_LamdaExepression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class StreamCollect {
	
	@Test
	public void streamcol() 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ashwini");
		names.add("Abhijit");
		names.add("noone");
		names.add("Ajay");
		names.add("phaneesh");
		names.add("Akash");
		names.add("Amrutha");
		names.add("prakash");
		names.add("pankaj");
		names.add("sam");

		names.forEach(System.out::println);
		System.out.println("---------------The Great Ones---------------------");

		/// take the list -> stream -> filter -> map -> collect
		List<String> l = names.stream()
		.filter(a -> a.contains("esh") || a.contains("Ash"))
		.map(s->s.toUpperCase())
		.map(s -> s.concat(" is great"))
		.sorted()
		
		.collect(Collectors.toList());
		
		l.forEach(System.out::println);
		
		
	}
	
	
}
