@login
Feature: Login
  As a registered user
  I want to be able to login to AlterraShop
  So that I can access my account and make purchases

  Background:
    Given user is on the login page

  @positive
  Scenario: Successful login with valid credentials
    When user enters valid email "testuser@gmail.com"
    And user enters valid password "Password123"
    And user clicks the login button
    Then user should be redirected to the dashboard
    And user should see welcome message

  @negative
  Scenario: Login with invalid email
    When user enters invalid email "invalidemail"
    And user enters valid password "Password123"
    And user clicks the login button
    Then user should see error message "Invalid email or password"

  @negative
  Scenario: Login with wrong password
    When user enters valid email "testuser@gmail.com"
    And user enters wrong password "WrongPass123"
    And user clicks the login button
    Then user should see error message "Invalid email or password"

  @negative
  Scenario: Login with empty email
    When user leaves email field empty
    And user enters valid password "Password123"
    And user clicks the login button
    Then user should see error message "Email is required"

  @negative
  Scenario: Login with empty password
    When user enters valid email "testuser@gmail.com"
    And user leaves password field empty
    And user clicks the login button
    Then user should see error message "Password is required"
