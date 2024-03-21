package phaneeshkashyap.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phaneeshkashyap.AbstractComponents.AbstractComponents;

public class Checkoutpage extends AbstractComponents{
	
	WebDriver driver;
	
	public Checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	private @FindBy(css="[placeholder='Select Country']") WebElement country;
	private By it = By.cssSelector(".ta-results");	
	private @FindBy(css=".ta-item:nth-of-type(2)") WebElement countryitem;
	private @FindBy(css=".action__submit") WebElement submit;
	
	
	
	
	public ConfirmationPage selectCountryAndOrder()
	{	
		Actions a = new Actions(driver);
		a.sendKeys(country, "india").build().perform();
		waitForElementToAppear(it);
		countryitem.click();
		submit.click();
		ConfirmationPage cfp = new ConfirmationPage(driver);
		return cfp;
		
	}
	
	
}
