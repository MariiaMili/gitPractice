
@userManagement
Feature: User management / access management

  @validLogin @smokeTest
  Scenario: User should be able tp login with valid credentials
    Given As a user, I am on the login page
    When I enter valid usermail and valid password
    And Click on login button
    Then I should be logged in

  # Cucumber reuses the steps that are already implemented
  # if there are same two steps,
  # cucumber only generates one step definition and reuses that step definition between that two steps
  @invalidEmailLogin
  Scenario: Invalid email login attempts
    Given As a user, I am on the login page
    When I enter invalid usermail and valid password
    And Click on login button
    Then I should see an error message "These credentials do not match our records." displays
    And I should not be logged in

  @InvalidLoginError
  Scenario Outline: Invalid login attempts
    Given As a user, I am on the login page
    When I enter invalid useremail "<useremail>" and password "<password>"
    And Click on login button
    Then I should see an error message
    And I should not be logged in

    Examples: 
      | useremail                   | password        |
      | helil@primetechschool.com   | standardhhfvajk |
      | nothing@primetechschool.com | Testing123      |
      |                             | Testing123      |
      | nothing@primetechschool.com |                 |
      |                             |                 |
