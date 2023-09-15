@customerManagementTests
Feature: Customer management

  Background: 
    Given As an entity user, I am logged in
    When I navigate to the customers tab

  @newCustomerBTNTest
  Scenario: As a user when I navigate to the Customers Tab, I should see New customer button
    Then I should see the New Customer button displayed

  @newCustomerBasicInfoFormLabel
  Scenario: As a user when I navigate to the Customers Tab and Click on New customer button, I should see the basic information form label
    And I click on the New Customer button
    Then I should see the Basic Info form label

  @newCustomerBasicInfoFormFields
  Scenario: As a user when I navigate to the Customers Tab and Click on New customer button,
    I should see the basic information form label displayed,
    I should see fields in the basic info section are displayed

    And I click on the New Customer button
    Then I should see the Basic Info form label
    Then I should see the fields Display name, Primary Contact Name,, Email, Primary Currency,Website and Prefix

  @newCustomerTableList
  Scenario: As a user when I navigate to the Customers Tab, I should see the Customers Table List
    Then I should see the Customer List Table

  @CustomerTableColumns
  Scenario: As a user when I navigate to the Customers Tab, I should see four columns in the table
    Then I should see table columns NAME, PHONE, AMOUNT DUE, ADDED ON

  @CustomerLinkOptions
  Scenario: As a user when I navigate to the Customers Tab,
    I should see a link for the customer row with the options Edit,View and Delete

    And I click on More link
    Then I should see options Edit, View and Delete

  @CreateNewCustomer
  Scenario: As a user when I navigate to the Customers Tab, when I create a user I
    I should see a pop up message

    And I click on the New Customer button
    Then I enter a display name
    And I click save
    Then I should see the pop up message "Customer created successfully"
    Then I delete the customer

  @CreateNewCustomerInvalid
  Scenario: As a user when I navigate to the Customers Tab,
    	when I click save new customer button without filling any field,
    	I should see error message

    And I click on the New Customer button
    And I click save
    Then I should see the message "Field is required"

  @newCustomers
  Scenario Outline: As a user, when I create a new customer I should see the Customer Table
    And I click on the New Customer button
    When I enter a valid "<Display Name>", "<Email>", "<State>", "<City>", and "<ZipCode>"
    And I click save
    Then I should see the new customer in the data table
    And I delete the customer

    Examples: 
      | Display Name | Email                | State | City   | ZipCode |
      | Student1     | student1@example.com | FL    | FL     |   12345 |
      | Student2     | student2@example.com | MI    | NY     |   54321 |
      | Student3     | student3@example.com | CA    | Railey |   13456 |

  @homework
  Scenario Outline: As a user, when I create
                    a new customer vith invalid credentials, 
                    I should see the error message

    And I click on the New Customer button
    When I enter "<Display Name>" and "<Email>"
    Then I should see invalid fields error messages

    Examples: 
      | Display Name | Email                |
      | kl           | student@example.com  |
      |              | student1@example.com |
      | Student2     | Testing123           |
