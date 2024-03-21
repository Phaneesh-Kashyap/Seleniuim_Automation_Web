package Selenium_learning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Z_04_Calander {

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

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		w.Wait(5000);

//		(//span[@class='ui-datepicker-month'])[1]
		while (!(driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().contains("May")
				&& driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText()
						.contains("2023"))) {
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
			w.Wait(250);
		}

		List<WebElement> dd = driver.findElements(By.xpath("(//td[@data-handler='selectDay'])"));

//		(//td[@data-handler='selectDay'])[1]
		int aa = Integer.parseInt(
				driver.findElement(By.xpath("(//td[@data-handler='selectDay'])[1]")).getAttribute("data-month")) + 1;
		String mon = Integer.toString(aa);

		System.out.println(mon);
		w.Wait(1000);

		for (WebElement el : dd) {
//			el.findElement(By.tagName("a"));

//			String a = driver.findElement(By.xpath("(//a[@class='ui-state-default'])[1]")).findElement(By.xpath("//parent::td")).getAttribute("data-handler");
//			System.out.println(a);
//			System.out.println(el.getAttribute("data-month"));
			if (el.findElement(By.tagName("a")).getText().contains("23")
					&& el.getAttribute("data-month").contentEquals(mon)) {
				el.click();
				break;
			}

		}

		// td[@data-month]/a[@text()='23']

		w.Wait(5000);
		driver.quit();

	}

}
