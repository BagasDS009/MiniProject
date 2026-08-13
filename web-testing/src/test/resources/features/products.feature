@products
Feature: Products
  As a user
  I want to browse and manage products on AlterraShop
  So that I can find items to purchase

  @positive
  Scenario: View all products on homepage
    Given user is on the products page
    Then user should see list of products
    And each product should display name and price

  @positive
  Scenario: View product detail
    Given user is on the products page
    When user clicks on a product
    Then user should see product detail page
    And user should see product name, price, and description

  @positive
  Scenario: Search for a product
    Given user is on the products page
    When user searches for "Durian"
    Then user should see products matching "Durian"

  @negative
  Scenario: Search with no results
    Given user is on the products page
    When user searches for "NonExistentProduct12345"
    Then user should see empty result message
