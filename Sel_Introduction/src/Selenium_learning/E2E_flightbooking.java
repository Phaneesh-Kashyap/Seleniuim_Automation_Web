package Selenium_learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class E2E_flightbooking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Wait w = new Wait();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
		
		w.Wait();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		// Static dropdown with select tag
		
		WebElement aDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dd = new Select(aDropdown);
		dd.selectByIndex(1);
		System.out.println(dd.getFirstSelectedOption().getText());
		w.Wait();
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		w.Wait();
		
		int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		for(int j=1; j<3 ; j++){driver.findElement(By.id("hrefIncChd")).click();}
		w.Wait();
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.findElement(By.id("divpaxinfo")).getText();
		
		SoftAssert a = new SoftAssert();
		
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult, 2 Child");
		
	///// autosuggesting dropdown ---------------------------------
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		w.Wait();
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				System.out.println("India selected");
				break;
			}
		}
		w.Wait();
		
	
	///// dynamic dropdown ---------------------------------
	
//	//a[@value='BLR'] 
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	int count1 = driver.findElements(By.xpath("//a[@value='BLR']")).size();
	System.out.println(count1);			
//	-------------------- with indexing ---------------------
	driver.findElement(By.xpath("(//a[@value='BLR'])["+count1+"]")).click();
	w.Wait();
	
//	(//a[@value='MAA'])[2]
	driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
	int count2 = driver.findElements(By.xpath("//a[@value='MAA']")).size();
	System.out.println(count2);
//	-------------------- with indexing ---------------------
	driver.findElement(By.xpath("(//a[@value='MAA'])["+count2+"]")).click();
	w.Wait();
	
//	----------------------- with parent sibling relation xpath traverse ---------------
//	//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']
	driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
	driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
	w.Wait();
	
	
	//--------------- radio button -----------
	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	w.Wait();
	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
	
	//--------------- check boxes -----------
	
	//Select a check box			
	driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
	w.Wait();
	driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	
	
	//get all the checkboxes & print thier values - mention which is selected
	List<WebElement> cbs = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));

	System.out.println(cbs.size() + " checkboxes found");
	
//	for(WebElement cb : cbs)
//	{
//		String xp = cb.getText();
//		String x = "name : " + xp;
//		if(cb.isSelected() == true)
//		{
//			x = x + " - Selected";
//		}
//		System.out.println(x);
//		System.out.println(cb.isSelected());
//		System.out.println(driver.findElement(By.xpath(xp + "/label")).getText());
//	}
	
	
//	System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	
	Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
	Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());


	Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
	w.Wait();
	
	
	
	// ------------ calender elements ---------------
	driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
	w.Wait();
	driver.findElement(By.cssSelector(".ui-state-highlight")).click();
	w.Wait();
	
	System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
	System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isDisplayed());
	
//	driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
//	w.Wait();
//	driver.findElement(By.cssSelector(".ui-state-highlight")).click();
//	w.Wait();
	
//	String s = driver.findElement(By.id("Div1")).getAttribute("style");
	
	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 0.5"))
	{
		System.out.println("the date picker for return date is disabled");
		Assert.assertTrue(true);
		
	}
	else
	{
		System.out.println("the date picker for return date is enabled");
		Assert.assertTrue(false);
	}
	
	
	driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
	
//			id("ctl00_mainContent_btn_FindFlights")).click();
	
	
	
	
	System.out.println("----- Test Completed -----");
	w.Wait();
	w.Wait(10000);
	
	driver.quit();
		

	}

}
