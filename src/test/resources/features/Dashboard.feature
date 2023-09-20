@Regression
Feature: Dashboard home page

  Background: 
    Given As an entity user, I am logged in

  @SalesandExpansesHeader
  Scenario: As a user when I log in, I should be on the dashboard page and see the header sales and expenses
    Then I should be on the Dashboard home page
    And I should see the header "Sales & Expenses"

  @DashboardButtons @smokeTest
  Scenario: As a user when I log in, I should be on the dashboard page and see four buttons
    Then I should be on the Dashboard home page
    And I should see the buttons "Amount Due","Customers", "Invoices" and "Estimates"

  @DashboardHeaders
  Scenario: As a user when I log in, I should be on the dashboard page and see two headers
    Then I should be on the Dashboard home page
    And I should see the headers "Due Invoices" and "Recent Estimates"

  @DashboardGraph
  Scenario: As a user when I log in, I should be on the dashboard page and see the graph with a dropdown menu
    Then I should be on the Dashboard home page
    And I should see the graph and a dropdown menu having options "This year" and "Previous year"
