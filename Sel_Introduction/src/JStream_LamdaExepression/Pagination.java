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

public class Pagination {

	@Test
	public void test2() {
		Wait w = new Wait();
		SoftAssert a = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		
//		WebElement aa = driver.findElement(By.id("page-menu"));
//		Select dd = new Select(aa);
//		dd.selectByValue("20");
////
//		w.Wait();

		// Scan the name colum with gettext -> print the price of the "Rice"
		// search in all the pages there are 4 pages. clik on next
		List<Object> price;
		String flag;
		String sss = "Carrot";
//		System.out.println("Price of" + sss + " is : " );
		do 
		{
			
		
			List<WebElement> ele = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	//		List<String> Sortnames = 
			price = ele.stream().filter(s -> s.getText().contains(sss))
	//				.map(s->s.getText().toUpperCase())
	//				.filter(x->x.equals("RICE"))
					.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			
			
			
			flag = driver.findElement(By.cssSelector("[aria-label='Next']")).getAttribute("aria-disabled");
			if (price.size()<1)
			{
				if(!(flag.equals("true")))
				{
					driver.findElement(By.cssSelector("[aria-label='Next']")).click();
				}
				else
				{
					System.out.println("Item " + sss + " not found in the list");
				}
			}
			else
			{
				System.out.println("Item " + sss + " found ");
			}
			
			price.forEach(x->System.out.println("Price of " + sss + " is : " + x));
			
		}while(price.size()<1 && !(flag.equals("true")));
			
			
		w.Wait(5000);
		driver.quit();
	}

	private static Object getPriceVeggie(WebElement s) {
		String ss = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return ss;

	}

	
	
}
