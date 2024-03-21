package JStream_LamdaExepression;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Stream_map {

	@Test
	public void streammap() {
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

		// print names which have last letter as "h" and add kashyap as surname
		names.stream().filter(s -> s.endsWith("h")).map(s -> s.concat(" Kashyap").toUpperCase()).sorted()
				.forEach(s -> System.out.println(s));

		System.out.println("------------------------------------");

		names.stream().filter(a -> a.contains("esh") || a.contains("Ash")).forEach(a -> System.out.println(a));

		System.out.println("------------------------------------");

		Stream.of(123, 12, 52, 65, 54, 39, 25, 89).filter(s -> s % 3 == 0)
//		.forEach(q->System.out.println(q))
				.map(q -> (q / 3) - 1).filter(q -> q % 2 == 0).map(q -> (q / 2) + 1).sorted()
				.forEach(q -> System.out.println("--->" + q));
		System.out.println("------------------------------------");
		
		Stream.of(123, 12, 52, 65, 54, 39, 25, 89).sorted(Comparator.reverseOrder()).forEach(q->System.out.println(q));
		
		System.out.println("------------------------------------");

		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Ashwini");
		names1.add("Abhijit");
		names1.add("noone");
		names1.add("Ajay");
		names1.add("phaneesh");
		names1.add("Akash");
		names1.add("Amrutha");
		names1.add("prakash");
		names1.add("pankaj");
		names1.add("sam");

		Stream<String> s1 = names1.stream();

		Stream<String> s2 = Stream.of("don", "con", "man", "job", "got");

		// convert arrayList to stream
		// concatenate two streams
		Stream<Serializable> constr = Stream.concat(s1, s2);
		constr.forEach(a -> System.out.println(a));

		System.out.println("------------------------------------");

		List<ArrayList<String>> n2 = Arrays.asList(names1);
		Stream<ArrayList<String>> ss1 = n2.stream();
		ArrayList<String> aa = new ArrayList<String>();
		aa.add("don");
		aa.add("con");
		aa.add("man");
		aa.add("job");
		aa.add("got");
//		"don", "con", "man", "job", "got"
		List<ArrayList<String>> n3 = Arrays.asList(aa);
		Stream<ArrayList<String>> ss2 = n3.stream();
		Stream<Serializable> sconstr = Stream.concat(ss1, ss2);
		sconstr.forEach(a -> System.out.println(a));
		
		///matching the values
		Stream<String> s3 = names1.stream();
		boolean flag = s3.anyMatch(a->a.equalsIgnoreCase("phanEEsh"));
		
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		

	}

}
