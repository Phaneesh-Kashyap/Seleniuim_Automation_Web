
@tag
Feature: Create a Purchase Order from e-commerce site
  I want to use this template for my feature file
	
	Background:
	Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Create and submit a Purchase Order
    Given Logged in with <username> and <password>
    When I add <product> in to the cart
    And Checkout <product> 
    And Submit Order
    Then "THANKYOU FOR THE ORDER." message is displayed on CofirmationPage
    And get the Order ID

    Examples: 
      | username               | password       | product          |
      | name@gmail.com         | Name@2023      | zara coat 3      |
