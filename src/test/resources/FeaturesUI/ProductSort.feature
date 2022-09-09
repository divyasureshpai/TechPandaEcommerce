Feature: Sort the Mobile List page

  @uitest
  Scenario: Verify the Mobile List page can be sorted by Name

    Given I am on the TechPanda page
    When I click on the MOBILE menu
    And I verify the page title
    And I click on the sort by drop-down
    And I choose the sort by name option
    Then the products should be listed in the sorted order by its name
