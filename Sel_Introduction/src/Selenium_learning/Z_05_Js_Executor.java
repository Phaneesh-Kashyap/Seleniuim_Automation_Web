package Selenium_learning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Z_05_Js_Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Wait w = new Wait();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.get("https://www.path2usa.com/travel-companions");
//		
//		driver.findElement(By.id("form-field-travel_comp_date")).click();

		//// span[contains(@aria-label,'May 23, 2023')]

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		w.Wait();
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=150");
		
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr"));
		
		int total = 0;
		
		
		for(WebElement el : ele)
		{	
			
			
			List<WebElement> rr = el.findElements(By.tagName("td"));
			
//			for(WebElement r : rr)
//			{	
//				System.out.print(r.getText() + "-");
//				
//			}
//		
			
			System.out.print(rr.get(0).getText() + "-" + rr.get(3).getText());
			
			total = total +  Integer.parseInt(rr.get(3).getText());
			
			
//			System.out.print(el.findElement(By.xpath("//td[1]")).getText() + "-");
//			System.out.print(el.findElement(By.xpath("//td[2]")).getText() + "-");
//			System.out.print(el.findElement(By.xpath("//td[3]")).getText() + "-");
//			System.out.print(el.findElement(By.xpath("//td[4]")).getText() + "\n");
			System.out.print("\n");
						
//			System.out.print(el.getText() + "\n");
			
			
		}
		
		System.out.print("Total Amount - " + total);
		System.out.print("\n");
		w.Wait();
		w.Wait();
		
		
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://qaclickacademy.com/practice.php");

		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		String s = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).getText();
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		w.Wait();
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		w.Wait();
//		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		w.Wait();
		String ss = driver.findElement(By.id("autocomplete")).getAttribute("value"); 
//		String s = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).getText();
		System.out.print("\n");
		System.out.println(ss);
		System.out.print("\n");
		System.out.println(s);
		System.out.print("\n");
		
		Assert.assertEquals(s, ss);
		
		
		w.Wait();
		w.Wait();
		driver.quit();
		

	}

}
