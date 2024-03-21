package phaneeshkashyap.pageobjectmodel;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phaneeshkashyap.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{

WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	private @FindBy(css=".hero-primary") WebElement message;
	private @FindBy(css="label[class='ng-star-inserted']:last-child") WebElement ordernum;
	
	public String getConfirmationMessage()
	{	
		return message.getText();
		
	}
	
	public String GetOrderID()
	{	
		return ordernum.getText().split(" ")[1];
	}
	
}
