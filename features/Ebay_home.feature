#ce projet cree par Krimou
#email:krimou@gamil.com le 03/05/2023
Feature: home page ebay
  ce feature pour tester les fonctionnalités de home ebay

  @smoke
  Scenario: advanced search link
    Given i am on ebay home page
    When i click on advanced link
    Then i navigate to advanced search page
