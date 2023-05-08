Feature: advanced search page

  @regression
  Scenario: ebay logo on advanced search page
    Given i am on advanced search page
    When i click on ebay logo
    Then i am redirected to home page
