package phaneeshkashyap.AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import phaneeshkashyap.pageobjectmodel.CartPage;
import phaneeshkashyap.pageobjectmodel.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
//	ThreadLocal<ExtentTest> ele = new ThreadLocal<ExtentTest>();
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']") WebElement cart;
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']") WebElement myorders;

	public synchronized void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
//		ele.set(findBy);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
//		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public synchronized void waitForWebElementToAppear(WebElement findBy1)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2)); 
		wait.until(ExpectedConditions.visibilityOf(findBy1));
//		wait.until(ExpectedConditions.elementToBeClickable(findBy1));
	}
	
	
	public synchronized void waitForElementToDisappear(WebElement ele)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3)); 
		wait.until(ExpectedConditions.invisibilityOf(ele));
//		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public CartPage goToCart() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		cart.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrderPage goToOrders()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.elementToBeClickable(myorders));
		myorders.click();
		OrderPage op = new OrderPage(driver);
		return op;
	}
	
	

}
