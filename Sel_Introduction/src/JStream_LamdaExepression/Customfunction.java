package JStream_LamdaExepression;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Selenium_learning.Wait;

public class Customfunction {

	@Test
	public void test2() {
		Wait w = new Wait();
		SoftAssert a = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		

		WebElement aa = driver.findElement(By.id("page-menu"));
		Select dd = new Select(aa);
		dd.selectByValue("20");
//
//		w.Wait();

		// Scan the name colum with gettext -> print the price of the "Rice" --------------------
		//
		
		List<WebElement> ele = driver.findElements(By.xpath("//tbody/tr/td[1]"));
//		List<String> Sortnames = 
		List<Object> price = ele.stream().filter(s -> s.getText().contains("Rice"))
//				.map(s->s.getText().toUpperCase())
//				.filter(x->x.equals("RICE"))
				.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		
		price.forEach(x->System.out.println(x));
		
		w.Wait(5000);
		driver.quit();

	}

	private static Object getPriceVeggie(WebElement s) {
		String ss = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return ss;

	}

	
	
	
}
