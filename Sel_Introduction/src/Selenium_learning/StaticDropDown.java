package Selenium_learning;
import java.util.List;

//import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import java.util.List;



public class StaticDropDown {

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
				dd.selectByIndex(3);
				System.out.println(dd.getFirstSelectedOption().getText());
//				w.Wait();
				
				dd.selectByValue("AED");
				System.out.println(dd.getFirstSelectedOption().getText());
//				w.Wait();
				
				dd.selectByVisibleText("INR");
				System.out.println("selected currency : " + dd.getFirstSelectedOption().getText());
//				Assert.assertEquals(dd.getFirstSelectedOption().getText(),"INR");
//				adfaeasd
				
				w.Wait();
				
				driver.findElement(By.id("divpaxinfo")).click();
				w.Wait();
				
				int i=1;
				while(i<3)
				{
					driver.findElement(By.id("hrefIncAdt")).click();
					i++;
				}
				
				for(int j=1; j<2 ; j++){driver.findElement(By.id("hrefIncChd")).click();}
				w.Wait();
				
				driver.findElement(By.id("btnclosepaxoption")).click();
				driver.findElement(By.id("divpaxinfo")).getText();
				
				Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult, 1 Child");
//				System.out.println("selected options : " + driver.findElement(By.id("divpaxinfo")).getText());
				
				
				w.Wait();
				
				
//				// check the return date is disabled
//				System.out.println("return date : " + driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
				String s = driver.findElement(By.id("Div1")).getAttribute("style");
				
				if(s.contains("opacity: 0.5"))
				{
					System.out.println("the date picker for return date is disabled");
				}
				
				
				
				
				
			///// autosuggesting dropdown ---------------------------------
				driver.findElement(By.id("autosuggest")).sendKeys("ind");
				w.Wait();
				List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
				System.out.println("India selected");
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
				
//				//select from bengaluru - search and select the highlighted one
//				driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//				driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("bengaluru");
//				if (driver.findElements(By.xpath("//li[contains(@class,'city_selected')]/a")).size() != 0)
//				{
//					driver.findElement(By.xpath("//li[contains(@class,'city_selected')]/a")).click();	
//				}
//				w.Wait();
//				
//				//select from manglore - search and select the highlighted one
//				driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
//				w.Wait();
//				driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("mangaluru");
//				w.Wait();
//				if (driver.findElements(By.xpath("//li[contains(@class,'city_selected')]/a[1]")).size() != 0)
//				{
//					driver.findElement(By.xpath("//li[contains(@class,'city_selected')]/a[1]")).click();	
//				}
//				w.Wait();
//				
//				//select the data of tomorrow
//				driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
//				int today = Integer.parseInt(driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).getText());
//				int tomorrow = today + 1;
//						
//				driver.findElement(By.linkText(String.valueOf(tomorrow)));
				
				
			
			///// dynamic dropdown ---------------------------------
			
//			//a[@value='BLR'] 
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			int count1 = driver.findElements(By.xpath("//a[@value='BLR']")).size();
			System.out.println(count1);			
//			-------------------- with indexing ---------------------
			driver.findElement(By.xpath("(//a[@value='BLR'])["+count1+"]")).click();
			w.Wait();
			
//			(//a[@value='MAA'])[2]
			driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
			int count2 = driver.findElements(By.xpath("//a[@value='MAA']")).size();
			System.out.println(count2);
//			-------------------- with indexing ---------------------
			driver.findElement(By.xpath("(//a[@value='MAA'])["+count2+"]")).click();
			w.Wait();
			
//			----------------------- with parent sibling relation xpath traverse ---------------
//			//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']
			driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
			driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
			w.Wait();
			
			//--------------- radio button -----------
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			w.Wait();
			
			//--------------- check boxes -----------
			
			//Select a check box			
			driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
			w.Wait();
			driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			
			
			//get all the checkboxes & print thier values - mention which is selected
			List<WebElement> cbs = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
		
			System.out.println(cbs.size() + " checkboxes found");
			
			for(WebElement cb : cbs)
			{
				String xp = cb.getText();
				String x = "name : " + xp;
				if(cb.isSelected() == true)
				{
					x = x + " - Selected";
				}
				System.out.println(x);
//				System.out.println(cb.isSelected());
//				System.out.println(driver.findElement(By.xpath(xp + "/label")).getText());
			}
			
			
//			System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			
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
			
//			driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
//			w.Wait();
//			driver.findElement(By.cssSelector(".ui-state-highlight")).click();
//			w.Wait();
			
//			String s = driver.findElement(By.id("Div1")).getAttribute("style");
			
			if(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 0.5"))
			{
				System.out.println("the date picker for return date is disabled");
				Assert.assertTrue(false);
				
			}
			else
			{
				System.out.println("the date picker for return date is enabled");
				Assert.assertTrue(true);
			}
			
			
			
			
			
			
			
			
			System.out.println("----- Test Completed -----");
			w.Wait();
			w.Wait();
			
			driver.quit();
			
			
		
	}

}
