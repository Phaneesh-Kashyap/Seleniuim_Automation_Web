package phaneeshkashyap.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import Selenium_learning.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import phaneeshkashyap.AbstractComponents.Wait;
import phaneeshkashyap.TestComponents.BaseClass;
import phaneeshkashyap.pageobjectmodel.CartPage;
import phaneeshkashyap.pageobjectmodel.Checkoutpage;
import phaneeshkashyap.pageobjectmodel.ConfirmationPage;
import phaneeshkashyap.pageobjectmodel.LandingPage;
import phaneeshkashyap.pageobjectmodel.OrderPage;
import phaneeshkashyap.pageobjectmodel.ProductCatalog;

public class T001_E2E_e_Shopping_CreateOrder_And_Validate extends BaseClass {

	String OrderID;
	
	
	@Test(dataProvider="getData",groups="purchase")
	public void createOrder (HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
//		LandingPage l = LaunchApp();
		ProductCatalog pr = l.loginApplication(input.get("email"), input.get("pass"));
		
//		select a product and add to cart
		pr.addProductToCart(input.get("prod"));
//		pr.addProductToCart(item1);
		//go to cart
		CartPage cp = pr.goToCart();
	
//		check if the element is added to cart
		Assert.assertTrue(cp.verifyproduct(input.get("prod")));
//		Assert.assertTrue(cp.verifyproduct(item1));
//		w.Wait();
		Checkoutpage cop = cp.checkout();
		
//		Fill out form  - select country - place order
		ConfirmationPage cfp = cop.selectCountryAndOrder();
		Assert.assertTrue(cfp.getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//grab the Order ID
		OrderID = cfp.GetOrderID();

	}
	
//	@Test(dependsOnMethods= {"createOrder"})
	@Test
	public void verifyOrder() 
	{
		String item= "adidas original";
		ProductCatalog pr = l.loginApplication("name1@gmail.com", "Name@2022");
		
		OrderPage op = pr.goToOrders();
		
//		Orders tab - verify the order
//		Assert.assertTrue(op.verifyOrder(OrderID));
		Assert.assertTrue(op.verifyorderitem(item));
		
	}
	
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		//hashmap usage
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email","name@gmail.com");
		map.put("pass","Name@2023");
		map.put("prod","zara coat 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email","name1@gmail.com");
		map1.put("pass","Name@2022");
		map1.put("prod","adidas original");
		
		
		return new Object[][] {
			{map}, 
			{map1}
			};
	}
	
	
	
	

//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
////	Delete the order -
//	driver.findElements(By.cssSelector(".btn-danger")).stream()
//	.forEach(pp->wait.until(ExpectedConditions.visibilityOf(pp)).click());
//	
//	
////	go back to shop again
//	driver.findElement(By.cssSelector(".offset-md-4")).click();
//	
//	
	
			
//	w.Wait();
//	w.Wait(3000);
//	driver.quit();

	
	
//	.filter(pp->pp.findElement(By.cssSelector("b")).getText().toLowerCase().contains(item))
	
	

}
