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
import TestData.DataReader;

public class T003_JSONDATA_Create_Order extends BaseClass {

	String OrderID;
	String item= "adidas original";
	
	@Test(dataProvider="getData",groups="purchase")
	public void createOrder (HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		ProductCatalog pr = l.loginApplication(input.get("email"), input.get("pass"));
		
		pr.addProductToCart(input.get("prod"));
		
		CartPage cp = pr.goToCart();
		Assert.assertTrue(cp.verifyproduct(input.get("prod")));
		
		Checkoutpage cop = cp.checkout();		
		ConfirmationPage cfp = cop.selectCountryAndOrder();
		Assert.assertTrue(cfp.getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		OrderID = cfp.GetOrderID();

	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		//hashmap usage
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email","name@gmail.com");
//		map.put("pass","Name@2023");
//		map.put("prod","zara coat 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email","name1@gmail.com");
//		map1.put("pass","Name@2022");
//		map1.put("prod","adidas original");
//		
//		
//		return new Object[][] {
//			{map}, 
//			{map1}
//			};
//	}
	
		List<HashMap<String,String>> data = getJsonDataToMap("PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
		
		
	}
}
