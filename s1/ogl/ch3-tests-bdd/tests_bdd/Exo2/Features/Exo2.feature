Feature: Exo2
  Scenario: Adding product to cart ebay
    Given I am in the page "https://www.ebay.com"
    When I search for "shoes for men"
    And I choose "Men’s lightweight casual running shoes White" as product
    And I select "Black" as color and "UK 10" as size
    And I add the product to the cart
    Then I expect "GBP 24.99" as a total price