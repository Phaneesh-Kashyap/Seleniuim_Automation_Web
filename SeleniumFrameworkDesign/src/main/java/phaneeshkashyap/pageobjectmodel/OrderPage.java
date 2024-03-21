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

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	private @FindBy(css="tr[class='ng-star-inserted'] th") List<WebElement> prod;
	private @FindBy(css=".totalRow button") WebElement checkout;
	private @FindBy(css="tbody tr td:nth-child(3)") List<WebElement> Ordersprodname;
	
	
	
	
	
	public boolean verifyOrder(String orderID)
	{	
		return prod.stream().anyMatch(pp->pp.getText().contains(orderID));
	}
	
	public Checkoutpage checkout()
	{
		checkout.click();
		Checkoutpage cop = new Checkoutpage(driver);
		return cop;
		
	}
	
	public boolean verifyorderitem(String item)
	{
		return Ordersprodname.stream().anyMatch(p->p.getText().contains(item));
	}
	
	
}
