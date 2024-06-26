package Selenium_learning;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/phane/Documents/04. Automation - new learning/Selenium/Drivers/V113/chromedriver.exe");			
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://dhanonethree.com/");
////		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////		driver.manage().timeouts().impl
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		
//		
//		driver.findElement(By.id("cn-refuse-cookie")).click();
//		
//		// Locator - by ID
//		driver.findElement(By.id("wp-block-search__input-1")).sendKeys("krishna");
//		driver.findElement(By.className("search-icon")).click();
//		
//		driver.findElement(By.id("post-906")).click();

		driver.get("http://saucedemo.com/");
		
		Wait w = new Wait();
		
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("user-name")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.className("btn_action")).click();
		String s = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
		System.out.println(s);
		
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.className("btn_action")).click();
		String s1 = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
		System.out.println(s1);
		
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.className("btn_action")).click();
		String s2 = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
		System.out.println(s2);
		
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.className("btn_action")).click();
		String s3 = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
		System.out.println(s3);
		
		driver.findElement(By.id("user-name")).clear();
//		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.className("btn_action")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String s4 = driver.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name']")).getText();		
		System.out.println("----------- Logged in ---------------");
		
		w.Wait();
		
		System.out.println(s4);
//		driver.findElement(By.linkText(s4)).click(); //---------------------------by link text
		
//		driver.findElement(By.xpath("//a[contains(@id,'_title_link')] [@xpath=3]")).click();
		
//		 //obsolute xpath
//		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/div[1]")).click();
		
		
//		h3[data-test='error']
//		var a = driver.findElement(By.linkText(s4)).isDisplayed();
//		System.out.println(a);
		
//		List<WebElement> dd = driver.findElements(By.xpath("//div[@class='inventory_details_name large_size']"));
//		dd.size()
//		
		
//		try{
//
////			WebElement element = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));
//			List<WebElement> element = driver.findElements(By.cssSelector(".inventory_details_name.large_size"));
//			System.out.println("Element exists");
//		
//			}
//
//			catch(NoSuchElementException e){System.out.println("Item not displayed");;
//
//			}
		
		
		
//		
//		try {
//		    Thread.sleep(2000);
//		} catch(InterruptedException e) {
//		    System.out.println("got interrupted!");
//		}
		
		w.Wait();
		
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/div[1]")).click();
		
		
		if (driver.findElements(By.cssSelector(".inventory_details_name.large_size")).size() != 0)
		{
			String val = driver.findElement(By.cssSelector(".inventory_details_price")).getText();
			System.out.println("The value of this item is : " + val);	
		}
		else
		{
			System.out.println("Item not displayed");
		}
//		
//		boolean i = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).isDisplayed();
		//List<WebElement> dd = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));
		
		
		
		
		
//		driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")
		
//		if (i)
//		{
//			String val = driver.findElement(By.cssSelector(".inventory_details_price")).getText();
//			System.out.println("The value of this item is : " + val);	
//		}
//		else
//		{
//			System.out.println("Item not displayed");
//		}
		
		
		//// ----------------------- traversing from parant to child -----------------------
		
		
	
		
		
		
	}

}
