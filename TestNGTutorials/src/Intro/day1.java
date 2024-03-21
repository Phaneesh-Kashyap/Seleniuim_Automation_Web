package Intro;

import org.testng.annotations.Test;

public class day1 {

	
	 @Test
	  public void f1()
	  {
	      System.out.println("Test1 - Class1");
	  }
	 
	 @Test(groups= {"smoke"})
	  public void f2()
	  {
	      System.out.println("Test1 - Class2");
	  }
	 
	 @Test
	  public void f3()
	  {
	      System.out.println("Test1 - Class3");
	  }

}
