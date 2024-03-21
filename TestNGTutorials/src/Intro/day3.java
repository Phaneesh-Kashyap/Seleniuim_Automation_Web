package Intro;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	

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
	  }
	 
	 @Test
	  public void api()
	  {
	      System.out.println("API Login");
	  }
	 
	 @BeforeTest
	 public void prereq()
	 {
		 System.out.println("-----Execute this as before test--------------");
	 }
	 
	 @AfterTest
	 public void aftertest()
	 {
		 System.out.println("-----Execute this as end of test--------------");
	 }


	 @BeforeSuite
	 public void befsuite()
	 {
		 System.out.println("------------------------Before Suite------------------------");
	 }
	 
	 @AfterSuite
	 public void aftsuite()
	 {
		 System.out.println("------------------------ After Suite-----------------------");
	 }
	 
	 
	 
	 
}
