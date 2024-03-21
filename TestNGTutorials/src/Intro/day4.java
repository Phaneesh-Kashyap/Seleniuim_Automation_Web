package Intro;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class day4 {
	
	

	
//	@Parameter({"testid"})
	@Test(groups= {"smoke"})
	  public void personalloan()
	  {
		
	    System.out.println("Personal Load apply");
	  }
	 
	 @Test(dataProvider="getData")
	  public void carloan(String username, String password)
	  {
	      System.out.println("CarLoan Apply");
	      System.out.println(username);
	      System.out.println(password);
	  }
	
	 
	 
	 @DataProvider
	 public Object[][] getData()
	 {
		 //list of combinations - user name and pass - multiple data
		 //good credit data
		 //no credit history
		 //fraudulent credit history
		 Object[][] data = new Object[3][2];
		 data[0][0]="user1-good user";
		 data[0][1]="pass1";
		 data[1][0]="user2-no history";
		 data[1][1]="pass2";
		 data[2][0]="user3-fraud";
		 data[2][1]="pass3";
		 
		 return data;
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 @BeforeClass
	 public void befc()
	 {
		 System.out.println("-------------Before Class------------");
	 }
	 
	 @AfterClass
	 public void aftc()
	 {
		 System.out.println("------------- After Class------------");
	 }
	 
	 @BeforeMethod
	 public void befm()
	 {
		 System.out.println("---------Before method--------");
	 }
	 
	 @AfterMethod
	 public void aftm()
	 {
		 System.out.println("--------- After method--------");
	 }
	 
	 
}
