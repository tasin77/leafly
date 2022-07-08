Feature: Test purchase limit functionalities

  @positive_test
  Scenario: Check quantity is successful with valid value
    Given a user is on product1 page
    When user clicks on add to bag button upon entering "5" in the Quantity field
    And clicks on bag icon
    Then quantity displays "5" items in the cart

  @negative_test
  Scenario: Check quantity is unsuccessful with invalid value
    Given a user is on product1 page
    When user clicks on add to bag button upon entering "6" in the Quantity field
    And clicks on bag icon
    Then quantity displays "5" items in the cart

