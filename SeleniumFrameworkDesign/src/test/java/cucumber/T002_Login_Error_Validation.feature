
@tag
Feature: Error Validations
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with <username> and <password>
    Then "Incorrect email or password." message is displayed

       Examples: 
      | username               | password       | product          |
      | name1@gmail.com         | Name@2023      | zara coat 3      |

