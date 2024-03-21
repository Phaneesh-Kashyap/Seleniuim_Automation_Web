package phaneeshkashyap.StepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import phaneeshkashyap.TestComponents.BaseClass;
import phaneeshkashyap.pageobjectmodel.CartPage;
import phaneeshkashyap.pageobjectmodel.Checkoutpage;
import phaneeshkashyap.pageobjectmodel.ConfirmationPage;
import phaneeshkashyap.pageobjectmodel.LandingPage;
import phaneeshkashyap.pageobjectmodel.ProductCatalog;

public class StepDefinitionImpl extends BaseClass{
	
	public LandingPage landingPage;
	public ProductCatalog pr;
	public CartPage cp;
	public Checkoutpage cop;
	public ConfirmationPage cfp;
	public String OrderID;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = LaunchApp();
		
	}
	
	@Given("^Logged in with (.+) and (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) throws IOException
	{
		pr = l.loginApplication(username, password);
		
	}
	
	
	@When("^I add (.+) in to the cart$")
	public void I_add_product_to_cart(String prod)
	{
		pr.addProductToCart(prod);
	}
	
	@When("^Checkout (.+)") 
	public void checkout_product(String prod) throws InterruptedException
	{
		cp = pr.goToCart();
		Assert.assertTrue(cp.verifyproduct(prod));
		cop = cp.checkout();
	}
	
	
    @And("Submit Order")
    public void submit_order()
    {
    	cfp = cop.selectCountryAndOrder();
    }
	
    @Then("{string} message is displayed on CofirmationPage")
    public void message_displaayed_confirmation(String string)
    {
    	Assert.assertTrue(cfp.getConfirmationMessage().equalsIgnoreCase(string));
    	
    }
    
	@And("get the Order ID")
	public void get_order_id()
	{
		OrderID = cfp.GetOrderID();
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals(string, l.getErrMsg());
		driver.close();
	}
	
}
