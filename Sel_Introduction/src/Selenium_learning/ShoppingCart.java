package Selenium_learning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Wait w = new Wait();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(5);
		
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		String[] veg = { "Cucumber", "Brocolli", "Carrot", "Cashews", "Potato" };
		List veggies = Arrays.asList(veg);

//		List<WebElement> prod = driver.findElements(By.xpath("//h4[contains(text(),'Cucumber')]"));
		List<WebElement> prod = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < prod.size(); i++) {
			String[] s_name = prod.get(i).getText().split("-");
			String name = s_name[0].trim();
			int j = 0;
			if (veggies.contains(name)) {
				// add to cart
//				w.Wait(5000);
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == veg.length) {
					break;
				}

			}

		}

		String val = driver.findElement(By.xpath("//td[normalize-space()='Items']/following-sibling::td[2]/strong"))
				.getText();

		System.out.println(val + " item selected.");
//		w.Wait();

		// img[@alt='Cart']
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
//		w.Wait();

		// div[@class='cart-preview active']/div[@class='action-block']/button
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div[@class='action-block']/button")).click();
//		w.Wait();

		System.out.println(
				"Total Price before discount : " + driver.findElement(By.cssSelector(".discountAmt")).getText());

		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		//.promoInfo --------- explicit wait ----------------
//		Duration d = Duration.ofSeconds(7);		
//		WebDriverWait ww = new WebDriverWait (driver, d);
//		ww.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
//		ExpectedConditions.elementToBeClickable(null);
		
		
//		--------- fluent wait ---------------
		
		FluentWait<WebDriver> w1 = new FluentWait<WebDriver>(driver);
//		FluentWait w1 = new FluentWait(driver);
		w1.ignoring(NoSuchElementException.class);
		w1.withTimeout(Duration.ofSeconds(10));
		w1.pollingEvery(Duration.ofSeconds(5));
		
		
		
		WebElement foo = w1.until(new Function<WebDriver, WebElement>()
		{
			public WebElement apply(WebDriver driver) 
			{
			  System.out.println("waiting...");
			  return driver.findElement(By.cssSelector(".promoInfo"));
			}
		});
		
//		w1.until(ExpectedConditions.alertIsPresent());
		
		
//		w1.until(new Function<WebDriver, WebElement>() 
//		{
//			
//			public WebElement apply(WebDriver driver) 
//			{
//				System.out.println("waiting...");
//				if (driver.findElement(By.cssSelector(".promoInfo")).isDisplayed())
//				{
//					return driver.findElement(By.cssSelector(".promoInfo"));
//				}
//				else
//				{
//					return driver.findElement(By.cssSelector(".promoBtn"));
//					
//				}
//			
//			}
//		});
		
		System.out.println(
				"Total Price After discount : " + driver.findElement(By.cssSelector(".discountAmt")).getText());
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		
		//div[@class='wrapperTwo']/div/select
		WebElement dd = driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select"));
		Select dropdown = new Select(dd);
		dropdown.selectByVisibleText("India");
		
		driver.findElement(By.cssSelector(".chkAgree")).click();
		
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		
		
		w.Wait(3000);
		driver.quit();
		
		System.out.println("------------ Test Completed ----------");

	}

}
