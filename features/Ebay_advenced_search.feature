Feature: advanced search page

  @regression
  Scenario: ebay logo on advanced search page
    Given i am on advanced search page
    When i click on ebay logo
    Then i am redirected to home page

  @t5
  Scenario: advanced search item
    Given i am on advanced search page
    When i advanced search an item
      | item   | exclude     | min | max |
      | laptop | refurbished | 200 | 800 |
    Then i validate at least 80 search items present 
