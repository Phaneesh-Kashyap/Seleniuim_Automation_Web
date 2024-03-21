package JStream_LamdaExepression;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Selenium_learning.Wait;

public class FilterWebtables {

	@Test
	public void test2() {
		Wait w = new Wait();
		SoftAssert a = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String text = "go";
		
		driver.findElement(By.id("search-field")).sendKeys(text);
		
		List<WebElement> ele = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		System.out.println("Number of matching rows : " + ele.size());
		
		ele.stream().forEach(s->Assert.assertTrue(s.getText().contains(text),"Item text : " + s.getText()));
		ele.stream().forEach(s->System.out.println("Matching Item : " + s.getText()));
		
		
		w.Wait(5000);
		driver.quit();
		
		// how many rows are displayed
		// all the veigies have these text
		
		
	}
	
}
