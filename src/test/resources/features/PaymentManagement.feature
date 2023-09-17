Feature: Payment page

  Background: 
    Given As an entity user, I am logged in

@PaymentManagement
  Scenario: As a user when I log in and navigate to the Payments tab, I should see Add Payment button
    And I navigate to Payments tab
    Then I should see "Add Payment" button
