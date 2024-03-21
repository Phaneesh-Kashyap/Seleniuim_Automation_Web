package Sel4_features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import Selenium_learning.Wait;

public class relativeLocators {
	
//	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		above();
//		below();
//		toLeftOf();
//		toRightOf();
//		
//		Syntax:
//		driver.findElement(withTagName("XX").above(WebElement))
		
		
		
		Wait w = new Wait();
		SoftAssert a = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement ele = driver.findElement(By.xpath("//label[text()='Email']"));
		
		String ss = driver.findElement(with(By.tagName("label")).above(ele)).getText();
		String id = driver.findElement(with(By.tagName("label")).below(ele)).getText();
		String id1 = driver.findElement(with(By.tagName("input")).toRightOf(ele)).getAttribute("class");
		System.out.println(ss + " ------- " + id + " ------- " + id1);
		
//		driver.findElement(with);
		
		w.Wait();
		
		
		
		WebElement elem = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(elem)).click();
		
		
		WebElement ele2 = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(ele2)).click();
		
		w.Wait(3000);
		driver.quit();
		
		

	}

}
