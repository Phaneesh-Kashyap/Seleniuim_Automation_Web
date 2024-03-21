package Selenium_learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class action_class_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wait w = new Wait();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(5);
		
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement moveto = driver.findElement(By.id("nav-link-accountList"));
		
		
		Actions a = new Actions(driver);
		a.moveToElement(moveto).build().perform();
		w.Wait(3000);
//		a.moveToElement(driver.findElement(By.id("nav-search-bar-form"))).click().keyDown(Keys.SHIFT).sendKeys("benz").build().perform();
		a.moveToElement(driver.findElement(By.id("nav-search-bar-form"))).click().keyDown(Keys.SHIFT).sendKeys("ash").doubleClick().keyDown(Keys.CONTROL).sendKeys("x").build().perform();
		
		
		
		w.Wait(3000);
		a.moveToElement(driver.findElement(By.id("nav-search-bar-form"))).click().keyDown(Keys.CONTROL).sendKeys("v").doubleClick().contextClick().build().perform();
		w.Wait(3000);
		a.moveToElement(moveto).build().perform();
		w.Wait(3000);
		
		driver.quit();
		
	}

}
