@cart
Feature: Shopping Cart
  As a logged in user
  I want to manage items in my cart
  So that I can proceed to checkout

  Background:
    Given user is logged in
    And user is on the products page

  @positive
  Scenario: Add product to cart
    When user clicks add to cart on a product
    Then product should be added to the cart
    And cart count should increase by 1

  @positive
  Scenario: Remove product from cart
    Given user has items in the cart
    When user removes an item from the cart
    Then the item should be removed
    And cart count should decrease by 1

  @negative
  Scenario: Add to cart without login
    Given user is not logged in
    And user is on the products page
    When user clicks add to cart on a product
    Then user should be redirected to login page
