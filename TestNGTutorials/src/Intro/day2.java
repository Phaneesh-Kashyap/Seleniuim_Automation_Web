package Intro;

import org.testng.annotations.Test;

public class day2 {
	
	@Test
	  public void f1()
	  {
	      System.out.println("Test2 - Class1");
	  }
	 
	 @Test(groups= {"smoke"})
	  public void f2()
	  {
	      System.out.println("Test3 - Class2");
	  }

}
