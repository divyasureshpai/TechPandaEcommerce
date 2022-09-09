Feature: Verify product details is same or not in the product list page and product details page

  @uitest
  Scenario: Verify product cost is same or not in the product list page and product details page

    Given I am on the TechPanda page
    When I click on the MOBILE menu
    And I check the mobile list for 'SONY XPERIA' mobile
    And I click on 'SONY XPERIA' mobile
    And I verify the mobile details page title
    Then the product cost in the products list page and product details page should match

