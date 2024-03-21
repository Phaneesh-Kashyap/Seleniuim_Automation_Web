package phaneeshkashyap.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phaneeshkashyap.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
//	WebElement InpUserEmail = driver.findElement(By.id("userEmail"));
	private @FindBy(id="userEmail") WebElement InpUserEmail;
	
//	WebElement Inppassword = driver.findElement(By.id("userPassword"));
	private @FindBy(id="userPassword") WebElement Inppassword;
	
//	WebElement btnLogin = driver.findElement(By.id("login"));
	private @FindBy(id="login") WebElement btnLogin;
	
	private @FindBy(css="[class*='flyInOut']") WebElement errMsg;

	public ProductCatalog loginApplication(String email, String password)
	{
		InpUserEmail.sendKeys(email);
		Inppassword.sendKeys(password);
		btnLogin.click();
		ProductCatalog pr = new ProductCatalog(driver);
		return pr;
	}
	
	public String getErrMsg()
	{
		waitForWebElementToAppear(errMsg);
		return errMsg.getText();
	}
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
}
