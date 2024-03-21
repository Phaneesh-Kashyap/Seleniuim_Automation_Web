package phaneeshkashyap.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import phaneeshkashyap.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	private @FindBy(css=".cart h3") List<WebElement> prod;
	private @FindBy(css=".totalRow button") WebElement checkout;
	
	
	
	
	public boolean verifyproduct(String item)
	{	
		return prod.stream().anyMatch(pp->pp.getText().toLowerCase().contains(item));
	}
	
	public Checkoutpage checkout()
	{
		checkout.click();
		Checkoutpage cop = new Checkoutpage(driver);
		return cop;
		
	}
	
	
}
