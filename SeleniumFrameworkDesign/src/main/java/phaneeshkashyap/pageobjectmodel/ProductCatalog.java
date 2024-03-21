package phaneeshkashyap.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phaneeshkashyap.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	private @FindBy(css=".mb-3") List<WebElement> prod;
	private By prodBy = By.cssSelector(".mb-3");
	private By ToastLoading = By.cssSelector("#toast-container");
	private @FindBy(css=".ng-animating") WebElement loading;
	
	
	
	
	public void addProductToCart(String item)
	{
		waitForElementToAppear(prodBy);
		prod.stream()
		.filter(pp->pp.findElement(By.cssSelector("b")).getText().toLowerCase().contains(item))
		.forEach(pp->pp.findElement(By.cssSelector(".w-10")).click());
		waitForElementToAppear(ToastLoading);
		waitForElementToDisappear(loading);
		
	}
	
	
	
}
