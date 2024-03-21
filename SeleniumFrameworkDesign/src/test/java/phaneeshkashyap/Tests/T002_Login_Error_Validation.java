package phaneeshkashyap.Tests;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import phaneeshkashyap.TestComponents.BaseClass;
import phaneeshkashyap.TestComponents.RetryTestExecution;
import phaneeshkashyap.pageobjectmodel.CartPage;
import phaneeshkashyap.pageobjectmodel.ProductCatalog;

public class T002_Login_Error_Validation extends BaseClass {
	
	WebDriver driver = getDriver();
	
	@Test(groups= {"errorhandling"},retryAnalyzer=RetryTestExecution.class)
	public void loginErrorValidation () throws IOException
	{
		
//		WebDriver driver = initDriver();
		
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
//		'Log in'
		
//		LandingPage l = LaunchApp();
		l.loginApplication("name1@gmail.com", "Name@20231");
		Assert.assertEquals("Incorrect email or password.", l.getErrMsg());
		
//		Assert.assertEquals("Incorrect email password.", l.getErrMsg());
		
		

	}
	
	
	@Test(groups= {"errorhandling"})
	public void productErrorValidation () throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
			
		
				String item= "zara coat 3";
				String item1= "zara coat 4";
				
				
//				WebDriver driver = initDriver();
				
				
//				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
				
//				'Log in'
				
//				LandingPage l = LaunchApp();
				ProductCatalog pr = l.loginApplication("name@gmail.com", "Name@2023");
				
//				select a product and add to cart
				pr.addProductToCart(item);

				//go to cart
				CartPage cp = pr.goToCart();
			
//				check if the element is added to cart
				Assert.assertFalse(cp.verifyproduct(item1));
		
	}
	
	

}
