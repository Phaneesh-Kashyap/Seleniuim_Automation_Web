package CoreJava;

import org.testng.annotations.Test;

public class PS1 extends PS{

	@Test
	public void testrun()
	{
		int a = 3;
		PS2 ps2 = new PS2(a);
		
		printsomething();
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());
		
		
//		PS3 ps3 = new PS3(a);
		System.out.println(ps2.multiplybytwo());
		System.out.println(ps2.multiplybythree());
		
		
	}
	
	
	
	
}
