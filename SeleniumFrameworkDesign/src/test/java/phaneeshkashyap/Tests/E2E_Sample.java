package phaneeshkashyap.Tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import Selenium_learning.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import phaneeshkashyap.AbstractComponents.Wait;
import phaneeshkashyap.pageobjectmodel.LandingPage;

public class E2E_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Wait w = new Wait();
		String item= "adidas original";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
//		'Log in'
		
		LandingPage l = new LandingPage(driver);
		
		
		driver.findElement(By.id("userEmail")).sendKeys("name@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Name@2023");
		
		driver.findElement(By.id("login")).click();
		
		
//		select a product and add to cart
		 
		
		List<WebElement> prod = driver.findElements(By.cssSelector(".mb-3"));
		
		prod.stream()
		.filter(pp->pp.findElement(By.cssSelector("b")).getText().toLowerCase().contains(item))
		.forEach(pp->pp.findElement(By.cssSelector(".w-10")).click());
		
		
//		go to cart
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//.ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
		
		
//		check if the element is added to cart
		List<WebElement> cartProd = driver.findElements(By.cssSelector(".cart h3"));
		boolean match = cartProd.stream().anyMatch(pp->pp.getText().toLowerCase().contains(item));
		Assert.assertTrue(match);
		
//		checkout
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
//		Fill out form  - select country
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")), "india").build().perform();
		//.ta-item:nth-of-type(2)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
		
//		place the order
		driver.findElement(By.cssSelector(".action__submit")).click();
		String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
//		grab the Order ID
		String val = driver.findElement(By.cssSelector("label[class='ng-star-inserted']:last-child")).getText();
		String orderID = val.split(" ")[1];
		System.out.println(orderID);
		
		
//		Orders tab - verify the order
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();
		
		List<WebElement> ordIDs = driver.findElements(By.cssSelector("tr[class='ng-star-inserted'] th"));
		boolean match1 = ordIDs.stream().anyMatch(pp->pp.getText().contains(orderID));
		Assert.assertTrue(match1);
		System.out.println(match1);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		Delete the order -
		driver.findElements(By.cssSelector(".btn-danger")).stream()
		.forEach(pp->wait.until(ExpectedConditions.visibilityOf(pp)).click());
		
		
//		go back to shop again
		driver.findElement(By.cssSelector(".offset-md-4")).click();
		
		
		
				
//		w.Wait();
		w.Wait(10000);
		driver.quit();

		
		
//		.filter(pp->pp.findElement(By.cssSelector("b")).getText().toLowerCase().contains(item))
		

	}
	
	
	

}
