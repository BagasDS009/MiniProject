@register
Feature: Register
  As a new user
  I want to be able to register an account on AlterraShop
  So that I can start shopping

  Background:
    Given user is on the registration page

  @positive
  Scenario: Successful registration with valid data
    When user enters fullname "Test User"
    And user enters email "newuser@gmail.com"
    And user enters password "Password123"
    And user enters confirm password "Password123"
    And user clicks the register button
    Then user should see registration success message
    And user should be redirected to login page

  @negative
  Scenario: Registration with duplicate email
    When user enters fullname "Duplicate User"
    And user enters email "existing@gmail.com"
    And user enters password "Password123"
    And user enters confirm password "Password123"
    And user clicks the register button
    Then user should see error message "Email already registered"

  @negative
  Scenario: Registration with invalid email format
    When user enters fullname "Invalid Email User"
    And user enters email "08650000"
    And user enters password "Password123"
    And user enters confirm password "Password123"
    And user clicks the register button
    Then user should see error message "Invalid email format"

  @negative
  Scenario: Registration with mismatched passwords
    When user enters fullname "Mismatch User"
    And user enters email "mismatch@gmail.com"
    And user enters password "Password123"
    And user enters confirm password "DifferentPass456"
    And user clicks the register button
    Then user should see error message "Passwords do not match"
