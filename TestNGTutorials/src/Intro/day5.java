package Intro;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day5 {

	 @Test(timeOut=4000)
		@Parameters({"testid","password"})
	  public void web(String testid, String password)
//	 public void web()
	  {
		System.out.println("User Id : " + testid);
		System.out.println("Password : " + password);
	      System.out.println("Web Login");
	  }
	
	 
//	 @Test(dependsOnMethods={"server"})
	 @Test
	 @Parameters({"testid","password"})
	 public void backend(String testid, String password)
//	 public void backend()
	  {
		 System.out.println("User Id : " + testid);
			System.out.println("Password : " + password);
	      System.out.println("backend Login");
	  }
	 
	 @Test
	 public void server()
	  {
	      System.out.println("server Login");
	  }
	 
	 @Test(groups= {"smoke"})
	  public void mobile()
	  {
	      System.out.println("Mobile Login");
	      Assert.assertTrue(false);
	  }
	 
	 @Test
	  public void api()
	  {
	      System.out.println("API Login");
	  }
	
}
