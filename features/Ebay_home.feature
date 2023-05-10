#ce projet cree par Krimou
#email:krimou@gamil.com le 03/05/2023
Feature: home page ebay
  ce feature pour tester les fonctionnalités de home ebay

  @smoke
  Scenario: advanced search link
    Given i am on ebay home page
    When i click on advanced link
    Then i navigate to advanced search page

  @t1
  Scenario: search item
    Given i am on ebay home page
    When i search 'selenium webdriver'
    Then i validate at least 80 search items present

  @t2
  Scenario: search item in category
    Given i am on ebay home page
    When i search 'postman' in 'Books' category
    Then i validate at least 20 search items present
	@t6
  Scenario Outline: home page links
    Given i am on ebay home page
    When i click on '<link>'
    Then i validet i navigate to '<url>' and title contains '<title>'

    Examples: 
      | link         | url                                                                | title                                  |
      | Motors       | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334     | eBay Motors: Auto Parts and Vehicles   |
      | Electronics  | https://www.ebay.com/b/Electronics/bn_7000259124                   | Electronics products for sale          |
      | Collectibles | https://www.ebay.com/b/Collectibles-Art/bn_7000259855              | Collectibles & Art products for sale   |
      | Fashion      | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Clothing, Shoes & Accessories for sale |
