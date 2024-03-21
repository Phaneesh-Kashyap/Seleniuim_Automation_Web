package JStream_LamdaExepression;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;


public class test1 {
	
	// count number of names starting with alphabet A in the list
//	@Test
//	public void regular()
//	{
//		ArrayList<String> names=new ArrayList<String>();
//		names.add("Ashwini");
//		names.add("Abhijit");
//		names.add("noone");
//		names.add("Ajay");
//		names.add("phaneesh");
//		names.add("Akash");
//		
//		int count = 0;
//		
//		for(int i=0;i<names.size(); i++)
//		{
//			if(names.get(i).startsWith("A") || names.get(i).startsWith("a"))
//			{
//				count++;
//			}
//					
//		}
//		
//		System.out.println("the number of elements starting with A is : " + count);
//			
//	}

	@Test
	public void streamfilter()
	{
		ArrayList<String> names=new ArrayList<String>();
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
		
		
		Long count = names.stream().filter(ss->ss.startsWith("A")).count();
		System.out.println("the number of elements starting with A is : " + count);
		names.stream().filter(ss->ss.length()>5).forEach(ss->System.out.println(ss));
		names.stream().filter(ss->ss.startsWith("n") || ss.startsWith("s")).forEach(ss->System.out.println(ss));
		
		Long count1 = names.stream().filter(ss->ss.startsWith("p")).count();
		System.out.println("the number of elements starting with p is : " + count1);
		names.stream().filter(ss->ss.startsWith("p")).limit(2).forEach(ss->System.out.println(ss));
		
//		Stream.of(123,12,52,65,54,36,25,89).filter(s->
		long d = Stream.of("AA","AB","Ac","gds").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println("the number of elements starting with A is : " + d);
		
		
		Stream.of(123,12,52,65,54,36,25,89).filter(q->q % 3 == 0).forEach(q->System.out.println(q));
		
		
		
		
		
		
	}
	
	
	
}
